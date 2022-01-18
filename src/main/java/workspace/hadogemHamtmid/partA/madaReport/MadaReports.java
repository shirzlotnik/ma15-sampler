package workspace.hadogemHamtmid.partA.madaReport;

import com.fasterxml.jackson.annotation.JsonClassDescription;

import java.util.List;

public class MadaReports {
    List<MadaReport> madaReports;

    public MadaReports (List<MadaReport> list) {
        this.madaReports = list;
    }
}
