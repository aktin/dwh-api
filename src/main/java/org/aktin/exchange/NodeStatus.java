package org.aktin.exchange;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Status for a data warehouse node
 * 
 * @author R.W.Majeed
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="node-status")
public class NodeStatus {
	
	public NodeStatus(){
	}
	/**
	 * Version of the dwh-api component
	 */
	Instant timestamp;
	Duration uptime;
	@XmlElement(name="module")
	List<SoftwareModule> modules;
}
