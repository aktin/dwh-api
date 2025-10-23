package org.aktin.dwh.optinout;

import java.time.Instant;

public interface PatientMasterData {
    int getPatientId();
    String getSex();
    String getZip();
    Instant getBirthDate();
}
