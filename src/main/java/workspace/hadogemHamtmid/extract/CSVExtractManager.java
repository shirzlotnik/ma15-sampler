package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.partA.extract.ExtractMadaReportsFromCsv;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partB.extract.ExtractLabTestsFromCSV;

import java.util.HashMap;

public class CSVExtractManager extends DefaultExtractManager{
    HashMap<String, DefaultExtractionFromFile> objectAndExtractor;

    public CSVExtractManager() {
        this.objectAndExtractor = new HashMap<String, DefaultExtractionFromFile>() {{
            put("MadaReport", new ExtractMadaReportsFromCsv());
            put("LabTest", new ExtractLabTestsFromCSV());
        }};
    }

    @Override
    public DefaultExtractionFromFile getExtractor (String type) {
        return this.objectAndExtractor.get(type);
    }
}
