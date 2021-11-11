package models;

public class Benevole extends User{

    Benevole(int compteId, String email, String password, int code, String nom, String prenom, String codePostal, String ville, String telephone, Role role) {
        super(compteId, email, password, code, nom, prenom, codePostal, ville, telephone, role);
    }

    public HoraireBenevole[] horaireBenevole(){
        HoraireBenevole[] test = new HoraireBenevole[3];
        return test;
    }

    public String getCompteId(){
        return this.compteId;
    }
}
