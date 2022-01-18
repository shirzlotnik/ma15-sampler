package workspace.hadogemHamtmid.partB.transform;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;
import workspace.hadogemHamtmid.partB.transform.abstraction.DefaultTransformer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class AddHealthCareProvider extends DefaultTransformer<LabTestPlusHealthCare> {
    List<LabTestPlusHealthCare> upgradedLabTests;

    public AddHealthCareProvider () {
        this.upgradedLabTests = new LinkedList<>();
    }

    private LabTestPlusHealthCare getLabTestPlusHealthCare (LabTest labTest) {
        String IDNum = labTest.getIDNum();
        String IDType = labTest.getIDType();
        String FirstName = labTest.getFirstName();
        String LastName = labTest.getLastName();
        String ResultDate = labTest.getResultDate();
        String BirthDate = labTest.getBirthDate();
        String LabCode = labTest.getLabCode();
        String StickerNumber = labTest.getStickerNumber();
        String ResultTestCorona = labTest.getResultTestCorona();
        String Variant = labTest.getVariant();
        String TestType = labTest.getTestType();

        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        int id = Integer.parseInt(IDNum);
        int idType = Integer.parseInt(IDType);
        LocalDate JoinDate = null;
        int HealthCareId = 0;
        String HealthCareName = "";
        try {
            PersonInsured personInsured = healthCareInfoProvider.fetchInfo(id, idType);
            JoinDate = personInsured.getJoinDate();
            HealthCareId = personInsured.getHealthCareId();
            HealthCareName = personInsured.getHealthCareName();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
        LabTestPlusHealthCare extra = new LabTestPlusHealthCare(IDNum, IDType, FirstName, LastName,
                ResultDate, BirthDate, LabCode, StickerNumber, ResultTestCorona, Variant, TestType,
                JoinDate, HealthCareId, HealthCareName);
        return extra;
    }


    @Override
    public List<LabTestPlusHealthCare> upgrade(List<LabTest> list) {
        for (LabTest labTest: list) {
            LabTestPlusHealthCare extra = getLabTestPlusHealthCare(labTest);
            this.upgradedLabTests.add(extra);
        }
        return this.upgradedLabTests;

    }
}
