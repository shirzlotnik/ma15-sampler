package workspace.hadogemHamtmid;

import lombok.Data;
import workspace.hadogemHamtmid.partA.load.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.load.LoadToJson;
import workspace.hadogemHamtmid.partB.load.LoadToXML;

import java.util.HashMap;

@Data
public class LoadManager {
    private HashMap<String, DefaultLoadToFile> formatAndLoader;

    public LoadManager (int maxObjects) {
        this.formatAndLoader = new HashMap<String, DefaultLoadToFile>() {{
            put("xml", new LoadToXML(maxObjects));
            put("json", new LoadToJson(maxObjects));
        }};
    }

    public DefaultLoadToFile getLoadFile (String type) {
        return this.formatAndLoader.get(type);
    }
}
