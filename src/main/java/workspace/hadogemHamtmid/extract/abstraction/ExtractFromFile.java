package workspace.hadogemHamtmid.extract.abstraction;

import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.util.List;

public interface ExtractFromFile<T> {
    public List<T> extract (String filePath);
}
