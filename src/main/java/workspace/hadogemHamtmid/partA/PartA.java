package workspace.hadogemHamtmid.partA;

import workspace.hadogemHamtmid.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.extract.ExtractMadaReportsFromCsv;
import workspace.hadogemHamtmid.partA.load.LoadToJson;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.IOException;
import java.util.List;

public class PartA {

    public PartA (LoadManager loadManager) {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("MADA_REPORTS_FILE_PATH");

        ExtractMadaReportsFromCsv efCSV = new ExtractMadaReportsFromCsv();
        List<MadaReport> reports = efCSV.extract(CSV_FILE_PATH);
        LoadToJson ltj = (LoadToJson) loadManager.getLoadFile("json");
        ltj.load(JSON_DIRECTORY_PATH, reports);

    }
}
