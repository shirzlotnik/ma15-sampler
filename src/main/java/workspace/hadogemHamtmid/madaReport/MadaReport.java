package workspace.hadogemHamtmid.madaReport;

//import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MadaReport {
    String MDACODE;
    String  IDNum;
    String IDType;
    String FirstName;
    String LastName;
    String City;
    String Street;
    String BuildingNumber;
    String Barcode;
    String GetDate;
    String TakeDate;
    String ResultDate;

}
