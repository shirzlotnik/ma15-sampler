package workspace.hadogemHamtmid.partB.transform.abstraction;

import workspace.hadogemHamtmid.partB.labTest.LabTest;

import java.util.List;

public interface UpgradeLabTest<T> {
    public List<T> upgrade (List<LabTest> list);
}
