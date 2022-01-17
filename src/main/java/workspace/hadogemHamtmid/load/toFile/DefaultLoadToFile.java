package workspace.hadogemHamtmid.load.toFile;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.load.toFile.abstraction.LoadToFile;
import workspace.hadogemHamtmid.madaReport.MadaReport;

@NoArgsConstructor
@AllArgsConstructor
public abstract class DefaultLoadToFile<T> implements LoadToFile<T> {
    protected int maxObjects;
}
