package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.util.List;

public interface ExtractFromFile {
    public List<MadaReport> extract (String filePath);
}
