package org.example.Services;

import org.example.Models.User;

import java.sql.*;

public interface IService {
    public void ajout(User newUser);
    public void afficher();
    public void modifier(User user);
    public void supprimer(User user);
}
