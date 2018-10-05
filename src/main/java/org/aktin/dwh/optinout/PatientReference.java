package org.aktin.dwh.optinout;

public enum PatientReference {
	/** patient specific id */
	Patient,
	/** visit id, a visit can contain multiple encounters */
	Visit,
	/** encounter (with a practitioner) */
	Encounter,
	/** billing / accounting number of the hospital, used for financial transactions */
	Billing
}
