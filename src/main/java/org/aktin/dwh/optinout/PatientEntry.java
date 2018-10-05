package org.aktin.dwh.optinout;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PatientEntry {

	Study getStudy();
	Participation getParticipation();
	PatientReference getReference();
	String getIdRoot();
	String getIdExt();
	String getSIC();
	String getUser();
	String getComment();
	
	/**
	 * Get the i2b2 patient_num field. Only available, if the patient was linked
	 * to existing data. The link is established automatically and periodically
	 * @return patient_num from i2b2, or {@code null} if no link is available.
	 */
	Integer getI2b2PatientNum();

	/**
	 * Delete this entry
	 * 
	 * @throws FileNotFoundException if the patient was not found
	 * @throws IOException any other IO error
	 */
	void delete() throws FileNotFoundException, IOException;
}
