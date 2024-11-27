package org.example.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private Connection con;
    private String dburl = "jdbc:mysql://localhost:3306/covoiturage";
    private String dbuser = "root";
    private String dbpassword = "";
    private Statement ste;

    public DatabaseConnection() {
        try {
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
            System.out.println("Connexion établie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
}
