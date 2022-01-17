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
public class LabTest {
    String IDNum;
    String IDType;
    String FirstName;
    String LastName;
    String ResultDate;
    String BirthDate;
    String LabCode;
    String StickerNumber;
    String ResultTestCorona;
    String Variant;
    String TestType;
    LocalDate JoinDate;
    int HealthCardID;
    String HealthCardName;

}
