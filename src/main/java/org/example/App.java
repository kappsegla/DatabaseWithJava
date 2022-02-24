package org.example;

import java.sql.*;

public class App {

    private static final String sqlQuery = "Select * from pet";
    private static final String sqlInsert = "INSERT INTO pet VALUES (?,?,?,?,?,?)";
    private static final String sqlUpdate = "UPDATE pet SET owner=? where name=?";
    private static final String sqlDelete = "DELETE from pet where name=?";


    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newton?user=user&password=password")) {
            //Select all rows
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString("owner"));
            }
            resultSet.close();
            statement.close();

            //Insert new row
//            PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
//            insertStatement.setString(1, "Sessan");
//            insertStatement.setString(2, "Martin");
//            insertStatement.setString(3, "cat");
//            insertStatement.setString(4, "f");
//            insertStatement.setDate(5, Date.valueOf("1990-06-01"));
//            insertStatement.setDate(6, Date.valueOf("2005-09-01"));
//
//            int i = insertStatement.executeUpdate();
//            System.out.println("Number of rows modified : " + i);
//            insertStatement.close();

            PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
            updateStatement.setString(1, "Martin");
            updateStatement.setString(2, "Sessan");
            int count = updateStatement.executeUpdate();
            updateStatement.close();
            System.out.println(count + " rows was updated.");


            PreparedStatement deleteStatement = connection.prepareStatement(sqlDelete);
            deleteStatement.setString(1,"Sessan");
            count = deleteStatement.executeUpdate();
            deleteStatement.close();

            System.out.println(count + " rows was deleted.");

        } catch (SQLException sqlException) {
            System.out.println("Error with database");
        }
    }
}
