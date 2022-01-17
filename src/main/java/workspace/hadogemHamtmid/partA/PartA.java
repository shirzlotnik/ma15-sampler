package workspace.hadogemHamtmid.partA;

import workspace.hadogemHamtmid.extract.CSVExtractManager;
import workspace.hadogemHamtmid.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.load.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.util.List;

public class PartA {

    public PartA (LoadManager loadManager, ReadProperties rp, CSVExtractManager csvExtractManager) {
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("MADA_REPORTS_FILE_PATH");

        DefaultExtractionFromFile efCSV = csvExtractManager.getExtractor("MadaReport");
        List<MadaReport> reports = efCSV.extract(CSV_FILE_PATH);
        DefaultLoadToFile ltj = loadManager.getLoadFile("json");
        ltj.load(JSON_DIRECTORY_PATH, reports);

    }
}
