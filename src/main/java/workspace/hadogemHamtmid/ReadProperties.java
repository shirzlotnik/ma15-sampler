package workspace.hadogemHamtmid;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ReadProperties {
    HashMap<String, String> propertiesMap;
    Properties properties;

    public ReadProperties (String path) {
        this.propertiesMap = new HashMap<>();

        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(path)){
            properties.load(inputStream);

            propertiesMap.put("JSON_DIRECTORY_PATH", properties.getProperty("JSON_DIRECTORY_PATH"));
            propertiesMap.put("MADA_REPORTS_FILE_PATH", properties.getProperty("MADA_REPORTS_FILE_PATH"));
            propertiesMap.put("MAX_OBJECTS", properties.getProperty("MAX_OBJECTS"));
            propertiesMap.put("XML_DIRECTORY_PATH", properties.getProperty("XML_DIRECTORY_PATH"));
            propertiesMap.put("LAB_TEST_FILE_PATH", properties.getProperty("LAB_TEST_FILE_PATH"));
            propertiesMap.put("LOADER_PART_B", properties.getProperty("LOADER_PART_B"));
            propertiesMap.put("EXTRACTOR_PART_B", properties.getProperty("EXTRACTOR_PART_B"));
            propertiesMap.put("TRANSFORMER_PART_B", properties.getProperty("TRANSFORMER_PART_B"));
            propertiesMap.put("EXTRACTOR_MANAGER_PART_B", properties.getProperty("EXTRACTOR_MANAGER_PART_B"));
            propertiesMap.put("LOADER_PART_A", properties.getProperty("LOADER_PART_A"));
            propertiesMap.put("EXTRACTOR_PART_A", properties.getProperty("EXTRACTOR_PART_A"));
            propertiesMap.put("EXTRACTOR_MANAGER_PART_A", properties.getProperty("EXTRACTOR_MANAGER_PART_A"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReadProperties getInstance () {
        propertiesMap.put("JSON_DIRECTORY_PATH", properties.getProperty("JSON_DIRECTORY_PATH"));
        propertiesMap.put("MADA_REPORTS_FILE_PATH", properties.getProperty("MADA_REPORTS_FILE_PATH"));
        propertiesMap.put("MAX_OBJECTS", properties.getProperty("MAX_OBJECTS"));
        propertiesMap.put("XML_DIRECTORY_PATH", properties.getProperty("XML_DIRECTORY_PATH"));
        propertiesMap.put("LAB_TEST_FILE_PATH", properties.getProperty("LAB_TEST_FILE_PATH"));

        return this;
    }

    public String getProperty (String key) {
        return this.propertiesMap.get(key);
    }
}
