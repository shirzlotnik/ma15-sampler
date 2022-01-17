package workspace.hadogemHamtmidB.transform.abstraction;

import workspace.hadogemHamtmidB.labTest.LabTest;
import workspace.hadogemHamtmidB.labTest.UpgradedLabTest;

import java.util.List;

public interface AddUpgradeToTest {
    public List<UpgradedLabTest> upgradeList (List<LabTest> labTests);
    public UpgradedLabTest upgrade (LabTest labTest);
}
