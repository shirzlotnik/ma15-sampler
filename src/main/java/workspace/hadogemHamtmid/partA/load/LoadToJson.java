package workspace.hadogemHamtmid.partA.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadToJson extends DefaultLoadToFile<MadaReport> {
    private final ObjectMapper mapper;
    private int fileCount;

    public LoadToJson (int maxObjects) {
        this.mapper = new ObjectMapper();
        this.fileCount = 101;
        this.maxObjects = maxObjects;
    }

    @Override
    public void load(String directoryPath, List<MadaReport> reports) {
        Iterator<MadaReport> iterator = reports.listIterator();
        int objectCount = maxObjects;
        List<MadaReport> fixedSizeList = new LinkedList<>();
        MadaReport m = null;
        try {
            while (iterator.hasNext()) {
                if (objectCount >= maxObjects) {
                    writeToFile(directoryPath, fixedSizeList);
                    objectCount = 0;
                    fixedSizeList = new LinkedList<>();
                } if (iterator != null) {
                    m = iterator.next();
                    objectCount++;
                    fixedSizeList.add(m);
                }
            }
            writeToFile(directoryPath, fixedSizeList);
        } catch (IOException e) {
            System.out.println("could not write to file: " + this.filePath);
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String directoryPath, List<MadaReport> fixedSizeList) throws IOException {
        if (fixedSizeList.size() == 0) {
            return;
        }
        this.filePath = String.format("%s%s%d.json", directoryPath, "/report", this.fileCount);
        File jsonFile = new File(this.filePath);
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
        if (fixedSizeList == null) {
            fixedSizeList = new LinkedList<>();
        }
        String json = this.mapper.writeValueAsString(fixedSizeList);
        writer.write(json);
        this.fileCount++;
        writer.flush();
        writer.close();
    }
}
