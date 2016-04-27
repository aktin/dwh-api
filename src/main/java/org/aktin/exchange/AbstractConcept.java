package org.aktin.exchange;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({RawConcept.class})
public abstract class AbstractConcept {

	/**
	 * Unique identifier of the concept.
	 */
	@XmlAttribute
	public String id;
}
