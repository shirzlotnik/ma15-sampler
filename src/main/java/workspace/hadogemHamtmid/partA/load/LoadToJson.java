package workspace.hadogemHamtmid.partA.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class LoadToJson extends DefaultLoadToFile<MadaReport> {
    private final ObjectMapper mapper;
    private int fileCount;

    public LoadToJson (int maxObjects) {
        this.mapper = new ObjectMapper();
        this.fileCount = 0;
        this.maxObjects = maxObjects;
    }

    @Override
    public void load(String directoryPath, List<MadaReport> reports) {
        Iterator<MadaReport> iterator = reports.listIterator();
        int objectCount = maxObjects;
        MadaReport m = iterator.next();
        FileWriter writer = null;
        try {

            while (iterator.hasNext()) {
                if (objectCount >= maxObjects) {
                    this.filePath = String.format("%s%s%d.json", directoryPath, "/report", this.fileCount);
                    File jsonFile = new File(this.filePath);
                    if (!jsonFile.exists()) {
                        jsonFile.createNewFile();
                    }
                    writer = new FileWriter(jsonFile, true);
                    this.fileCount++;
                    objectCount = 0;
                }
                try {
                    String json = this.mapper.writeValueAsString(m);
                    writer.write(json + "\n");
                    objectCount++;
                } catch (IOException e) {
                    System.out.println("could not write to file: " + this.filePath);
                    e.printStackTrace();
                }
                m = iterator.next();
            }
        } catch (IOException e) {
            System.out.println("could not write to file: " + this.filePath);
            e.printStackTrace();
        }
    }
}
