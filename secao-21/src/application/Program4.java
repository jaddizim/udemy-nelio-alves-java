package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {

    public static void main(String[] args) {

        String SQLQuery = "UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (DepartmentId = ?)";

        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery)) {

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
