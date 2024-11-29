package org.example.Services.Reservation;

import org.example.DAO.Reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceReservation implements IServiceReservation {

    private Statement ste;
    int size = 0;

    public ServiceReservation(Connection con) {
        try {
            ste = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void truncate() {
        String req = "truncate table reservations";
        try {
            ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ajout(Reservation newReservation) {
        String req = "insert into reservations (trajetId, passagerId, status) values ('" +
                newReservation.getTrajetId() + "', '" +
                newReservation.getPassagerId() + "', '" +
                newReservation.getStatus() + "')";
        try {
            ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void afficher() {
        String req = "select id, trajetId, passagerId, status from reservations";
        try {
            if (getSize() == 0) {
                System.out.println("Aucun reservation trouvée");
            } else {
                ResultSet res = ste.executeQuery(req);
                while (res.next()) {
                    System.out.println("ID: " + res.getInt("id") +
                            "\nTrajet ID: " + res.getInt("trajetId") +
                            "\nPassager ID: " + res.getInt("passagerId") +
                            "\nStatus: " + res.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Reservation reservation) {
        String req = "update reservations set nom = '" +
                reservation.getTrajetId() + "', prenom = '" +
                reservation.getPassagerId() + "', age = '" +
                reservation.getStatus() + "' where id = " + reservation.getId();
        try {
            ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(Reservation reservation) {
        String req = "delete from reservations where id = " + reservation.getId();
        try {
            ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public int getSize() {
        String req = "select count(*) from reservations";
        try {
            ResultSet result = ste.executeQuery(req);
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
