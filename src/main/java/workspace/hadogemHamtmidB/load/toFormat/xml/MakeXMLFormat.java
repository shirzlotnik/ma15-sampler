package workspace.hadogemHamtmidB.load.toFormat.xml;

import workspace.hadogemHamtmidB.labTest.LabTest;
import workspace.hadogemHamtmidB.load.toFormat.abstraction.MakeFormat;
import workspace.hadogemHamtmidB.transform.UpgradeLabTests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class MakeXMLFormat implements MakeFormat<UpgradeLabTests> {


    @Override
    public String makeFormat(LabTest labTest, String type) {
        String xml = null;
        try {
            JAXBContext context = JAXBContext.newInstance(LabTest.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(labTest, sw);
            xml = sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
