package org.aktin.dwh.optinout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public interface PatientEntry {

	Study getStudy();
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

	/**
	 * Determine whether a second patient is equal (study, pat_ref,pat_root,pat_ext)
	 * @param other other entry
	 * @return true if the ids are equal, false otherwise
	 */
	boolean equalsId(PatientEntry other);
}
