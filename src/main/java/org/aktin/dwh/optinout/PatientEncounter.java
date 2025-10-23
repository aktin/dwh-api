package org.aktin.dwh.optinout;

import java.time.Instant;

public interface PatientEncounter {
    int getEncounterId();
    int getPatientId();
    Instant getStartDate();
    Instant getEndDate();
}
