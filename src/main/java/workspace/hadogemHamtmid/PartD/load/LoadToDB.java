package workspace.hadogemHamtmid.PartD.load;

import workspace.hadogemHamtmid.PartD.Serology.Serology;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

public class LoadToDB {
    Connection conn;
    String prepInsert = "INSERT (IDNum, IDType, firstName, lastName, resultDate, birthDate, labCode, " +
            "stickerNumber, antiDotes, kitNumber, haveAntidotes VALUES (?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement;

    public LoadToDB(Connection conn) {
        this.conn = conn;
        // the connection
        try {
            this.preparedStatement = conn.prepareStatement(prepInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOne (Serology s) throws SQLException {
        this.preparedStatement.setString(1, s.getIDNum());
        this.preparedStatement.setString(2, s.getIDType());
        this.preparedStatement.setString(3, s.getFirstName());
        this.preparedStatement.setString(4, s.getLastName());
        this.preparedStatement.setDate(5, Date.valueOf(s.getResultDate()));
        this.preparedStatement.setDate(6, Date.valueOf(s.getBirthDate()));
        this.preparedStatement.setString(7, s.getLabCode());
        this.preparedStatement.setString(8, s.getStickerNumber());
        this.preparedStatement.setInt(9, s.getAntiDotes());
        this.preparedStatement.setString(10, s.getKitNumber());
        this.preparedStatement.addBatch();
    }

    public void load (List<Serology> serologys) {
        try {
            for (Serology s: serologys) {
                insertOne(s);
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
