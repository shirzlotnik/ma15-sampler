package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.extract.abstraction.ExtractFromFile;
import workspace.hadogemHamtmid.extract.fileValidation.FileValidation;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class ExtractFromCsv extends DefaultExtractionFromFile {
    private final String SPLIT_CSV_LINE = ",";

    public ExtractFromCsv () {
        super();
        this.fv = new FileValidation();
    }

    private MadaReport getMadaReport (String[] record) {
        String MDACODE = record[0];
        String IDNum = record[1];
        String IDType = record[2];
        String FirstName = record[3];
        String LastName = record[4];
        String City = record[5];
        String Street = record[6];
        String BuildingNumber = record[7];
        String Barcode = record[8];
        String GetDate = record[9];
        String TakeDate = record[10];
        String ResultDate = record[11];
        return new MadaReport(MDACODE, IDNum, IDType, FirstName, LastName, City, Street, BuildingNumber,
                Barcode, GetDate, TakeDate, ResultDate);
    }

    @Override
    public List<MadaReport> extract(String filePath) {
        List<MadaReport> reports = new LinkedList<>();
        if (this.fv.isFileValid(filePath)) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
                String  row = "";
                while (row != null) {
                    row = reader.readLine();
                    if (row == null) {
                        break;
                    }
                    MadaReport m = getMadaReport(row.split(SPLIT_CSV_LINE));
                    reports.add(m);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reports;
    }
}
