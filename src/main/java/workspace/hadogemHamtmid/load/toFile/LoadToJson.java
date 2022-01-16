package workspace.hadogemHamtmid.load.toFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class LoadToJson extends DefaultLoadToFile {
    private ObjectMapper mapper;
    private String filePath;
    private int fileCount;

    public LoadToJson (int maxObjects) {
        this.mapper = new ObjectMapper();
        this.filePath = String.format("%s%d%s");
        this.fileCount = 0;
        this.maxObjects = maxObjects;
    }

    @Override
    public void load(String directoryPath, List<MadaReport> reports) {
        Iterator<MadaReport> iterator = reports.listIterator();
        int objectCount = 0;
        MadaReport m = iterator.next();
        this.filePath = String.format("%s%d.json", directoryPath, this.fileCount);
        while (m != null) {
            if (objectCount >= maxObjects) {
                this.fileCount++;
                this.filePath = String.format("%s%d.json", directoryPath, this.fileCount);
                objectCount = 0;
            }
            try {
                this.mapper.writeValue(Paths.get(directoryPath).toFile(), m);
                objectCount++;
            } catch (IOException e) {
                // trow writing exception
                e.printStackTrace();
            }
            m = iterator.next();
        }
    }
}
