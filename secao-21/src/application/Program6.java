package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program6 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement;

        try {
            connection = DB.getConnection();
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090.0 WHERE DepartmentId = 1");

            //int x = 1;
            //if (x < 2) {
            //    throw new SQLException("Fake error");
            //}

            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090.0 WHERE DepartmentId = 2");

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to roll back! Caused by: " + e.getMessage());
            }
        }
    }
}