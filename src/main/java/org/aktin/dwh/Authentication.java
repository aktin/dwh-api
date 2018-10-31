package org.aktin.dwh;

import java.security.Principal;

public interface Authentication extends Principal{
	@Override
	String getName();

	/**
	 * Determines the role that is assigned to the user.
	 * @return the assigned role
	 */
	String getRole();

	/** Determine whether this user has admin privileges.
	 * 
	 * @return  true if the user has administrative rights
	 */
	boolean isAdmin();
}
