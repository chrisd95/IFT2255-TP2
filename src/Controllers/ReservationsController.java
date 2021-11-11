package Controllers;

import Repositories.ReservationRepository;
import models.Reservation;

import java.util.ArrayList;
import java.util.Date;

public class ReservationsController {
    ReservationRepository reservRepo = new ReservationRepository();



    public ArrayList<Date> getPlagesDisponible(Date date, int nbVisiteurs){
        return null;
    }

    public ArrayList<Reservation> getReservationsDetails(Date heureVisite){
        return null;
    }

    public Reservation getReservation(int reservationId){
        return null;
    }

    public boolean createReservation(Reservation reservation){
        boolean reservationAdded = reservRepo.create(reservation);
        return reservationAdded;
    }
    public boolean createSpontane(Reservation reservation){
        boolean reservationAdded = reservRepo.create(reservation);
        return reservationAdded;
    }

    public ArrayList<Reservation> getProchainesReservations(){
        return reservRepo.findAll();
    }

    public boolean sendRappelReservation(){
        return true;
    }

}
