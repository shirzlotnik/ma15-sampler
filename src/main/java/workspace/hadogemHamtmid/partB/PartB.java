package workspace.hadogemHamtmid.partB;

import workspace.hadogemHamtmid.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partB.extract.ExtractLabTestsFromCSV;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.load.LoadToXML;

import java.io.IOException;
import java.util.List;

public class PartB {

    public PartB (LoadManager loadManager) {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final String XML_DIRECTORY_PATH = rp.getProperty("XML_DIRECTORY_PATH");
        final String LAB_TEST_FILE_PATH = rp.getProperty("LAB_TEST_FILE_PATH");

        ExtractLabTestsFromCSV elt = new ExtractLabTestsFromCSV();
        List<LabTest> tests = elt.extract(LAB_TEST_FILE_PATH);
        LoadToXML ltXML = (LoadToXML) loadManager.getLoadFile("xml");

        ltXML.load(XML_DIRECTORY_PATH, tests);

    }
}
