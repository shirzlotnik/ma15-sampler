package workspace.hadogemHamtmid.partA.extract.abstraction;

import lombok.NoArgsConstructor;
import workspace.hadogemHamtmid.partA.extract.fileValidation.FileValidation;

@NoArgsConstructor
public abstract class DefaultExtractionFromFile implements ExtractFromFile {
    protected FileValidation fv;
    protected final String SPLIT_CSV_LINE = ",";

}
