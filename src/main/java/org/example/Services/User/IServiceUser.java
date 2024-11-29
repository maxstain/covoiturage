package org.example.Services.User;

import org.example.DAO.User;

public interface IServiceUser {
    public void ajout(User newUser);

    public void afficher();

    public void modifier(User user);

    public void supprimer(User user);
}
