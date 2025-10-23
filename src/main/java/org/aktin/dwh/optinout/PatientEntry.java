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
	void setSIC(String sic);
	String getUser();
	void setUser(String user);
	Instant getTimestamp();
	void setTimestamp(Instant timestamp);
	String getComment();
	void setComment(String comment);

	/**
	 * Get the i2b2 patient_num field. Only available, if the patient was linked
	 * to existing data. The link is established automatically and periodically
	 * @return patient_num from i2b2, or {@code null} if no link is available.
	 */
	Integer getI2b2PatientNum();
	void setI2b2PatientNum(Integer i2b2PatientNum);

	/**
	 * Delete this entry
	 * @param user user name who requested the delete operation
	 * @throws FileNotFoundException if the patient was not found
	 * @throws IOException any other IO error
	 */
	void delete(String user) throws FileNotFoundException, IOException;

	/**
	 * Determine whether a second patient is equal (study, pat_ref,pat_root,pat_ext)
	 * @param other other entry
	 * @return true if the ids are equal, false otherwise
	 */
	boolean equalsId(PatientEntry other);
}
