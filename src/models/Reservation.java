package models;

import java.util.Date;

public class Reservation {
    String reservationId;
    String nom;
    String prenom;
    Date dateVisite;
    Date heureVisite;
    int typeDose;

    public String getReservationId(){
        return reservationId;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }
}
