package workspace.hadogemHamtmid.partA;

import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.extract.ExtractMadaReportsFromCsv;
import workspace.hadogemHamtmid.partA.toFile.LoadToJson;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.IOException;
import java.util.List;

public class PartA {

    public PartA () {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("MADA_REPORTS_FILE_PATH");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));

        ExtractMadaReportsFromCsv efCSV = new ExtractMadaReportsFromCsv();
        List<MadaReport> reports = efCSV.extract(CSV_FILE_PATH);
        LoadToJson ltj = new LoadToJson(MAX_OBJECTS);
        try {
            ltj.load(JSON_DIRECTORY_PATH, reports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
