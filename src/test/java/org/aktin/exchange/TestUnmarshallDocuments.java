package org.aktin.exchange;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXB;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class TestUnmarshallDocuments {
	XMLReader reader;
	Validator validator;
	
	@Before
	public void initializeXIncludeReader() throws SAXException{
		SAXParser parser;
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setXIncludeAware(true);
			factory.setNamespaceAware(true);
			// do not insert xml:base attributes for XIncludes
			factory.setFeature("http://apache.org/xml/features/xinclude/fixup-base-uris", false);
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			throw new SAXException(e);
		}
		reader = parser.getXMLReader();
	}
	@Before
	public void initializeValidator() throws IOException, SAXException{
		URL xsd = getClass().getResource("/schemagen/schema1.xsd");
        SchemaFactory factory = 
	            SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema;
        try( InputStream in = xsd.openStream() ){
        	schema = factory.newSchema(new StreamSource(in));
        }
        
	    validator = schema.newValidator();		
	}

	private Source getResource(URL url){
		SAXSource xml = new SAXSource(reader, new InputSource(url.toString()));
		//xml.setSystemId(doc.toString());
		return xml;
	}
	private Source getResource(String name){
		return getResource(getClass().getResource(name));
	}
	
	@Test
	public void validateQuery() throws IOException, SAXException{
		validator.validate(getResource("/query.xml"));
	}
	@Test
	public void unmarshallQuery() throws IOException, SAXException{
		Source xml = getResource("/query.xml");
			Query query = JAXB.unmarshal(xml, Query.class);
			Assert.assertEquals(query.schedule.getClass(), SingleExecution.class);
			SingleExecution se = (SingleExecution)query.schedule;
			Assert.assertNotNull(se.duration);
			Assert.assertNotNull(se.reference);
			//System.out.println("Duration:"+se.duration);
			//System.out.println("Reference:"+se.reference);

			
			// print XML output
			//se.duration = Period.ofMonths(1);
			//se.reference = Instant.now();
			//JAXB.marshal(query, System.out);
			
	}
	@Test
	public void validateQueryRequest() throws IOException, SAXException, TransformerException{
		validator.validate(getResource("/request.xml"));

	}

}