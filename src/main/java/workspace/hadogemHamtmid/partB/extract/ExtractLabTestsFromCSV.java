package workspace.hadogemHamtmid.partB.extract;


import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;


import javafx.scene.input.DataFormat;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.extract.fileValidation.FileValidation;
import workspace.hadogemHamtmid.partB.labTest.LabTest;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class ExtractLabTestsFromCSV extends DefaultExtractionFromFile {


    private LabTest getLabTest (String[] record) {
        String IDNum = record[0];
        String IDType = record[1];
        String FirstName = record[2];
        String LastName = record[3];
        String ResultDate = record[4];
        String BirthDate = record[5];
        String LabCode = record[6];
        String StickerNumber = record[7];
        String ResultTestCorona = record[8];
        String Variant = record[9];
        String TestType = record[10];

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

         /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "02/11/2003";
        LocalDate JoinDate = LocalDate.parse(date, formatter);
        int HealthCareId = 9;
        String HealthCareName = "Shir";
*/
        return new LabTest(IDNum, IDType, FirstName, LastName, ResultDate, BirthDate, LabCode, StickerNumber,
                ResultTestCorona, Variant, TestType, JoinDate, HealthCareId, HealthCareName);
    }

    @Override
    public List<LabTest> extract(String filePath) {
        List<LabTest> tests = new LinkedList<>();
        this.fv = new FileValidation();
        if (this.fv.isFileValid(filePath)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
                String  row = "";
                while (row != null) {
                    row = reader.readLine();
                    if (row == null) {
                        break;
                    }
                    LabTest l = getLabTest(row.split(this.SPLIT_CSV_LINE));
                    tests.add(l);
                }
            } catch (FileNotFoundException e) {
                System.out.println("line 79, class" + Thread.currentThread().getClass().getName());
                e.printStackTrace();
            } catch (IOException e) {

                System.out.println("line 83, class" + Thread.currentThread().getClass().getName());
                e.printStackTrace();
            }
        }
        return tests;
    }
}
