package org.aktin.dwh.optinout;

import java.time.Instant;

public interface PatientMasterData {
    String getPseudonym();
    String getSex();
    String getZip();
    Instant getBirthDate();
}
