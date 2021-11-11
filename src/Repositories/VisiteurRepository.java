package Repositories;

import models.Visiteur;

import java.util.ArrayList;

public class VisiteurRepository implements CrudRepository<Visiteur, String>{
    @Override
    public Visiteur find(String s) {
        return null;
    }

    @Override
    public ArrayList<Visiteur> findAll() {
        return null;
    }

    @Override
    public boolean create(Visiteur visiteur) {
        return false;
    }

    @Override
    public boolean update(Visiteur visiteur) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    public ArrayList<Visiteur> findPaginate(int skip, int limit){
        ArrayList<Visiteur> test = new ArrayList<>();
        return test;
    }
}
