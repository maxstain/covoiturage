package org.example.Services.Reservation;

import org.example.DAO.Reservation;

public interface IServiceReservation {
    public void ajout(Reservation newReservation);

    public void afficher();

    public void modifier(Reservation reservation);

    public void supprimer(Reservation reservation);
}
