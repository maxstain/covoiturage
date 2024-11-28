package org.example.Services;

import org.example.Models.User;

import java.sql.*;

public class ServiceUser implements IService {

    private Statement ste;
    int size = 0;

    public ServiceUser(Connection con) {
        try {
            ste = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void truncate() {
        try {
            ste.executeUpdate("truncate table users");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ajout(User newUser) {
        try {
            String req = "insert into users (nom, prenom, age) values (" +
                    newUser.getNom() + ", " +
                    newUser.getPrenom() + ", " +
                    newUser.getAge()
                    + ")";
            int res = ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void afficher() {
        try {
            ResultSet res = ste.executeQuery("select * from users");
            while (res.next()) {
                System.out.println("ID: " + res.getInt("id") +
                        "\nNom: " + res.getString("nom") +
                        "\nPrenom: " + res.getString("prenom") +
                        "\nAge: " + res.getInt("age")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(User user) {
        try {
            ste.executeUpdate("update users set nom to 'Ammar'" + " where id = " + user.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(User user) {

    }

    public int getSize() {
        try {
            ResultSet result = ste.executeQuery("select count(*) from users");
            while (result.next()) {
                size = result.getInt(1);
            }
            return size;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
