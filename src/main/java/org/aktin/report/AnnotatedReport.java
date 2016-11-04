package org.aktin.report;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.transform.stream.StreamSource;


public abstract class AnnotatedReport implements Report{

	private ReportOption<?>[] reportOptions;
	private Period defaultPeriod;
	private String id;
	
	public AnnotatedReport() throws IllegalArgumentException{
		reportOptions = scanAnnotatedOptions();
		AnnotatedReport.Report an = getClass().getAnnotation(AnnotatedReport.Report.class);
		if( an == null ){
			throw new IllegalArgumentException("Must specify the AbstractReport.Report annotation");
		}
		if( an.defaultPeriod().equals("") ){
			defaultPeriod = null;
		}else{
			defaultPeriod = Period.parse(an.defaultPeriod());
		}
		if( an.id().length() == 0 ){
			this.id = getClass().getCanonicalName();
		}else{
			this.id = an.id();
		}
	}

	protected StreamSource createStreamSource(URL url){
		StreamSource source = new StreamSource();
		source.setSystemId(url.toExternalForm());
		try {
			source.setInputStream(url.openStream());
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to read export descriptor", e);
		}
		return source;
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Report{
		/**
		 * Report id. If not specified, the {@link Class#getCanonicalName()} is used.
		 * @return
		 */
		String id() default "";
		String displayName();
		String description();
		String defaultPeriod() default "";
		String[] preferences() default {};
	}
	
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	protected @interface Options{
		Option[] value();
	}
	/**
	 * Report specific options can be declared at the type level.
	 *
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Options.class)
	protected @interface Option {
		/**
		 * option's display name. If not specified, the field name is used.
		 * @return display name
		 */
		String key();
		String displayName() default "";
		String description() default "";
		/**
		 * default value. If not specified, the following defaults are used:
		 * String type will be the empty string {@code ""}. All other types
		 * will have {@code null} as default.
		 * @return default value
		 */
		String defaultValue() default "";
		Class<?> type();
	}

	@SuppressWarnings("rawtypes")
	private static class AnnotatedOption implements ReportOption{
		private Option option;
		public AnnotatedOption(Option opt){
			this.option = opt;
		}

		@Override
		public String getDisplayName() {
			return option.displayName();
		}

		@Override
		public String getDescription() {
			return option.description();
		}

		@Override
		public Class<?> getType() {
			return option.type();
		}

		@Override
		public String defaultValue() {
			Class<?> c = getType();
			if( c == String.class ){
				return option.defaultValue();
			}else if( option.defaultValue().length() == 0 ){
				return null;
			}else if( c == Boolean.class ){
				return option.defaultValue().toString();
			}else{
				throw new UnsupportedOperationException("Option of type "+c.getName()+" not implemented");
			}
		}

		@Override
		public String getKey() {
			return option.key();
		}		
	}
	private ReportOption<?>[] scanAnnotatedOptions(){
		List<ReportOption<?>> options = new ArrayList<>();
		Option[] fields = getClass().getDeclaredAnnotationsByType(Option.class);
		for( int i=0; i<fields.length; i++ ){
			options.add(new AnnotatedOption(fields[i]));
		}
		return options.toArray(new ReportOption<?>[options.size()]);
	}

	@Override
	public final String getId(){
		return this.id;
	}
	@Override
	public final String getName() {
		return getClass().getAnnotation(AnnotatedReport.Report.class).displayName();
	}
	@Override
	public final String getDescription() {
		return getClass().getAnnotation(AnnotatedReport.Report.class).description();
	}
	@Override
	public final Period getDefaultPeriod() {
		return defaultPeriod;
	}
	@Override
	public final ReportOption<?>[] getConfigurationOptions() {
		return reportOptions;
	}

	@Override
	public final String[] getRequiredPreferenceKeys() {
		AnnotatedReport.Report an = getClass().getAnnotation(AnnotatedReport.Report.class);
		return an.preferences();
	}

	protected void copyClasspathResources(Path destination, String...names) throws IOException{
		Class<?> clazz = getClass();
		for( String file : names ){
			try( InputStream in = clazz.getResourceAsStream("/"+file) ){
				Objects.requireNonNull(in, "File not found in classpath of "+clazz.getName()+": "+file);
				Files.copy(in, destination.resolve(file));
			}
		}		
	}
}
