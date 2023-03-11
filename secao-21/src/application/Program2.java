package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

    //Recuperação de Dados

    public static void main(String[] args) {

        try (Connection conn = DB.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM department")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)
                        + ", " + resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}