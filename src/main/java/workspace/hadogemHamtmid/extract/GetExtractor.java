package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;

public interface GetExtractor {
    public DefaultExtractionFromFile getExtractor (String type);
}
