package workspace.hadogemHamtmid.ETLManagers;

import lombok.Data;
import workspace.hadogemHamtmid.PartC.crossInfo.CrossMadaReportAndLabTest;
import workspace.hadogemHamtmid.PartC.crossInfo.LoadCrossedDataToJson;
import workspace.hadogemHamtmid.PartC.crossInfo.crossResults.CrossResults;
import workspace.hadogemHamtmid.ReadProperties;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.load.json.LoadToJson;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;
import workspace.hadogemHamtmid.partB.PartB;
import workspace.hadogemHamtmid.partB.load.LoadToXML;

import java.util.HashMap;

@Data
public class LoadManager {
    private HashMap<String, DefaultLoadToFile> formatAndLoader;
    ReadProperties rp;

    public LoadManager (int maxObjects, ReadProperties rp) {
        this.rp = rp;
        String LOADER_PART_A = this.rp.getProperty("LOADER_PART_A");
        String LOADER_PART_B = this.rp.getProperty("LOADER_PART_B");
        String LOADER_PART_C = this.rp.getProperty("LOADER_PART_C");
        long maxSize = Long.parseLong(this.rp.getProperty("MAX_SIZE"));

        this.formatAndLoader = new HashMap<String, DefaultLoadToFile>() {{
            put(LOADER_PART_B, new LoadToXML(maxObjects));
            put(LOADER_PART_A, new LoadToJson<MadaReport>(maxObjects));
            put(LOADER_PART_C, new LoadCrossedDataToJson<CrossResults>(maxSize));
        }};
    }

    public DefaultLoadToFile getLoadFile (String type) {
        return this.formatAndLoader.get(type);
    }
}
