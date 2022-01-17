package workspace.hadogemHamtmidB.transform;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import lombok.Data;
import lombok.NoArgsConstructor;
import workspace.hadogemHamtmidB.labTest.LabTest;
import workspace.hadogemHamtmidB.labTest.UpgradedLabTest;
import workspace.hadogemHamtmidB.transform.abstraction.AddUpgradeToTest;

import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
@Data
public class UpgradeLabTests implements AddUpgradeToTest {

    @Override
    public List<UpgradedLabTest> upgradeList(List<LabTest> labTests) {
        List<UpgradedLabTest> upgradedLabTests = new LinkedList<>();
        for (LabTest l1:labTests) {
            UpgradedLabTest upgraded = upgrade(l1);
            if (upgraded != null) {
                upgradedLabTests.add(upgraded);
            }
        }
        return upgradedLabTests;
    }

    @Override
    public UpgradedLabTest upgrade(LabTest labTest) {
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        Integer id = Integer.parseInt(labTest.getIDNum());
        Integer idType = Integer.parseInt(labTest.getIDType());
        UpgradedLabTest upgradedLabTest = null;
        try {
            PersonInsured personInsured = healthCareInfoProvider.fetchInfo(id, idType);
            upgradedLabTest = new UpgradedLabTest(labTest, personInsured.getJoinDate(),
                    personInsured.getHealthCareId(), personInsured.getHealthCareName());
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        return upgradedLabTest;
    }


}
