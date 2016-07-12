package org.aktin.exchange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class SoftwareModule {
	@XmlAttribute
	String id;
	String version;
	String url;
}
