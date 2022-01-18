package workspace.hadogemHamtmid.PartD.extract;

import lombok.AllArgsConstructor;
import lombok.Data;
import workspace.hadogemHamtmid.PartD.Serology.Serology;
import workspace.hadogemHamtmid.partA.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class ExtractSerologyFromCsv extends DefaultExtractionFromFile {
    HashMap<String, Integer> kitMap;


    private boolean checkLabcodeValidation (String labcode) {
        char[] chars = labcode.toCharArray();
        if (chars.length > 5 || chars.length < 5) {
            return false;
        }
        if (chars[0] < '0' || chars[0] > '9' || chars[1] < '0' || chars[1] > '9' || chars[4] < '0' || chars[4] > '9') {
            return false;
        }
        return true;
    }

    private boolean checkValidation (String[] record) {
        if (record.length > 10 || record.length < 10) {
            return false;
        }
        if (record[1].equals("0")) {
            if (record[0].length() < 9) {
                return false;
            }
        }
        if (!checkLabcodeValidation(record[6])) {
            return false;
        }
        return true;
    }

    private Serology getSerology (String[] record) {
        String IDNum = record[0];
        String IDType = record[1];
        String FirstName = record[2];
        String LastName = record[3];
        String ResultDate = record[4];
        String BirthDate = record[5];
        String LabCode = record[6];
        String StickerNumber = record[7];
        int AntiDotes = Integer.parseInt(record[0]);
        String KitNumber = record[9];

        Serology serology = new Serology(IDNum, IDType, FirstName, LastName, ResultDate, BirthDate, LabCode,
                StickerNumber, AntiDotes, KitNumber, false);
        serology.checkResistance(this.kitMap);
        return serology;
    }

    @Override
    public List<Serology> extract(String filePath) {
        List<Serology> serologys = new LinkedList<>();
        if (this.fv.isFileValid(filePath)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String  row = "";
                while (row != null) {
                    row = reader.readLine();
                    if (row == null) {
                        break;
                    }
                    String[] record = row.split(SPLIT_CSV_LINE);
                    if (checkValidation(record)) {
                        Serology s = getSerology(record);
                        serologys.add(s);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return serologys;    }
}
