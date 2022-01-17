package workspace.hadogemHamtmidB.labTest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UpgradedLabTest extends LabTest{
    LocalDate JoinDate;
    int HealthCardID;
    String HealthCardName;


    public UpgradedLabTest (LabTest labTest, LocalDate JoinDate, int HealthCardID, String HealthCardName) {
        super(labTest);
        this.JoinDate = JoinDate;
        this.HealthCardID = HealthCardID;
        this.HealthCardName = HealthCardName;
    }
}
