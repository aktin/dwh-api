package org.aktin.dwh;

public interface Authenticator {
	
	Authentication authenticate(String user, char[] password);
	
}
