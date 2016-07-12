package org.aktin.exchange;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Element;


/**
 * Query which can be executed in an i2b2
 * data warehouse by the AKTIN remote query 
 * plugin.
 * 
 * @author R.W.Majeed
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Query {

	/**
	 * Unique identifier for this query. This identifier
	 * will not change, even if a query scheduled for repeated
	 * executions.
	 */
	@XmlElement(required=true)
	public String id;
	
	/**
	 * Human readable description of the query.
	 */
	@XmlElement(required=true)
	public String description;
	
	/**
	 * Contact for inquiries and further
	 * information about the query and research
	 * project.
	 */
	@XmlElement(required=true)
	public Principal principal;

	/**
	 * Execution schedule for the query. For now,
	 * only {@link SingleExecution} and {@link RepeatedExecution} 
	 * are supported.
	 */
	@XmlElement(required=true)
	public QuerySchedule schedule;
	
	@XmlAnyElement
	public List<Element> extensions;

}
