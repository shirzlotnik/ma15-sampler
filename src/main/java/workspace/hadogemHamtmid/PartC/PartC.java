package workspace.hadogemHamtmid.PartC;

import workspace.hadogemHamtmid.ETLManagers.ExtractManager;
import workspace.hadogemHamtmid.ETLManagers.LoadManager;
import workspace.hadogemHamtmid.PartC.crossInfo.CrossMadaReportAndLabTest;
import workspace.hadogemHamtmid.PartC.crossInfo.crossResults.CrossResults;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;

import java.util.List;

public class PartC {

    public PartC (LoadManager loadManager, ReadProperties rp, ExtractManager extractManager,
                  List<MadaReport> reports, List<LabTestPlusHealthCare> labTests) {
        final String POSITIVE_CORONA_PEOPLE_DIRECTORY_PATH = rp.getProperty("POSITIVE_CORONA_PEOPLE_DIRECTORY_PATH");
        String LOADER_PART_C = rp.getProperty("LOADER_PART_C");
        String POSITIVE_CORONA_DIRECTORY = rp.getProperty("POSITIVE_CORONA_PEOPLE_DIRECTORY_PATH");

        CrossMadaReportAndLabTest crossMadaReportAndLabTest = new CrossMadaReportAndLabTest();
        List<CrossResults> crossResults = crossMadaReportAndLabTest.crossDBs(reports, labTests);
        DefaultLoadToFile loader = loadManager.getLoadFile(LOADER_PART_C);
        loader.load(POSITIVE_CORONA_DIRECTORY, crossResults);
    }

}
