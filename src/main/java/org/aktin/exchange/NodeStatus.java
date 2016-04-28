package org.aktin.exchange;

/**
 * Status for a data warehouse node
 * 
 * @author R.W.Majeed
 *
 */
public class NodeStatus {
	
	public NodeStatus(){
		apiVersion = getClass().getPackage().getImplementationVersion();
	}
	/**
	 * Version of the dwh-api component
	 */
	String apiVersion;
}
