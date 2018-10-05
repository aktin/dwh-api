package org.aktin.dwh.optinout;

import java.io.IOException;

public interface StudyManager {

	Iterable<Study> getStudies() throws IOException;

	/**
	 * Try to link all entries which have not been linked yet to
	 * the actual existing data. After a successful link has been established,
	 * the {@link PatientEntry#getI2b2PatientNum()} will be not {@code null}.
	 * @throws IOException IO error
	 */
	void linkPatientEntriesToData() throws IOException;
}
