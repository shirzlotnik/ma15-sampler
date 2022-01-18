package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.PartD.extract.ExtractSerologyFromCsv;
import workspace.hadogemHamtmid.partA.extract.ExtractMadaReportsFromCsv;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partB.extract.ExtractLabTests;

import java.util.HashMap;

public class CSVExtractManager extends DefaultExtractManager{
    HashMap<String, DefaultExtractionFromFile> objectAndExtractor;

    public CSVExtractManager() {
        HashMap<String,Integer> kitMap = new HashMap<String, Integer>() {{
            put("15", 500);
            put("16", 1000);
            put("17", 1500);
        }};
        this.objectAndExtractor = new HashMap<String, DefaultExtractionFromFile>() {{
            put("MadaReport", new ExtractMadaReportsFromCsv());
            put("LabTest", new ExtractLabTests());
            put("Serology", new ExtractSerologyFromCsv(kitMap));
        }};
    }

    @Override
    public DefaultExtractionFromFile getExtractor (String type) {
        return this.objectAndExtractor.get(type);
    }
}
