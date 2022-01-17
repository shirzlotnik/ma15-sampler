package workspace.hadogemHamtmid.partB;

import workspace.hadogemHamtmid.CSVExtractManager;
import workspace.hadogemHamtmid.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.load.DefaultLoadToFile;
import workspace.hadogemHamtmid.partB.extract.ExtractLabTestsFromCSV;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.load.LoadToXML;

import java.io.IOException;
import java.util.List;

public class PartB {

    public PartB (LoadManager loadManager, ReadProperties rp, CSVExtractManager csvExtractManager) {
        final String XML_DIRECTORY_PATH = rp.getProperty("XML_DIRECTORY_PATH");
        final String LAB_TEST_FILE_PATH = rp.getProperty("LAB_TEST_FILE_PATH");

        DefaultExtractionFromFile elt = csvExtractManager.getExtractor("LabTest");
        List<LabTest> tests = elt.extract(LAB_TEST_FILE_PATH);
        DefaultLoadToFile ltXML = loadManager.getLoadFile("xml");

        ltXML.load(XML_DIRECTORY_PATH, tests);

    }
}
