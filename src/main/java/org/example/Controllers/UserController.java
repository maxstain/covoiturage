package org.example.Controllers;

import org.example.DAO.User;
import org.example.Services.ServiceUser;
import org.example.Utils.DatabaseConnection;

import java.sql.Connection;

public class UserController {
    private static Connection con = new DatabaseConnection().getConnection();
    private static ServiceUser _serviceUser = new ServiceUser(con);

    public void ajout(User user) {
        _serviceUser.ajout(user);
    }

    public void afficher() {
        _serviceUser.afficher();
    }

    public void modifier(User user) {
        _serviceUser.modifier(user);
    }

    public void supprimer(User user) {
        _serviceUser.supprimer(user);
    }

    public int getSize() {
        return _serviceUser.getSize();
    }

    public void truncate() {
        _serviceUser.truncate();
    }
}
