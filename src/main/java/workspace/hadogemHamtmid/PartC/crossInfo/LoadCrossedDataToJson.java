package workspace.hadogemHamtmid.PartC.crossInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.hadogemHamtmid.partA.load.abstraction.DefaultLoadToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadCrossedDataToJson<T> extends DefaultLoadToFile<T> {
    private final ObjectMapper mapper;
    private int fileCount;
    private long maxSize;

    public LoadCrossedDataToJson(long maxSize) {
        super();
        this.maxObjects = 0;
        this.mapper = new ObjectMapper();
        this.fileCount = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void load(String directoryPath, List<T> reports) {
        Iterator<T> iterator = reports.listIterator();
        int objectCount = maxObjects;
        List<T> fixedSizeList = new LinkedList<>();
        T c = null;
        this.filePath = String.format("%s%s%d.json", directoryPath, "/positive_corona_people", this.fileCount);
        this.fileCount++;
        try {
            while (iterator.hasNext()) {
                File jsonFile = new File(this.filePath);
                jsonFile.createNewFile();
                jsonFile.canWrite();
                if (Files.size(Paths.get(this.filePath)) < this.maxSize) {
                    writeToFile(directoryPath, fixedSizeList);
                    fixedSizeList = new LinkedList<>();
                } else {
                    this.filePath = String.format("%s%s%d.json", directoryPath, "/positive_corona_people", this.fileCount);
                    this.fileCount++;
                }
                if (iterator != null) {
                    c = iterator.next();
                    fixedSizeList.add(c);
                }
            }
            writeToFile(directoryPath, fixedSizeList);
        } catch (IOException e) {
            System.out.println("could not write to file: " + this.filePath);
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String directoryPath, List<T> fixedSizeList) throws IOException {
        if (fixedSizeList.size() == 0) {
            return;
        }
        File jsonFile = new File(this.filePath);
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile, true));
        if (fixedSizeList == null) {
            fixedSizeList = new LinkedList<>();
            return;
        }
        String json = this.mapper.writeValueAsString(fixedSizeList.get(0));
        writer.write(json);
        this.fileCount++;
        writer.flush();
        writer.close();
    }
}
