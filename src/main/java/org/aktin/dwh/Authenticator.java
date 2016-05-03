package org.aktin.dwh;

import java.security.Principal;

public interface Authenticator {
	
	Principal authenticate(String user, char[] password);
	boolean isUserInRole(Principal user, String role);
	/** Determine whether a given user has admin privileges.
	 * 
	 * @param user user
	 * @return  true if the user has administrative rights
	 */
	boolean isUserAdmin(Principal user);
	
	
	
	
}
