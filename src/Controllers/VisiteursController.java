package Controllers;

import Repositories.VisiteurRepository;
import models.Visiteur;

import java.util.ArrayList;
import java.util.Date;

public class VisiteursController {
    VisiteurRepository visRepo = new VisiteurRepository();

    public ArrayList<Visiteur> getVisiteurs(){
        return visRepo.findAll();
    }

    public boolean createVisiteur(Visiteur visiteur){
        boolean visiteurAdded = visRepo.create(visiteur);
        return visiteurAdded;
    }

    public Visiteur getVisiteur(String idCompte){
        return visRepo.find(idCompte);
    }

    public Visiteur getVisiteur(String email, Date dateNaissance){
        Visiteur visiteur = new Visiteur();
        return visiteur;
    }

    public boolean editVisiteur(Visiteur visiteur){
        return false;
    }

    public boolean deleteVisiteur(String compteId){
        return true;
    }

}
