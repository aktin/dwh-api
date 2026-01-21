package org.aktin.dwh.optinout.model;

// errors that occur during CRUD operations on opt-in data
public enum ErrorType {
    STUDY_NOT_FOUND,
    PATIENT_NOT_FOUND,
    PATIENT_ALREADY_EXISTS,
    SIC_ALREADY_EXISTS,
}
