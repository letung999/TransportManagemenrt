package transport.connectdataBase;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;

public class DeleteATransportInDataBase {
    public int delete(String ID) {
        var connect = new Connect();
        var ds = connect.config();
        try {
            var conn = ds.getConnection();
            var sql = "DELETE dbo.NAME_ATRANSPORT WHERE idTransport ='" + ID + "'";
            var st = conn.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLServerException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
