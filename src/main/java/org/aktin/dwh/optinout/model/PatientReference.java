package org.aktin.dwh.optinout.model;

import java.util.Arrays;

public enum PatientReference {
	/** patient specific id 
	 * CDA element: /ClinicalDocument/recordTarget/patientRole/id
	 * hash in i2b2 DB: i2b2crcdata.patient_mapping in column patient_ide [type: character varying(200) 
	 */
	Patient("PAT"),
	/** visit id, a visit can contain multiple encounters 
	 * Not used in this project.
	 */
	Visit("VIS"),
	/** encounter (with a practitioner) 
	 * CDA element: /ClinicalDocument/componentOf/encompassingEncounter/id[1]
	 * hash in i2b2 DB: i2b2crcdata.encounter_mapping in column encounter_ide [type: character varying(200) 
	 */
	Encounter("ENC"),
	/** billing / accounting number of the hospital, used for financial transactions 
	 * CDA element: /ClinicalDocument/componentOf/encompassingEncounter/id[2]
	 * hash in i2b2 DB: i2b2crcdata.observation_fact in column tval_char where concept_cd=AKTIN:Fallkennzeichen [type: character varying(255)]
	 */
	Billing("BIL");


	/**
	 * helper functions for (de-)serialization
	 */

	private final String code;

	PatientReference(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static PatientReference fromCode(String code) {
		return Arrays.stream(values()).filter(a -> a.code.equals(code)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Unknown value: " + code));
	}
}
