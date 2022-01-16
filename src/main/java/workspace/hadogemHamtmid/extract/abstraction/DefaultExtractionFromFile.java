package workspace.hadogemHamtmid.extract.abstraction;

import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.extract.fileValidation.FileValidation;
import workspace.hadogemHamtmid.madaReport.MadaReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@NoArgsConstructor
public abstract class DefaultExtractionFromFile implements ExtractFromFile {
    protected FileValidation fv;

}
