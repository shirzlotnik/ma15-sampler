package workspace.hadogemHamtmid.partA.load.abstraction;

import java.io.IOException;
import java.util.List;

public interface LoadToFile<T> {
    public void load (String directoryPath, List<T> reports);
}
