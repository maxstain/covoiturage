package org.example.Controllers;

import org.example.DAO.Trajet;
import org.example.Services.Trajet.ServiceTrajet;
import org.example.Utils.DatabaseConnection;

import java.sql.Connection;

public class TrajetController {
    private static Connection con = new DatabaseConnection().getConnection();
    private static ServiceTrajet _serviceTrajet = new ServiceTrajet(con);

    public void ajout(Trajet trajet) {
        _serviceTrajet.ajout(trajet);
    }

    public void afficher() {
        _serviceTrajet.afficher();
    }

    public void modifier(Trajet trajet) {
        _serviceTrajet.modifier(trajet);
    }

    public void supprimer(Trajet trajet) {
        _serviceTrajet.supprimer(trajet);
    }

    public int getSize() {
        return _serviceTrajet.getSize();
    }

    public void truncate() {
        _serviceTrajet.truncate();
    }
}
