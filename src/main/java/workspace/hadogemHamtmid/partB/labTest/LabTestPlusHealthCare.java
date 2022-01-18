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

    public LabTestPlusHealthCare(String IDNum, String IDType, String FirstName, String LastName,
                                 String ResultDate, String BirthDate, String LabCode, String StickerNumber,
                                 String ResultTestCorona, String Variant, String TestType, LocalDate joinDate,
                                 int healthCardID, String healthCardName) {
        super(IDNum, IDType, FirstName, LastName, ResultDate, BirthDate, LabCode, StickerNumber, ResultTestCorona,
                Variant, TestType);
        JoinDate = joinDate;
        HealthCardID = healthCardID;
        HealthCardName = healthCardName;
    }
}
