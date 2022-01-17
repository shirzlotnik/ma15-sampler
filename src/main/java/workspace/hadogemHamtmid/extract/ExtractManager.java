package workspace.hadogemHamtmid.extract;

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
