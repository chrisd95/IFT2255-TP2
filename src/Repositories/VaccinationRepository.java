package Repositories;

import models.Vaccination;

import java.util.ArrayList;

public class VaccinationRepository implements CrudRepository<Vaccination, String>{
    @Override
    public ArrayList<Vaccination> findAll() {
        return null;
    }

    @Override
    public Vaccination find(String s) {
        return null;
    }

    @Override
    public boolean create(Vaccination vaccination) {
        return false;
    }

    @Override
    public boolean update(Vaccination vaccination) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
    public ArrayList<Vaccination> findAllByCompteId(String compteId){
        return null;
    }

    public boolean sendPreuveVaccination(int vaccinationId){
        return true;
    }


}
