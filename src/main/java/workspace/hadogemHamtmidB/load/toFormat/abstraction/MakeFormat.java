package workspace.hadogemHamtmidB.load.toFormat.abstraction;

import workspace.hadogemHamtmidB.labTest.LabTest;

public interface MakeFormat<T> {
    public String makeFormat (T t, String type);

    String makeFormat(LabTest labTest, String type);
}
