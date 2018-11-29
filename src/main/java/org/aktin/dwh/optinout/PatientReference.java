package org.aktin.dwh.optinout;

public enum PatientReference {
	/** patient specific id 
	 * CDA element: /ClinicalDocument/recordTarget/patientRole/id
	 */
	Patient,
	/** visit id, a visit can contain multiple encounters 
	 * Not used in this project.
	 */
	Visit,
	/** encounter (with a practitioner) 
	 * CDA element: /ClinicalDocument/componentOf/encompassingEncounter/id[1]
	 */
	Encounter,
	/** billing / accounting number of the hospital, used for financial transactions 
	 * CDA element: /ClinicalDocument/componentOf/encompassingEncounter/id[2]
	 */
	Billing
}
