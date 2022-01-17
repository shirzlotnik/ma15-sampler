package workspace.hadogemHamtmidB.extract;

import workspace.hadogemHamtmid.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.madaReport.MadaReport;
import workspace.hadogemHamtmidB.labTest.LabTest;

import java.io.*;
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
        return new LabTest(IDNum, IDType, FirstName, LastName, ResultDate, BirthDate, LabCode, StickerNumber,
                ResultTestCorona, Variant, TestType);
    }

    @Override
    public List<LabTest> extract(String filePath) {
        List<LabTest> tests = new LinkedList<>();
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
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tests;
    }
}
