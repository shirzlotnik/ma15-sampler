package workspace.hadogemHamtmid.PartD;

import workspace.hadogemHamtmid.ETLManagers.ExtractManager;
import workspace.hadogemHamtmid.ETLManagers.LoadManager;
import workspace.hadogemHamtmid.ReadProperties;


public class PartD {

    public PartD(LoadManager loadManager, ExtractManager extractManager) {
        ReadProperties rp = loadManager.getRp();
        String EXTRACTOR_PART_D = rp.getProperty("EXTRACTOR_PART_D");
        String EXTRACTOR_MANAGER_PART_D = rp.getProperty("EXTRACTOR_MANAGER_PART_D");
        String SEROLOGY_FILE_PATH = rp.getProperty("SEROLOGY_FILE_PATH");


    }
}
