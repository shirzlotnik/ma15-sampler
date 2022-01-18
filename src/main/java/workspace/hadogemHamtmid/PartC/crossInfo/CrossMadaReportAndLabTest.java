package workspace.hadogemHamtmid.PartC.crossInfo;

import workspace.hadogemHamtmid.PartC.crossInfo.abstractions.DefaultCrossResults;
import workspace.hadogemHamtmid.PartC.crossInfo.crossResults.CrossResults;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.labTest.LabTestPlusHealthCare;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CrossMadaReportAndLabTest extends DefaultCrossResults<CrossResults, MadaReport, LabTestPlusHealthCare> {
    HashSet<String> ids;

    private LabTestPlusHealthCare findMatchingID (String id, List<LabTestPlusHealthCare> labTests) {
        if (this.ids.contains(id)) {
            return null;
        }
        for (LabTestPlusHealthCare labTest:labTests) {
            if (labTest.getIDNum().equals(id)) {
                this.ids.add(id);
                return labTest;
            }
        }
        return null;
    }

    private CrossResults crossLabTestAndMadaReport (MadaReport report, LabTestPlusHealthCare test) {
        String IDNum = report.getIDNum();
        String IDType = report.getIDType();
        String FirstName = report.getFirstName();
        String LastName = report.getLastName();
        String City = report.getCity();
        String Street = report.getStreet();
        String BuildingNumber = report.getBuildingNumber();
        String Barcode = report.getBarcode();
        String BirthDate = test.getBirthDate();
        String LabCode = test.getLabCode();
        String ResultDate = test.getResultDate();
        String TakeDate = report.getTakeDate();
        String StickerNumber = test.getStickerNumber();
        String ResultTestCorona = test.getResultTestCorona();
        String Variant = test.getVariant();
        String TestType = test.getTestType();

        return new CrossResults(IDNum, IDType, FirstName, LastName, City, Street, BuildingNumber,
                Barcode, BirthDate, LabCode, ResultDate, TakeDate, StickerNumber, ResultTestCorona,
                Variant, TestType);

    }

    @Override
    public List<CrossResults> crossDBs(List<MadaReport> listK, List<LabTestPlusHealthCare> listP) {
        this.crossedResult = new LinkedList<>();
        this.ids = new HashSet<>();
        for (MadaReport report: listK) {
            String idNUm = report.getIDNum();
            LabTestPlusHealthCare test = findMatchingID(idNUm, listP);
            if (test != null) {
                CrossResults crossResults = crossLabTestAndMadaReport(report, test);
                if (crossResults != null) {
                    this.crossedResult.add(crossResults);
                }
            }
        }
        return this.crossedResult;
    }
}
