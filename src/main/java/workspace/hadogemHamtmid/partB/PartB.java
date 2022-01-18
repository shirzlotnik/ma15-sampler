package workspace.hadogemHamtmid.partB;

import workspace.hadogemHamtmid.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.ExtractManager;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.load.DefaultLoadToFile;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;
import workspace.hadogemHamtmid.partB.transform.UpgradedLabTest;

import java.util.List;

public class PartB {

    public PartB (LoadManager loadManager, ReadProperties rp, ExtractManager extractManager) {
        final String XML_DIRECTORY_PATH = rp.getProperty("XML_DIRECTORY_PATH");
        final String LAB_TEST_FILE_PATH = rp.getProperty("LAB_TEST_FILE_PATH");

        DefaultExtractionFromFile elt = extractManager.getExtractManager("csv").getExtractor("LabTest");
        List<LabTest> tests = elt.extract(LAB_TEST_FILE_PATH);
        UpgradedLabTest upgradedLabTest = new UpgradedLabTest();
        List<LabTestPlusHealthCare> upgradedTest = upgradedLabTest.addHealthCareProvider(tests);
        DefaultLoadToFile ltXML = loadManager.getLoadFile("xml");

        ltXML.load(XML_DIRECTORY_PATH, upgradedTest);

    }
}
