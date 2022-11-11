package org.eluzardo.java.bbdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/sigea";
    private static String username = "root";
    private static String pass = "1234";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection==null){
            connection= DriverManager.getConnection(url,username,pass);
        }
        return connection;
    }
}
