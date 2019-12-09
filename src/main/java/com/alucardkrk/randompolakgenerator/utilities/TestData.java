package com.alucardkrk.randompolakgenerator.utilities;

import com.alucardkrk.randompolakgenerator.persongenerator.Man;
import com.alucardkrk.randompolakgenerator.persongenerator.Woman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestData {
    Connection connection;

    public TestData() {
        connection = DatabaseConnection.getConnection();
    }

    public String getRandomPersonParam(String param, String table) throws SQLException {
        ResultSet resultSet = getQueryResult("SELECT "+param+" FROM "+ table +" ORDER BY Rand() LIMIT 1");
        String result = "";
        resultSet.next();
        result = resultSet.getString(param);
        return result.substring(0,1).toUpperCase() + result.substring(1).toLowerCase();

    }

    public Woman generateRandomWoman() throws SQLException {
        String name = getRandomPersonParam("imie", "imiona_zenskie");
        String surname = getRandomPersonParam("nazwisko", "nazwiska_zenskie");
        String city = getRandomPersonParam("nazwa", "miasta");
        String street = getRandomPersonParam("nazwa", "ulice");
        connection.close();
        return new Woman(name, surname,city,street);
    }
    public Man generateRandomMan() throws SQLException {
        String name = getRandomPersonParam("imie", "imiona_meskie");
        String surname = getRandomPersonParam("nazwisko", "nazwiska_meskie");
        String city = getRandomPersonParam("nazwa", "miasta");
        String street = getRandomPersonParam("nazwa", "ulice");
        connection.close();
        return new Man(name, surname,city,street);
    }



    private ResultSet getQueryResult(String query){


        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
