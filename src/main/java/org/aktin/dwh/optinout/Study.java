package org.aktin.dwh.optinout;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

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
	
	/**
	 * Determine whether this study allows the specified participation option.
	 * A study may support multiple participation options.
	 * @param participation participation option (OptIn, OptOut)
	 * @return true if the study allows the specified option
	 */
	boolean isParticipationSupported(Participation participation);
	
	/**
	 * Whether this study supports manual SIC entries or not.
	 * @return {@code true} if the study allows manual entry of SICs. {@code false} otherwise
	 */
	boolean supportsManualSICs();
	
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

	PatientEntry getPatientByID(PatientReference ref, String id_root, String id_ext) throws IOException;

	List<? extends PatientEntry> allPatients() throws IOException;

	PatientEntry addPatient(PatientReference ref, String id_root, String id_ext, Participation opt, String sic, String comment, String user) throws IOException;
}
