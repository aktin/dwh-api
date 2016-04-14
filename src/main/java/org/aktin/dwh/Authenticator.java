package org.aktin.dwh;

public interface Authenticator {
	/**
	 * Determine whether the given user and password combination is granted
	 * the given role.
	 * @param user user name
	 * @param password password
	 * @param role role
	 * @return true if all criteria are matched, false otherwise
	 */
	boolean verifyUserRole(String user, char[] password, String role);
	
	/**
	 * Determine whether a given user and password combination
	 * has admin privileges.
	 * 
	 * @param user user name
	 * @param password password
	 * @return true if the user is admin and the password is correct
	 */
	boolean verifyAdmin(String user, char[] password);
}
