package workspace.hadogemHamtmid.partB.load.toFormat.abstraction;

import java.util.List;

public interface MakeFormat<T> {
    public String makeFormat (T t);
    public String makeListFormat (List<T> list);
}
