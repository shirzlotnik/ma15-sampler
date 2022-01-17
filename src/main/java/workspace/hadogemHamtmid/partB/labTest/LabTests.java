package workspace.hadogemHamtmid.partB.labTest;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "labTests")
@AllArgsConstructor
public class LabTests {
    List<LabTest> labTests;


}
