package org.aktin.dwh.optinout;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interface for validating patient data in a study context. The purpose of this interface
 * is to ensure that the provided patient data meets the requirements and validation rules
 * defined for a specific study.
 */
public interface PatientValidator {
    /**
     * Validates a list of patient entry data for a specific study and associates each entry with its respective validation results.
     * This method ensures that the provided patient data complies with the validation rules defined for the given study.
     *
     * @param studyId the unique identifier for the study in which the patients are being validated.
     * @param patients the list of {@link PatientEntryData} objects representing the patient entries to be validated.
     * @return a map where each {@link PatientEntryData} is associated with a list of {@link ValidationResult} objects
     *         indicating the outcome of the validation process for that entry. An empty list indicates the entry is valid.
     */
    Map<PatientEntryData, List<ValidationResult>> validatePatients(String studyId, List<PatientEntryData> patients) throws IOException;
}
