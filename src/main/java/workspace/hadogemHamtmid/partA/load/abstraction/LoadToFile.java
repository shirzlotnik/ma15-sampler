package workspace.hadogemHamtmid.partA.load.abstraction;

import workspace.hadogemHamtmid.partB.labTest.LabTest;

import java.io.IOException;
import java.util.List;

public interface LoadToFile<T> {
    public void load (String directoryPath, List<T> reports);
    public void writeToFile (String directoryPath, List<T> fixedSizeList) throws IOException;

}
