package Repositories;

import models.Reservation;

import java.util.ArrayList;
import java.util.Date;

public class ReservationRepository implements CrudRepository<Reservation, String>{
    ArrayList<Reservation> list = new ArrayList<>();

    @Override
    public ArrayList<Reservation> findAll() {
        return list;
    };

    @Override
    public Reservation find(String s) {
        return null;
    };

    @Override
    public boolean create(Reservation reservation) {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    };

    public ArrayList<Date> findAllByDateVisite(Date date){
        return null;
    }
}
