package workspace.hadogemHamtmid;

import workspace.hadogemHamtmid.ETLManagers.ExtractManager;
import workspace.hadogemHamtmid.ETLManagers.LoadManager;
import workspace.hadogemHamtmid.PartC.PartC;
import workspace.hadogemHamtmid.partA.PartA;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;
import workspace.hadogemHamtmid.partB.PartB;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));
        LoadManager loadManager = new LoadManager(MAX_OBJECTS, rp);
        ExtractManager extractManager = new ExtractManager();

        PartA A = new PartA(loadManager, extractManager);

        PartB B = new PartB(loadManager, extractManager);

        List<MadaReport> reports = A.getReports();
        List<LabTestPlusHealthCare> labTests = B.getUpgradedTests();

        PartC C = new PartC(loadManager, rp, extractManager, reports, labTests);
    }
}
