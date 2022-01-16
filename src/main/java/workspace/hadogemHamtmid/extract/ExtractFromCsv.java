package workspace.hadogemHamtmid.extract;

import workspace.hadogemHamtmid.extract.abstraction.DefaultExtractionFromFile;
import workspace.hadogemHamtmid.extract.abstraction.ExtractFromFile;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.*;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExtractFromCsv extends DefaultExtractionFromFile {
    private final String SPLIT_CSV_LINE = ",";
    private MadaReport getMadaReport (String[] record) {
        String MDACODE = record[0];
        int IDNum = Integer.parseInt(record[1]);
        int IDType = Integer.parseInt(record[2]);
        String FirstName = record[3];
        String LastName = record[4];
        String City = record[5];
        String Street = record[6];
        String BuildingNumber = record[7];
        String Barcode = record[8];
        Date GetDate = Date.from(Instant.parse(record[9]));
        Date TakeDate = Date.from(Instant.parse(record[10]));
        Date ResultDate = Date.from(Instant.parse(record[11]));
        return new MadaReport(MDACODE, IDNum, IDType, FirstName, LastName, City, Street, BuildingNumber,
                Barcode, GetDate, TakeDate, ResultDate);
    }

    @Override
    public List<MadaReport> extract(String filePath) {
        List<MadaReport> reports = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String  row = "";
            while (row != null) {
                row = reader.readLine();
                MadaReport m = getMadaReport(row.split(SPLIT_CSV_LINE));
                reports.add(m);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reports;
    }
}
