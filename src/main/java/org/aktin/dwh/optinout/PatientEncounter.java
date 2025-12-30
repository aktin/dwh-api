package org.aktin.dwh.optinout;

import java.time.Instant;

public interface PatientEncounter {
    String getPseudonym();
    String getEncounterId();
    Instant getStartDate();
    Instant getEndDate();
}
