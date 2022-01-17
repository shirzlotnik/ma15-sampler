package workspace.hadogemHamtmid.partB.load.toFormat.xml;

import com.thoughtworks.xstream.XStream;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTests;
import workspace.hadogemHamtmid.partB.load.toFormat.abstraction.MakeFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class MakeXMLFormat implements MakeFormat<LabTest> {

    @Override
    public String makeListFormat(List<LabTest> list) {
        LabTests labTests = new LabTests(list);
        XStream xstream = new XStream();
        xstream.alias("labTest", LabTest.class);
        xstream.alias("labTests", LabTests.class);
        
        String xml = xstream.toXML(list);
        return xml;
    }
}
