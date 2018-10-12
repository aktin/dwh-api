package org.aktin.dwh;

import java.security.Principal;

public interface Authentication extends Principal{
	@Override
	String getName();

	// TODO : correct JavaDoc
	/**
	 * Determine whether the user has the given role assigned.
	 * @return true if role is assigned, false otherwise
	 */
	String getRole();

	/** Determine whether this user has admin privileges.
	 * 
	 * @return  true if the user has administrative rights
	 */
	boolean isAdmin();
}
