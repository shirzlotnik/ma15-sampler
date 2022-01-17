package workspace.hadogemHamtmidB.load;

import workspace.hadogemHamtmid.load.toFile.DefaultLoadToFile;
import workspace.hadogemHamtmid.madaReport.MadaReport;
import workspace.hadogemHamtmidB.labTest.LabTest;
import workspace.hadogemHamtmidB.load.toFormat.xml.MakeXMLFormat;
import workspace.hadogemHamtmidB.transform.UpgradeLabTests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class LoadToXML extends DefaultLoadToFile<LabTest> {
    private String filePath;
    private int fileCount;

    public LoadToXML (int maxObjects) {
        this.maxObjects = maxObjects;
        this.fileCount = 10;
    }

    @Override
    public void load(String directoryPath, List<LabTest> tests) throws IOException {
        Iterator<LabTest> iterator = tests.listIterator();
        int objectCount = maxObjects;
        LabTest l = iterator.next();
        FileWriter writer = null;
        File jsonFile = null;
        while (iterator.hasNext()) {
            if (objectCount >= maxObjects) {
                if (jsonFile.length() == 0) {
                    writer.write("<labTests>\n");
                } else {
                    writer.write("</labTests>\n");
                }
                this.filePath = String.format("%s%s%d.xml", directoryPath, "/report", this.fileCount);
                jsonFile = new File(this.filePath);
                if (!jsonFile.exists()) {
                    jsonFile.createNewFile();
                }
                writer = new FileWriter(jsonFile, true);

                this.fileCount++;
                objectCount = 0;
            }
            try {
                MakeXMLFormat mXMLf = new MakeXMLFormat();
                String xml = mXMLf.makeFormat(l, "xml");
                writer.write(xml + "\n");
                //this.mapper.writeValue(Paths.get(this.filePath).toFile(), m);
                objectCount++;
            } catch (IOException e) {
                // trow writing exception
                e.printStackTrace();
            }
            m = iterator.next();
        }
    }


}
