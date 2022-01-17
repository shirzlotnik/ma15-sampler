package workspace.hadogemHamtmidB.labTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

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

    public LabTest (LabTest l) {
        IDNum = l.IDNum;
        IDType = l.IDType;
        FirstName = l.FirstName;
        LastName = l.LastName;
        ResultDate = l.ResultDate;
        BirthDate = l.BirthDate;
        LabCode = l.LabCode;
        StickerNumber = l.StickerNumber;
        ResultTestCorona = l.ResultTestCorona;
        Variant = l.Variant;
        TestType = l.TestType;
    }

}
