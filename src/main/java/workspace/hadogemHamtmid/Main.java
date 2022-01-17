package workspace.hadogemHamtmid;

import workspace.hadogemHamtmid.partA.PartA;
import workspace.hadogemHamtmid.partB.PartB;

public class Main {
    public static void main (String[] args) {
        ReadProperties rp = new ReadProperties("/Users/shirzlotnik/javaProjects/hadogem_hamtmid/ma15-sampler/src/main/resources/config.properties");
        final int MAX_OBJECTS = Integer.parseInt(rp.getProperty("MAX_OBJECTS"));
        LoadManager loadManager = new LoadManager(MAX_OBJECTS);
        CSVExtractManager csvExtractManager = new CSVExtractManager();

        PartA A = new PartA(loadManager, rp, csvExtractManager);

        PartB B = new PartB(loadManager, rp, csvExtractManager);
    }
}
