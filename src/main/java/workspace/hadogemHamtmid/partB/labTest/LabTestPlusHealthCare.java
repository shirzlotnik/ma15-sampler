package workspace.hadogemHamtmid.partB.labTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement (name = "labTest")
public class LabTestPlusHealthCare extends LabTest {
    LocalDate JoinDate;
    int HealthCardID;
    String HealthCardName;

    public LabTestPlusHealthCare(String idNum, String idType, String firstName, String lastName, String resultDate,
                                 String birthDate, String labCode, String stickerNumber, String resultTestCorona,
                                 String variant, String testType, LocalDate joinDate, int healthCareId,
                                 String healthCareName) {
        super(idNum, idType, firstName, lastName, resultDate, birthDate, labCode, stickerNumber, resultTestCorona,
                variant, testType);
        this.JoinDate = joinDate;
        this.HealthCardID = healthCareId;
        this.HealthCardName = healthCareName;
    }
}
