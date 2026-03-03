package org.aktin.dwh.optinout.model;

import java.time.Instant;

public interface PatientEncounterPeriod {
    String getIde();
    Instant getStartDate();
    Instant getEndDate();
}

