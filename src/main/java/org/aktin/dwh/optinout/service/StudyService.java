package org.aktin.dwh.optinout.service;

import org.aktin.dwh.optinout.model.Study;

import java.io.IOException;
import java.util.List;

public interface StudyService {
	/**
	 * Get all studies.
	 * @return list of studies
	 * @throws IOException
	 */
	List<? extends Study> getStudies() throws IOException;
}
