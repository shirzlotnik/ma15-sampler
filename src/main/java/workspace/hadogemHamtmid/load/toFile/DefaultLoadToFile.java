package workspace.hadogemHamtmid.load.toFile;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.load.directoryManager.FindAvailableFile;
import workspace.hadogemHamtmid.load.toFile.abstraction.LoadToFile;

@NoArgsConstructor
@AllArgsConstructor
public abstract class DefaultLoadToFile implements LoadToFile {
    protected int maxObjects;
}
