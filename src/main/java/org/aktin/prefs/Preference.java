package org.aktin.prefs;

/**
 * All preferences can be read/written by the API (system).
 * Some preferences might be readable/writable publicly
 * e.g. by an authenticated user.
 * 
 * @author R.W.Majeed
 *
 * @param <T> value type
 */
public interface Preference<T> {
	Preferences getPreferences();
	/**
	 * Get the preference value data type
	 * @return data type for the value
	 */
	Class<T> getType();
	/**
	 * Get the preference value
	 * @return value
	 */
	T getValue();
	/**
	 * Get the preference name / key
	 * @return key name
	 */
	String getKey();
	
	boolean isPublicWritable();
	boolean isPublicReadable();
	
	/**
	 * Perform a public update by user
	 * @param user user name
	 * @param value value
	 */
	public void setValue(String user, T value);
	
	/**
	 * Set the value by the system user
	 * @param value value
	 */
	public void setValue(T value);
}
