package workspace.hadogemHamtmid.partA.toFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.partA.madaReport.MadaReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class LoadToJson extends DefaultLoadToFile<MadaReport> {
    private ObjectMapper mapper;
    private String filePath;
    private int fileCount;

    public LoadToJson (int maxObjects) {
        this.mapper = new ObjectMapper();
        this.fileCount = 0;
        this.maxObjects = maxObjects;
    }

    @Override
    public void load(String directoryPath, List<MadaReport> reports) throws IOException {
        Iterator<MadaReport> iterator = reports.listIterator();
        int objectCount = maxObjects;
        MadaReport m = iterator.next();
        FileWriter writer = null;
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
