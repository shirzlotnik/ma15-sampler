package workspace.hadogemHamtmid.load.toFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class LoadToJson extends DefaultLoadToFile {
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

        while (iterator.hasNext()) {
            if (objectCount >= maxObjects) {
                this.filePath = String.format("%s%s%d.json", directoryPath, "/report", this.fileCount);
                File jsonFile = new File(this.filePath);
                if (!jsonFile.exists()) {
                    jsonFile.createNewFile();
                }
                this.fileCount++;
                objectCount = 0;
            }
            try {
                FileReader reader;
                this.mapper.writeValue(Paths.get(this.filePath).toFile(), m);
                objectCount++;
            } catch (IOException e) {
                // trow writing exception
                e.printStackTrace();
            }
            m = iterator.next();
        }
    }
}
