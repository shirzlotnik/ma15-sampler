package workspace.hadogemHamtmid.PartD;

import java.util.HashMap;

public class PartD {
    HashMap<String, Integer> kitMap;

    public PartD() {
        this.kitMap = new HashMap<String, Integer>() {{
            put("15", 500);
            put("16", 1000);
            put("17", 1500);
        }};
    }
}
