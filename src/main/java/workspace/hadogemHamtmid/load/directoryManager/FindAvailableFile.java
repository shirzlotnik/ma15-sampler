package workspace.hadogemHamtmid.load.directoryManager;

import java.io.File;

public class FindAvailableFile {
    static int fileCount = 0;


    private String findFileInDirectory (File[] files) {
        if (files.length > 0) {
            for (File f: files) {
                // check lines count
                // if found valid return its path
            }
        }
        return "";
    }

    public String FindAvailableFileInDirectory (String directoryPath, String ending) {
        File directory = new File(directoryPath);
        String filePath;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            filePath = findFileInDirectory(files);
            if (filePath.equals("")) {
                filePath = directoryPath + "/reports";
                filePath += fileCount + ending;
                fileCount ++;
            }
            return filePath;
        } else {
            // throw exception
        }
        return null;
    }
}
