package org.example.Services.Trajet;

import org.example.DAO.Trajet;

public interface IServiceTrajet {
    public void ajout(Trajet newTrajet);

    public void afficher();

    public void modifier(Trajet trajet);

    public void supprimer(Trajet trajet);
}
