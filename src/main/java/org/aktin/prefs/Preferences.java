package org.aktin.prefs;

import java.io.IOException;
/**
 * API for AKTIN preferences.
 * <p>
 * To access preferences, use a CDI injection
 * in your class (e.g with {@code javax.inject.Inject} 
 * annotation.
 * 
 * @author R.W.Majeed
 *
 */
public interface Preferences {
	public String getString(String key);
	public Integer getInteger(String key);

	public void putString(String key, String value);
	public void putInteger(String key, Integer value);
	
	public Preference<?> get(String key);
	/**
	 * Write the changed preferences to the underlying
	 * storage (e.g. database)
	 * @throws IOException flush error
	 */
	public void flush() throws IOException;
}
