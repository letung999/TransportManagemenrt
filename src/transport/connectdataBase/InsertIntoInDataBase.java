package transport.connectdataBase;

import transport.model.Transport;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.ArrayList;

public class InsertIntoInDataBase {
    public int Insert(ArrayList<Transport> transports) {
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "INSERT INTO dbo.NAME_ATRANSPORT" +
                    "(idTransport, nameTransport, kindOfTransport, manufacturer, yearOfManufacture," +
                    "whereManufacture, price, height,weightAtransport, licensePlate)" +
                    " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            var ps = conn.prepareStatement(sql);
            for (var transport : transports) {
                ps.setString(1, transport.getIdTransport());
                ps.setString(2, transport.getNameTransport());
                ps.setString(3, transport.getKindOfTransport());
                ps.setString(4, transport.getManufacturer());
                ps.setString(5, transport.getYearOfManufacture());
                ps.setString(6, transport.getWhere());
                ps.setLong(7, transport.getPrice());
                ps.setFloat(8, transport.getWeight());
                ps.setFloat(9, transport.getHeight());
                ps.setString(10, transport.getLicensePlate());
                ps.executeUpdate();
            }

        } catch (SQLServerException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;

    }
}
