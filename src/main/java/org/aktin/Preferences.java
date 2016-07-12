package org.aktin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Preferences {

	String group();
	// TODO add Class<?> validator() to validate preferences
}