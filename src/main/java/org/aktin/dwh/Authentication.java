package org.aktin.dwh;

import java.security.Principal;

public interface Authentication extends Principal{
	@Override
	String getName();

	/**
	 * Determine whether the user has the given role assigned.
	 * @param role role name
	 * @return true if role is assigned, false otherwise
	 */
	boolean hasRole(String role);

	/** Determine whether this user has admin privileges.
	 * 
	 * @return  true if the user has administrative rights
	 */
	boolean isAdmin();
}
