package org.aktin.dwh.optinout.service;

import org.aktin.dwh.optinout.model.*;

import java.io.IOException;
import java.util.List;

public interface PatientService {
    /**
     * Get all patients of a study.
     * @param studyId study id
     * @return list of patients
     * @throws IOException
     */
    List<PatientEntry> getAllPatientsOfStudy(String studyId) throws IOException;

    /**
     * Get a patient by ID.
     * @param studyId study id
     * @param ref patient reference
     * @param extension patient extension
     * @return patient entry
     * @throws IOException
     */
    PatientEntry getPatientByID(String studyId, PatientReference ref, String extension) throws IOException;

    /**
     * Add a list of patients to a study.
     * @param studyId study id
     * @param patientEntryData patient entries
     * @param user user who added the patients
     * @throws IOException
     */
    void addPatientsToStudy(String studyId, List<PatientEntryData> patientEntryData, String user) throws IOException;

    /**
     * Delete a patient from a study.
     * @param studyId study id
     * @param ref patient reference
     * @param extension patient extension
     * @param user user who deleted the patient
     * @throws IOException
     */
    void deletePatient(String studyId, PatientReference ref, String extension, String user) throws IOException;

    /**
     * Update a patient entry.
     * @param studyId study id
     * @param ref patient reference
     * @param extension patient extension
     * @param newData new patient data
     * @param user user who updated the patient
     * @throws IOException
     */
    void updatePatient(String studyId, PatientReference ref, String extension, PatientEntryData newData, String user) throws IOException;

    /**
     * Get all encounters for a patient.
     * @param ref patient reference
     * @param extension patient extension
     * @return list of encounters
     * @throws IOException
     */
    List<PatientEncounter> getEncounters(PatientReference ref, String extension) throws IOException;

    /**
     * Get master data (like sex, zip, etc.) for a patient.
     * @param ref patient reference
     * @param extension patient extension
     * @return master data
     * @throws IOException
     */
    PatientMasterData getMasterData(PatientReference ref, String extension) throws IOException;
}
