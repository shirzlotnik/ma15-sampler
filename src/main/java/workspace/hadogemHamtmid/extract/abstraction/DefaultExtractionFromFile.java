package workspace.hadogemHamtmid.extract.abstraction;

import workspace.hadogemHamtmid.extract.fileValidation.FileValidation;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public abstract class DefaultExtractionFromFile implements ExtractFromFile {
    FileValidation fv;

}
