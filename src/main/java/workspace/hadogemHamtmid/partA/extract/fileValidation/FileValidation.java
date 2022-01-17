package workspace.hadogemHamtmid.partA.extract.fileValidation;

import workspace.hadogemHamtmid.partA.extract.fileValidation.abstraction.IsFileValid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileValidation implements IsFileValid {

    @Override
    public boolean isFileValid(String path) {
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
