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
	public void setValue(T value, String user);
	
	/**
	 * Set the value by the system user
	 * @param value value
	 */
	public void setValue(T value);
	
	/**
	 * Set the value to the given string representation. The value
	 * is changed by the system user.
	 * @param value string representing the value
	 * @throws IllegalArgumentException if the string conversion fails
	 */
	public void setValueString(String value) throws IllegalArgumentException;

	/**
	 * Set the value to the given string representation. The specified
	 * user name is used to perform the change.
	 * 
	 * @param value string value
	 * @param user user name
	 * @throws IllegalArgumentException if string conversion fails
	 */
	public void setValueString(String value, String user) throws IllegalArgumentException;
}
