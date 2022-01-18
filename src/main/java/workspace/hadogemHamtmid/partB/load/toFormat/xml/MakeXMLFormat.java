package workspace.hadogemHamtmid.partB.load.toFormat.xml;

import com.thoughtworks.xstream.XStream;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;
import workspace.hadogemHamtmid.partB.labTest.LabTests;
import workspace.hadogemHamtmid.partB.load.toFormat.abstraction.MakeFormat;

import java.util.List;

public class MakeXMLFormat implements MakeFormat<LabTest> {

    @Override
    public String makeListFormat(List<LabTest> list) {
        LabTests labTests = new LabTests(list);
        XStream xstream = new XStream();
        xstream.alias("labTest", LabTest.class);
        xstream.alias("labTests", LabTests.class);
        xstream.alias("labTest", LabTestPlusHealthCare.class);

        String xml = xstream.toXML(labTests);
        return xml;    }
}
