package org.aktin.dwh.optinout;

import java.time.Instant;

public interface PatientEntry {
	Participation getParticipation();
	PatientReference getReference();
	String getIdRoot();
	String getIdExt();
	String getSIC();
	String getUser();
	Instant getTimestamp();
	String getComment();

	/**
	 * Get the i2b2 patient_num field. Only available, if the patient was linked
	 * to existing data. The link is established automatically and periodically
	 * @return patient_num from i2b2, or {@code null} if no link is available.
	 */
	Integer getI2b2PatientNum();
}
