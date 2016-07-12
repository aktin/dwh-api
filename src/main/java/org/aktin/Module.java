package org.aktin;

public abstract class Module implements Configurable{

	public String getVersion(){
		return getClass().getPackage().getImplementationVersion();
	}
	
}
