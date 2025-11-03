package org.aktin.dwh.optinout;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public interface Study {

	/**
	 * Unique id (e.g. acronym) for the study. The id should consist only of URL-safe characters
	 * @return study id
	 */
	String getId();
	String getTitle();
	String getDescription();

	Instant getCreatedTimestamp();
	Instant getClosedTimestamp();

	boolean isOptIn();
	boolean isOptOut();

	
	/**
	 * Determine whether this study allows the specified participation option.
	 * A study may support multiple participation options.
	 * @param participation participation option (OptIn, OptOut)
	 * @return true if the study allows the specified option
	 */
	boolean isParticipationSupported(Participation participation);

	/**
	 * Get the method of SIC generation
	 * @return sic generation enum
	 */
	SICGeneration getSicGeneration();
	void setSicGeneration(SICGeneration sic);

	String getSicGenerator();
	void setSicGenerator(String sicGenerator);
	String getSicGeneratorState();
	void setSicGeneratorState(String sicGeneratorState);

	/**
	 * Validate the syndax for a (usually manually entered) subject identification code 
	 * @param sic code
	 * @return validation error message, or {@code null} if valid
	 */
	String validateSIC(String sic);

	/**
	 * Generate a new subject identification code (SIC). This is a transaction which
	 * guarantees that two calls never return the same SIC.
	 * @return locally unique SIC
	 * @throws UnsupportedOperationException if the study does not support generation of SICs
	 * @throws IllegalStateException if the generator is in an invalid state and unable to perform the next calculation
	 * @throws IOException for IO errors during state loading/saving
	 */
	String generateSIC() throws UnsupportedOperationException, IllegalStateException, IOException;

	/**
	 * Find a patient by his SIC. A patient does not necessarily need a SIC, therefore
	 * some entries might exist which cannot be found via this method
	 * @param sic subject identification code
	 * @return entry or {@code null} if not found
	 * @throws IOException IO error
	 */
	PatientEntry getPatientBySIC(String sic) throws IOException;

	/**
	 * Find a patient by their reference type, root id and extension
	 * @param ref Patient reference like Encounter id, billing number or patient id
	 * @param idRoot Root id, depends on the patient reference
	 * @param idExt unique patient extension
	 * @return Patient entry or null of not found
	 * @throws IOException
	 */
	PatientEntry getPatientByID(PatientReference ref, String idRoot, String idExt) throws IOException;

	/**
	 * Returns all patients registered in this study
	 * @return all patients registered in this study
	 * @throws IOException
	 */
	List<? extends PatientEntry> allPatients() throws IOException;

	/**
	 * Persists single patient
	 * @param ref Patient reference like Encounter id, billing number or patient id
	 * @param idRoot Root id, depends on the patient reference
	 * @param idExt unique patient extension
	 * @param opt participation, Opt-In or Opt-Out
	 * @param sic sic subject identification code
	 * @param comment
	 * @param user creator
	 * @return added patient entry
	 * @throws IOException
	 */
	PatientEntry addPatient(PatientReference ref, String idRoot, String idExt, Participation opt, String sic, String comment, String user) throws IOException;

	/**
	 * Persists multiple patients
	 * @param ref Patient reference like Encounter id, billing number or patient id
	 * @param idRoot Root id, depends on the patient reference
	 * @param entries map for unique patient extensions (key) and sics (value) - sic may be {@code null}
	 * @param opt participation, Opt-In or Opt-Out
	 * @param comment
	 * @param user creator
	 * @return list of created entries
	 * @throws IOException
	 */
	List<PatientEntry> addPatients(PatientReference ref, String idRoot, Map<String, String> entries, Participation opt, String comment, String user) throws IOException;

	/**
	 * Update an old entry
	 * @param oldEntry entry to be updated
	 * @param newEntry new entry
	 * @return updated entry
	 * @throws IOException
	 */
	PatientEntry updatePatient(PatientEntry oldEntry, PatientEntry newEntry) throws IOException;
}
