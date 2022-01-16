package workspace.hadogemHamtmid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ReadProperties {
    HashMap<String, String> propertiesMap;
    Properties properties;

    public ReadProperties (String path) {
        this.propertiesMap = new HashMap<>();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReadProperties getInstance () {
        propertiesMap.put("JSON_DIRECTORY_PATH", properties.getProperty("JSON_DIRECTORY_PATH"));
        propertiesMap.put("CSV_FILE_PATH", properties.getProperty("CSV_FILE_PATH"));
        propertiesMap.put("MAX_OBJECTS", properties.getProperty("MAX_OBJECTS"));
        return this;
    }

    public String getProperty (String key) {
        return this.propertiesMap.get(key);
    }
}
