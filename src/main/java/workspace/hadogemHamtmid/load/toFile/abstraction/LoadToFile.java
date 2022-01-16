package workspace.hadogemHamtmid.load.toFile.abstraction;

import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.IOException;
import java.util.List;

public interface LoadToFile {
    public void load (String directoryPath, List<MadaReport> reports) throws IOException;
}
