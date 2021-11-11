package models;

import Enums.Role;

public class User {
//    TODO compteId is string instead of int
    String compteId;
    String email;
    String password;
    int code;
    String nom;
    String prenom;
    String adresse;
    String codePostal;
    String ville;
    String telephone;
    Role role;

    User(String compteId, String email, String password, int code, String nom, String prenom, String codePostal, String ville, String telephone, Role role){
        this.compteId = compteId;
        this.email = email;
        this.password = password;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville  = ville;
        this.telephone  = telephone;
        this.role = role;
    }
}
