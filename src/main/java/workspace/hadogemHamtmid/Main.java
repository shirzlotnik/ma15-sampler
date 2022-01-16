package workspace.hadogemHamtmid;

import java.util.Properties;

public class Main {
    public static void main (String[] args) {
        ReadProperties rp = new ReadProperties("config.properties").getInstance();
        final String JSON_DIRECTORY_PATH = rp.getProperty("JSON_DIRECTORY_PATH");
        final String CSV_FILE_PATH = rp.getProperty("CSV_FILE_PATH");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));

    }
}
