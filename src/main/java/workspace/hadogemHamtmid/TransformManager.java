package workspace.hadogemHamtmid;

import workspace.hadogemHamtmid.partB.transform.AddHealthCareProvider;
import workspace.hadogemHamtmid.partB.transform.abstraction.DefaultTransformer;

import java.util.HashMap;

public class TransformManager {
    HashMap<String, DefaultTransformer> formatAndTransformer;

    public TransformManager () {
        this.formatAndTransformer = new HashMap<String, DefaultTransformer>() {{
            put("healthCareProvider", new AddHealthCareProvider());
        }};
    }

    public DefaultTransformer getTransformer (String type) {
        return this.formatAndTransformer.get(type);
    }
}
