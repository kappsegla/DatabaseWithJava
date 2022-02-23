package org.example;

import java.sql.*;

public class App {

    private static final String sqlQuery = "Select * from pet";

    public static void main(String[] args) {


        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newton?user=user&password=password"))
        {
            //Do something with connection..
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while( resultSet.next() )
            {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString("owner"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException sqlException){
            System.out.println("Error with database");
        }
    }
}
