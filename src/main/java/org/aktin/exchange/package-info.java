/**
 * Interfaces for the AKTIN data exchange.
 * Requests for query executions, query definitions,
 * query responses.
 * 
 * @author R.W.Majeed
 *
 */
@XmlSchema(namespace=XMLConstants.XML_NAMESPACE,
elementFormDefault=XmlNsForm.QUALIFIED,
	xmlns = {
			
		@XmlNs(prefix = "xsi", namespaceURI = javax.xml.XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI) 
		//"http://www.w3.org/2001/XMLSchema-instance"
	}
)
@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters({
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(type=java.time.Duration.class,value=org.aktin.xml.DurationAdapter.class),
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(type=java.time.Period.class,value=org.aktin.xml.PeriodAdapter.class),
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(type=java.time.Instant.class,value=org.aktin.xml.InstantAdapter.class)
})

package org.aktin.exchange;
import javax.xml.bind.annotation.*;