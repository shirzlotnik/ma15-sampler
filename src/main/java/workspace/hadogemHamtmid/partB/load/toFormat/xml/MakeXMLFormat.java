package workspace.hadogemHamtmid.partB.load.toFormat.xml;

import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.load.toFormat.abstraction.MakeFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class MakeXMLFormat implements MakeFormat<LabTest> {



    @Override
    public String makeFormat(LabTest labTest) {
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

    @Override
    public String makeListFormat(List<LabTest> list) {
        String xml = "<labTests>\n";
        for (LabTest test:list) {
            String line = makeFormat(test);
            if (line != null) {
                xml += line + "\n";
            }
        }
        xml += "</labTests>";
        return xml;
    }
}
