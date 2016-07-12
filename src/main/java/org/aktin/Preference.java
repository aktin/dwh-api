package org.aktin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * AKTIN preference. If the annotation is used, also implement the {@link Configurable} interface.
 * 
 * TODO add annotation processor to verify at compile time that each preference id is unique and method types are void(SingleArg)
 *
 * @author R.W.Majeed
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Preference {

	String id();
	String example() default "";
	
}
