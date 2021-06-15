package transport.connectdataBase;

import transport.exception.InvalidDateException;
import transport.exception.InvalidNameTransportException;
import transport.model.Transport;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoadDataFromDataBase {
    public ArrayList<Transport> load() {
        ArrayList<Transport> transports = new ArrayList<>();
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "SELECT * FROM dbo.NAME_ATRANSPORT";
            var ps = conn.prepareStatement(sql);
            var result = ps.executeQuery();
            while (result.next()) {
                String idTransport = result.getString(1);
                String nameTransport = result.getString(2);
                String kindOfTransport = result.getString(3);
                String manufacturer = result.getString(4);
                String yearOfManufacture = result.getString(5);
                String where = result.getString(6);
                long price = result.getLong(7);
                float height = result.getFloat(8);
                float weight = result.getFloat(9);
                String licensePlate = result.getString(10);
                Transport transport = new Transport(idTransport,
                        nameTransport, kindOfTransport, manufacturer, yearOfManufacture,
                        where, price, height, weight, licensePlate);
                transports.add(transport);
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidDateException e) {
            e.printStackTrace();
        } catch (InvalidNameTransportException e) {
            e.printStackTrace();
        }
        return transports;

    }


}
