package workspace.hadogemHamtmid.partB;

import workspace.hadogemHamtmid.ETLManagers.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.ETLManagers.ExtractManager;
import workspace.hadogemHamtmid.ETLManagers.TransformManager;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;
import workspace.hadogemHamtmid.partB.transform.abstraction.DefaultTransformer;

import java.util.List;

public class PartB {

    public PartB (LoadManager loadManager, ReadProperties rp, ExtractManager extractManager) {
        final String XML_DIRECTORY_PATH = rp.getProperty("XML_DIRECTORY_PATH");
        final String LAB_TEST_FILE_PATH = rp.getProperty("LAB_TEST_FILE_PATH");
        final String TRANSFORMER_PART_B = rp.getProperty("TRANSFORMER_PART_B");
        final String EXTRACTOR_PART_B = rp.getProperty("EXTRACTOR_PART_B");
        final String LOADER_PART_B = rp.getProperty("LOADER_PART_B");
        final String EXTRACTOR_MANAGER_PART_B = rp.getProperty("EXTRACTOR_MANAGER_PART_B");

        DefaultExtractionFromFile elt = extractManager.getExtractManager(EXTRACTOR_MANAGER_PART_B)
                .getExtractor(EXTRACTOR_PART_B);
        List<LabTest> tests = elt.extract(LAB_TEST_FILE_PATH);
        TransformManager transformManager = new TransformManager();
        DefaultTransformer defaultTransformer = transformManager.getTransformer(TRANSFORMER_PART_B);
        List<LabTestPlusHealthCare> upgradedTest = defaultTransformer.upgrade(tests);
        DefaultLoadToFile ltXML = loadManager.getLoadFile(LOADER_PART_B);

        ltXML.load(XML_DIRECTORY_PATH, upgradedTest);

    }
}
