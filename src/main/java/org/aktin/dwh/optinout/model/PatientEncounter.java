package org.aktin.dwh.optinout.model;

import java.time.Instant;

public interface PatientEncounter {
    String getIdEnc();
    Instant getStartDate();
    Instant getEndDate();
}
