package com.alucardkrk.randompolakgenerator.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url= "jdbc:mysql://polak-database.cdlqwr1q2rhp.us-east-1.rds.amazonaws.com:3306/testdata";
        String username = "devuser";
        String password = "qwz1aw2as1";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
