package org.aktin.dwh;

public interface Anonymizer {

	public default String calculatePatientPseudonym(String root, String extension){
		return calculateAbstractPseudonym(root, extension);
	}
	public default String calculateEncounterPseudonym(String root, String extension){
		return calculateAbstractPseudonym(root, extension);
	}
	public String calculateAbstractPseudonym(String ...parts);
}
