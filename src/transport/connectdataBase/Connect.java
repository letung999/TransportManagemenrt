package transport.connectdataBase;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connect {
    private static final String NAME_SERVER ="DESKTOP-7QK2KIP\\SQLEXPRESS";
    private static final String NAME_DB ="TRANSPORT";
    private static final String NAME_USER ="sa";
    private static final String PASSWORD ="123";
    private static final int PORT = 1433;

    public SQLServerDataSource config(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName(NAME_SERVER);
        ds.setDatabaseName(NAME_DB);
        ds.setUser(NAME_USER);
        ds.setPassword(PASSWORD);
        ds.setPortNumber(PORT);
        return ds;
    }

}
