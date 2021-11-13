package Controllers;

import Repositories.ReservationRepository;
import models.Reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReservationsController {
    ReservationRepository reservRepo = new ReservationRepository();



    public ArrayList<Date> getPlagesDisponible(Date date){
        ArrayList<Date> dateList = new ArrayList<>();
        for(Reservation reserv: reservRepo.findAll()){
            dateList.add(reserv.getDateVisite());
        }

        System.out.println(getTimeSet(true));
        for(int i =0 ;i < 16; i++){
            dateList.add(new Date());
        }
        return dateList;
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

    public boolean deleteReservation(String reservationId){
        if(reservRepo.delete(reservationId)){
            return true;
        };
        return false;
    }
    public boolean editReservation(Reservation reservation){
        if(reservRepo.update(reservation)){
            return true;
        }
        return false;
    }

    // SOURCE : https://www.codeproject.com/Questions/5261178/How-create-a-time-slot-that-increase-a-time-by-15
    private ArrayList<String> getTimeSet(boolean isCurrentDay) {
        ArrayList results = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        for (int i = 0; i < 16; i++) {
            int n=30;
            Calendar calendar = new GregorianCalendar();
            if(!isCurrentDay)
                calendar.set(Calendar.HOUR_OF_DAY, 8);
            calendar.add(Calendar.HOUR_OF_DAY, -i );

            calendar.set(Calendar.MINUTE, 0);
            calendar.add(Calendar.MINUTE, n);

            calendar.set(Calendar.SECOND, 0);

            String  day1 = sdf.format(calendar.getTime());
            calendar.add(Calendar.HOUR, 0);
            calendar.add(Calendar.MINUTE, n);

            String day2 = sdf.format(calendar.getTime());


            String day = day1 + " - " + day2;
            results.add(i, day);
            System.out.println(results);
            n+=30;
        }
        return results;
    }
}

