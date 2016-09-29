package org.aktin;

public abstract class Module {

	public String getVersion(){
		return getClass().getPackage().getImplementationVersion();
	}
	
}
