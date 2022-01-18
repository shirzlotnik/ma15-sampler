package workspace.hadogemHamtmid.partA.load.abstraction;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.partA.load.abstraction.LoadToFile;

@NoArgsConstructor
@AllArgsConstructor
public abstract class DefaultLoadToFile<T> implements LoadToFile<T> {
    protected int maxObjects;
    protected String filePath;

}
