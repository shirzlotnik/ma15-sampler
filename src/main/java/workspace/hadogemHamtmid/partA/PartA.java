package workspace.hadogemHamtmid.partA;

import lombok.Data;
import workspace.hadogemHamtmid.ETLManagers.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.ETLManagers.ExtractManager;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.util.List;

@Data
public class PartA {
    List<MadaReport> reports;

    public PartA (LoadManager loadManager, ExtractManager extractManager) {
        ReadProperties rp = loadManager.getRp();
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("MADA_REPORTS_FILE_PATH");
        final String EXTRACTOR_PART_A = rp.getProperty("EXTRACTOR_PART_A");
        final String LOADER_PART_A = rp.getProperty("LOADER_PART_A");
        final String EXTRACTOR_MANAGER_PART_A = rp.getProperty("EXTRACTOR_MANAGER_PART_A");
        String LOAD_FILE_TYPE_A = rp.getProperty("LOAD_FILE_TYPE_A");


        DefaultExtractionFromFile efCSV = extractManager.getExtractManager(EXTRACTOR_MANAGER_PART_A)
                .getExtractor(EXTRACTOR_PART_A);
        this.reports = efCSV.extract(CSV_FILE_PATH);
        DefaultLoadToFile ltj = loadManager.getLoadFile(LOADER_PART_A);
        ltj.load(JSON_DIRECTORY_PATH, reports);

    }
}
