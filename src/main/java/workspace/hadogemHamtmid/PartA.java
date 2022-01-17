package workspace.hadogemHamtmid;

import workspace.hadogemHamtmid.extract.ExtractFromCsv;
import workspace.hadogemHamtmid.load.toFile.LoadToJson;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.IOException;
import java.util.List;

public class PartA {

    public PartA () {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("CSV_FILE_PATH");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));

        ExtractFromCsv efCSV = new ExtractFromCsv();
        List<MadaReport> reports = efCSV.extract(CSV_FILE_PATH);
        LoadToJson ltj = new LoadToJson(MAX_OBJECTS);
        try {
            ltj.load(JSON_DIRECTORY_PATH, reports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
