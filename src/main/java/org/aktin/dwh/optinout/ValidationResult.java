package org.aktin.dwh.optinout;
/**
 * Validation result of a inserted entry data
 */
public enum ValidationResult {
    // User Input States
    DUPLICATE_PAT_REF, // User entered a patient reference at least twice
    DUPLICATE_SIC, // User entered a SIC at least twice

    // Database States
    ENTRY_FOUND, // Patient entry already exists
    SIC_FOUND, // SIC already exists
    MASTER_DATA_NOT_FOUND, // No master data in db found
    ENCOUNTERS_NOT_FOUND, // No encounters in db found

    // Processing States
    VALID,
    PENDING, // Validation has not occurred yet
}
