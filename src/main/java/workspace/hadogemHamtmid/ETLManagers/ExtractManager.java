package workspace.hadogemHamtmid.ETLManagers;

import workspace.hadogemHamtmid.extract.CSVExtractManager;
import workspace.hadogemHamtmid.extract.DefaultExtractManager;

import java.util.HashMap;

public class ExtractManager {
    HashMap<String, DefaultExtractManager> formatAnDExtractManager;

    public ExtractManager () {
        this.formatAnDExtractManager = new HashMap<String, DefaultExtractManager>() {{
            put("csv", new CSVExtractManager());
        }};
    }

    public DefaultExtractManager getExtractManager (String type) {
        return this.formatAnDExtractManager.get(type);
    }
}
