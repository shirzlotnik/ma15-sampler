package workspace.hadogemHamtmid.ETLManagers;

import workspace.hadogemHamtmid.partB.load.toFormat.abstraction.MakeFormat;
import workspace.hadogemHamtmid.partB.load.toFormat.xml.MakeXMLFormat;

import java.util.HashMap;

public class FormatManager {
    HashMap<String, MakeFormat> formatAndImplement;

    public FormatManager () {
        this.formatAndImplement = new HashMap<String, MakeFormat>() {{
            put("xml", new MakeXMLFormat());
        }};
    }

    public MakeFormat getFormatMaker (String type) {
        return this.formatAndImplement.get(type);
    }
}
