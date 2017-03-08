package org.aktin.report;

import java.util.Objects;

public interface ReportOption<T>{
	String getKey();
	String getDisplayName();
	String getDescription();
	
	/**
	 * Type of the option. 
	 * Permitted types are {@link String}, {@link Integer}, {@link Boolean} and {@link Enum}
	 * @return option type
	 */
	Class<T> getType();
	
	/**
	 * Default value for the option. {@code null} is permitted.
	 * @return default value
	 */
	public String defaultValue();
	
	/**
	 * Default equals implementation. Two options are equal if and only if
	 * key, type and default value are equal.
	 * @param other other option
	 * @param <U> option type
	 * @return true if this option is equal to the other option, false otherwise
	 */
	public default <U> boolean equals(ReportOption<U> other){
		return getKey().equals(other.getKey())
				&& getType().equals(other.getType())
				&& Objects.equals(this.defaultValue(), other.defaultValue());
	}
	/**
	 * Create a string option
	 * @param key key
	 * @param name name
	 * @param description description
	 * @param defaultValue default value
	 * @return option
	 */
	public static ReportOption<String> newStringOption(String key, String name, String description, String defaultValue){
		return new ReportOption<String>() {
			@Override
			public String getDisplayName() {return name;}

			@Override
			public String getDescription() {return description;}

			@Override
			public Class<String> getType() {return String.class;}

			@Override
			public String defaultValue() {return defaultValue;}

			@Override
			public String getKey() {return key;}
		};
	}
	public static ReportOption<Boolean> newBooleanOption(String key, String name, String description, Boolean defaultValue){
		return new ReportOption<Boolean>() {
			@Override
			public String getDisplayName() {return name;}

			@Override
			public String getDescription() {return description;}

			@Override
			public Class<Boolean> getType() {return Boolean.class;}

			@Override
			public String defaultValue() {return defaultValue.toString();}

			@Override
			public String getKey() { return key;}
		};
	}
}
