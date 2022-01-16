package workspace.hadogemHamtmid;

import workspace.hadogemHamtmid.extract.ExtractFromCsv;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main (String[] args) {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("CSV_FILE_PATH");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));

        ExtractFromCsv efCSV = new ExtractFromCsv();
        List<MadaReport> reports = efCSV.extract(CSV_FILE_PATH);
    }
}
