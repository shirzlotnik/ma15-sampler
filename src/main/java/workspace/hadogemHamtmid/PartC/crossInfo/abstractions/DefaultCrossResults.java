package workspace.hadogemHamtmid.PartC.crossInfo.abstractions;

import java.util.List;

public abstract class DefaultCrossResults<T, K, P> implements CrossDBs<T, K, P> {
    protected List<T> crossedResult;
}
