package workspace.hadogemHamtmid.partA.toFile;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.partA.toFile.abstraction.LoadToFile;

@NoArgsConstructor
@AllArgsConstructor
public abstract class DefaultLoadToFile<T> implements LoadToFile<T> {
    protected int maxObjects;
    protected String filePath;

}
