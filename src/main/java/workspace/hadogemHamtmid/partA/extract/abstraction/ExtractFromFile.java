package workspace.hadogemHamtmid.partA.extract.abstraction;

import java.util.List;

public interface ExtractFromFile<T> {
    public List<T> extract (String filePath);
}
