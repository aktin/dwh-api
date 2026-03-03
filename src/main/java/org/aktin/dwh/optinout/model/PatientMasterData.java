package org.aktin.dwh.optinout.model;

import java.time.Instant;

public interface PatientMasterData {
    String getIde();
    String getSex();
    String getZip();
    Instant getBirthDate();
}
