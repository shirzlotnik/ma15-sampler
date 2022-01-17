package workspace.hadogemHamtmidB.labTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement (name = "labTests")
public class LabTests {
    List<LabTest> tests;

}
