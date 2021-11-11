package Repositories;

import models.Benevole;

import java.util.ArrayList;

public class BenevoleRepository {
    ArrayList<Benevole> list = new ArrayList<>();


    public ArrayList<Benevole> findAll(){
        return this.list;
    }

    public boolean create(Benevole benevole){
        list.add(benevole);
        return true;
    }

    public boolean delete(String compteId){
        for(Benevole ben: this.list){
            if(ben.getCompteId().equals(compteId)){
                list.remove(ben);
                return true;
            }
        }
        return false;
    }

    public boolean update(Benevole benevole){
        for(Benevole ben: this.list){
            if(ben.getCompteId().equals(benevole.getCompteId())){
                list.remove(ben);
                list.add(benevole);
                return true;
            }
        }
        return false;
    }

}
