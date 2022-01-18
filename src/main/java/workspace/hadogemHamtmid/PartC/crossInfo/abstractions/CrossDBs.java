package workspace.hadogemHamtmid.PartC.crossInfo.abstractions;

import java.util.List;

public interface CrossDBs<T, K, P> {
    public List<T> crossDBs (List<K> listK, List<P> listP);
}
