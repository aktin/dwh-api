package org.aktin.dwh;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

/**
 * Qualifier indicating that the object/event should be e-mailed.
 *
 * @author R.W.Majeed
 *
 */
@Qualifier
//@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
public @interface EMail {

}
