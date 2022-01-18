package workspace.hadogemHamtmid.PartC.crossInfo.crossResults;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrossResults {
    String IDNum;
    String IDType;
    String FirstName;
    String LastName;
    String City;
    String Street;
    String BuildingNumber;
    String Barcode;
    String BirthDate;
    String LabCode;
    String ResultDate;
    String TakeDate;
    String StickerNumber;
    String ResultTestCorona;
    String Variant;
    String TestType;


}
