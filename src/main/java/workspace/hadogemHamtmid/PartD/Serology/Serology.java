package workspace.hadogemHamtmid.PartD.Serology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Serology {
    String IDNum;
    String IDType;
    String FirstName;
    String LastName;
    String ResultDate;
    String BirthDate;
    String LabCode;
    String StickerNumber;
    int AntiDotes;
    String KitNumber;
    boolean haveAntidotes;


    public void checkResistance (HashMap<String, Integer> kitMap) {
        int required = kitMap.get(this.KitNumber);
        this.haveAntidotes = (this.AntiDotes >= required);
    }
}
