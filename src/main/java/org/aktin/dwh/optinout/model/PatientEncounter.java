package org.aktin.dwh.optinout.model;

import java.time.Instant;

public interface PatientEncounter {
    String getPseudonym();
    Instant getStartDate();
    Instant getEndDate();
}
