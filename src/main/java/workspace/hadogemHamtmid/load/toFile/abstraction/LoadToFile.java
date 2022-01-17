package workspace.hadogemHamtmid.load.toFile.abstraction;

import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.IOException;
import java.util.List;

public interface LoadToFile<T> {
    public void load (String directoryPath, List<T> reports) throws IOException;
}
