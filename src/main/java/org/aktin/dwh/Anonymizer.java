package org.aktin.dwh;

public interface Anonymizer {

	public String calculatePatientPseudonym(String root, String extension);
	public String calculateEncounterPseudonym(String root, String extension);
	
}
