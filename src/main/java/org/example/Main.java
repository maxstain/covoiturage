package org.example;

import java.sql.*;

public class Main {
    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/covoiturage";
    private static String user = "root";
    private static String password = "";
    private static Statement ste;

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            ste = con.createStatement();
            String req = "TRUNCATE TABLE users";
            int res3 = ste.executeUpdate(req);
            req = "insert into users (nom, prenom, age) values ('Tounsi', 'Wael', 25)";
            int res1 = ste.executeUpdate(req);
            req = "select * from users";
            ResultSet res2 = ste.executeQuery(req);
            while (res2.next()) {
                System.out.println("Nom: " + res2.getString("nom") + "\nPrenom: " + res2.getString("prenom") + "\nAge: " + res2.getString("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}