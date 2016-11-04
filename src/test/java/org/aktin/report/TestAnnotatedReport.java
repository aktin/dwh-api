package org.aktin.report;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Period;

import javax.xml.transform.Source;

import org.junit.Test;
import static org.junit.Assert.*;

@AnnotatedReport.Report(displayName="rname", description="rdesc", defaultPeriod="P1M")
@AnnotatedReport.Option(key="oname1", type=String.class, displayName="oname1", description="odesc1", defaultValue="odef1")
@AnnotatedReport.Option(key="report.optionBoolean", displayName="optionBoolean", type=Boolean.class)
public class TestAnnotatedReport extends AnnotatedReport {

	@Test
	public void verifyReportName(){
		assertEquals("rname", getName());
	}
	@Test
	public void verifyReportDescription(){
		assertEquals("rdesc", getDescription());
	}
	@Test
	public void verifyReportDefaultPeriod(){
		assertEquals(Period.ofMonths(1), getDefaultPeriod());
	}
	@Test
	@SuppressWarnings("unchecked")
	public void verifyOptions() throws Exception{
		ReportOption<?>[] options = getConfigurationOptions();
		assertEquals(2, options.length);
		ReportOption<String> str = null;
		ReportOption<Boolean> bool = null;
		for( ReportOption<?> opt : options ){
			if( opt.getType() == String.class ){
				str = (ReportOption<String>)opt;
			}else if( opt.getType() == Boolean.class ){
				bool = (ReportOption<Boolean>)opt;
			}else{
				throw new Exception("Unexpected option type "+opt.getType());
			}
		}
		assertNotNull(str);
		assertEquals("oname1", str.getDisplayName());

		assertNotNull(bool);
		assertEquals("optionBoolean", bool.getDisplayName());
	}
	@Override
	public Source getExportDescriptor() {
		return createStreamSource(getClass().getResource("/export-descriptor.xml"));
	}

	@Override
	public String[] copyResourcesForR(Path workingDirectory) throws IOException {
		return null;
	}

	@Override
	public String[] copyResourcesForFOP(Path workingDirectory) throws IOException {
		return null;
	}

}
