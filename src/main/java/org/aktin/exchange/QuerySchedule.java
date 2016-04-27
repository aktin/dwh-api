package org.aktin.exchange;

import java.time.Period;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Abstract query schedule
 * @author R.W.Majeed
 *
 */
@XmlSeeAlso({SingleExecution.class, RepeatedExecution.class})
public abstract class QuerySchedule {

	/**
	 * Duration for the query. The duration is relative
	 * to the {@link #reference} timestamp and might also be negative.
	 */
	@XmlElement(required=true)
	public Period duration;

}
