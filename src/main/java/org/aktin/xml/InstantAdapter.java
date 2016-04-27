package org.aktin.xml;

import java.time.Instant;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * JAXB adapter for processing java.time.Instant.
 * This can be removed later on when native support is added to the JAXB implementation
 *
 */
public class InstantAdapter extends XmlAdapter<String, Instant>{

	@Override
	public Instant unmarshal(String v) throws Exception {
		if( v == null )return null;
		else return Instant.parse(v);
	}

	@Override
	public String marshal(Instant v) throws Exception {
		if( v == null )return null;
		else return v.toString();
	}
	
}