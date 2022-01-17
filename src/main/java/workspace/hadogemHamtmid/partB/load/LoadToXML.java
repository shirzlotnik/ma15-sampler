package workspace.hadogemHamtmid.partB.load;

import workspace.hadogemHamtmid.partA.toFile.DefaultLoadToFile;
import workspace.hadogemHamtmid.partB.labTest.LabTest;
import workspace.hadogemHamtmid.partB.load.toFormat.xml.MakeXMLFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadToXML extends DefaultLoadToFile<LabTest> {
    private int fileCount;
    private final MakeXMLFormat mXMLf;
    private int objectCount;

    public LoadToXML (int maxObjects) {
        this.maxObjects = maxObjects;
        this.fileCount = 10;
        this.mXMLf = new MakeXMLFormat();
        this.objectCount = maxObjects;
    }

    @Override
    public void load(String directoryPath, List<LabTest> tests) throws IOException {
        Iterator<LabTest> iterator = tests.listIterator();
        LabTest l = null;
        List<LabTest> fixedSizeList = new LinkedList<>();
        while (iterator.hasNext()) {
            if (objectCount >= maxObjects) {
                writeToFile(directoryPath, fixedSizeList);
                objectCount = 0;
                fixedSizeList = new LinkedList<>();
            }
            if (iterator != null) {
                l = iterator.next();
                objectCount++;
                fixedSizeList.add(l);
            }
        }
        writeToFile(directoryPath, fixedSizeList);
        objectCount = 0;
        fixedSizeList = new LinkedList<>();
    }

    private void writeToFile (String directoryPath, List<LabTest> fixedSizeList) throws IOException {
        if (fixedSizeList.size() == 0) {
            return;
        }
        this.filePath = String.format("%s%s%d.xml", directoryPath, "/labTest", this.fileCount);
        File xmlFile = new File(this.filePath);
        if (!xmlFile.exists()) {
            xmlFile.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(xmlFile));
        if (fixedSizeList == null) {
            fixedSizeList = new LinkedList<>();
        }
        String xml = mXMLf.makeListFormat(fixedSizeList);
        writer.write(xml);
        this.fileCount++;
        writer.flush();
        writer.close();
    }

}
