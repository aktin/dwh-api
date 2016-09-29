package org.aktin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * AKTIN preference. Can be used to inject preference values into any class.
 * The preferences can not be changed during runtime.
 * 
 *
 * @author R.W.Majeed
 *
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR })
public @interface Preference {
	// no default meaning a value is mandatory
	//@Nonbinding
	String name();
}
