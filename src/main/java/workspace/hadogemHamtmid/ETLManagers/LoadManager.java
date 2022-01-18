package workspace.hadogemHamtmid.ETLManagers;

import lombok.Data;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.load.json.LoadToJson;
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
