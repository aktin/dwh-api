package org.aktin.dwh.optinout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class serves as input POJO for (batch) patient entry write actions (create, update)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntryData {
    private String root;
    private String extension;
    private String sic;
    private String comment;
    private boolean generateSic;
    private Participation participation;
    private PatientReference reference;
}
