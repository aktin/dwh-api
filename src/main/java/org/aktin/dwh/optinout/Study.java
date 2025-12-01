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

	/**
	 * when the study was closed. {@code null} if still open
	 */
	Instant getClosedTimestamp();

	/**
	 * Get the participation option for this study.
	 * @return participation option
	 */
	Participation getParticipation();
	
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

	/**
	 * Get the generator of automatic SIC generation.
	 * @return generator name or {@code null} if no generator is used
	 */
	String getSicGenerator();

	/**
	 * Get the state of the generator.
	 * @return generator state (e.g. last generated SIC (sequence))
	 */
	String getSicGeneratorState();

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
	 * Persists multiple patients
	 * @param patients patient entries
	 * @param user creator
	 * @return list of created entries
	 * @throws IOException
	 */
	List<PatientEntry> addPatients(List<PatientEntryData> patients, String user) throws IOException;

	/**
	 * Validates a list of patient entry data and returns a map associating each entry with a list of validation results.
	 * This method is used to ensure that the provided patient data complies with predefined validation rules.
	 *
	 * @param entries the list of {@link PatientEntryData} objects representing the patient entries to validate.
	 * @return a map where each {@link PatientEntryData} is associated with a list of {@link ValidationResult} objects
	 *         indicating the outcome of the validation process for that entry. When list is empty, the entry is valid.
	 * @throws IOException if there is an I/O exception during the validation process.
	 */
	Map<PatientEntryData, List<ValidationResult>> validatePatients(List<PatientEntryData> entries) throws IOException;

	/**
	 * Update an old entry
	 * @param oldEntry entry to be updated
	 * @param newEntry new entry
	 * @return updated entry
	 * @throws IOException
	 */
	PatientEntry updatePatient(PatientReference ref, String root, String extension, PatientEntryData newData, String user) throws IOException;

	/**
	 * Delete a patient entry
	 * @param ref patient reference
	 * @param root patient root id
	 * @param extension patient extension
	 * @param user user who requested the deletion
	 * @throws IOException
	 */
	void deletePatient(PatientReference ref, String root, String extension, String user) throws IOException;

	/**
	 * Load master data for a patient
	 * @return master data of the patient or null if no master data was found
	 * @throws IOException
	 */
	PatientMasterData loadMasterData(PatientReference ref, String root, String extension) throws IOException;

	/**
	 * load all encounters for a patient
	 * @return List of encounters
	 * @throws IOException
	 */
	List<PatientEncounter> loadEncounters(PatientReference ref, String root, String extension) throws IOException;
}
