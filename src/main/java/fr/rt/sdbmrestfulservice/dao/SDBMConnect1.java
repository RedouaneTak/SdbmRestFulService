package fr.rt.sdbmrestfulservice.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class SDBMConnect1 {

    private static Connection connexion;

    private SDBMConnect1() {

    }

    public static Connection getInstance() {
        if (connexion == null) {
            try {
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setServerName("127.0.0.1");
                ds.setPortNumber(1401);
                ds.setDatabaseName("SDBM");
                ds.setIntegratedSecurity(false);
                ds.setEncrypt(false);
                ds.setUser("sa");
                ds.setPassword("azerty@123456");
                connexion = ds.getConnection();
            }

            // Handle any errors that may have occurred.
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return connexion;
    }

}
