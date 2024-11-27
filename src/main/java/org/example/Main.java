package org.example;

import org.example.Models.User;
import org.example.Services.ServiceUser;
import org.example.Utils.DatabaseConnection;

import java.sql.*;

public class Main {

    private static Connection con = new DatabaseConnection().getConnection();
    private static ServiceUser _serviceUser = new ServiceUser(con);

    public static void main(String[] args) {
        User user = new User(_serviceUser.getSize()+1, "Doe", "John", 25);
        _serviceUser.ajout(user);
        _serviceUser.afficher();
        _serviceUser.modifier(user);
        _serviceUser.afficher();
    }
}