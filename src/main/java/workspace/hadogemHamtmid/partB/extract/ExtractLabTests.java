package workspace.hadogemHamtmid.partB.extract;


import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.extract.fileValidation.FileValidation;
import workspace.hadogemHamtmid.partB.labTest.LabTest;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ExtractLabTests extends DefaultExtractionFromFile {


    private boolean checkRecordValidation (String[] record) {
        if (record[0].equals("IDNum")) {
            return false;
        } if (record[0].length() < 9 || record[0].length() > 9) {
            System.out.print("found invalid ID: " + record[0] + " for: ");
            System.out.println(String.format("%s %s", record[2], record[3]));
            return false;
        }
        return true;
    }

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

        return new LabTest(IDNum, IDType, FirstName, LastName, ResultDate, BirthDate, LabCode, StickerNumber,
                ResultTestCorona, Variant, TestType);
    }

    @Override
    public List<LabTest> extract(String filePath) {
        List<LabTest> tests = new LinkedList<>();
        this.fv = new FileValidation();
        if (this.fv.isFileValid(filePath)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String  row = "";
                while (row != null) {
                    row = reader.readLine();
                    if (row == null) {
                        break;
                    }
                    String[] record = row.split(this.SPLIT_CSV_LINE);
                    if (checkRecordValidation(record)) {
                        LabTest l = getLabTest(record);
                        tests.add(l);

                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tests;
    }
}
