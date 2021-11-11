package Controllers;

import Repositories.BenevoleRepository;
import models.Benevole;

import java.util.ArrayList;

public class BenevolesController {
    BenevoleRepository benRepo = new BenevoleRepository();

    public ArrayList<Benevole> getBenevoles(){
        return benRepo.findAll();
    }

    public boolean createBenevole(Benevole ben){
        boolean createdBenevole = benRepo.create(ben);
        return createdBenevole;
    }

    public boolean editBenevole(Benevole ben){
        boolean modifiedBenevole = benRepo.update(ben);
        return modifiedBenevole;
    }

    public boolean deleteBenevole(String compteId){
        boolean deletedBenevole = benRepo.delete(compteId);
        return deletedBenevole;
    }
}
