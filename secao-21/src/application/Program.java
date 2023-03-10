package application;

import db.DB;

import java.sql.Connection;

public class Program {

    //Conexão com o BD

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        DB.closeConnection();

    }
}
