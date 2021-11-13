package Views;

import Controllers.ReservationsController;
import models.Reservation;
import models.User;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppMenu {
    private static ReservationsController resController = new ReservationsController();
    User user;


    public static String ecouterChoix() {
        return ecouterChoix("Choix: ");
    }
    public static String ecouterChoix(String texte) {
        Console console = System.console();
        System.out.println(console);
        String choix = console.readLine(texte);
        nettoyerConsole();
        return choix;
    }
    public static void nettoyerConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayLoginPage(){

    }

    public static void displayMenuPage() throws ParseException {
        boolean exit = false;

        do {
            System.out.println("Menu VaxTodo");
            System.out.println("1. Gestion des réservations");
            System.out.println("2. Gestion des comptes bénévoles");
            System.out.println("3. Gestion des comptes visiteurs");
            System.out.println("4. Demander preuve de vaccination");
            System.out.println("5. Envoyer rapport de vaccination");
            System.out.println("6. Gestion des formulaires");
            System.out.println("7. Quitter");

            String choix = ecouterChoix();


            switch (choix) {
                case "1":
                    gestionDeRendezVous();
                    break;
                case "2":
//                    gestionDesBenevoles();
                    break;
                case "3":
//                    gestionDesVisiteurs(listeDeVisiteurs);
                    break;
                case "4":
//                    traitementVisiteur();
                    break;
                case "5":
//                    envoyerSuivi();
                    break;
                case "6":
                     gestionDesFormulaires();
                    break;
                case "7":
                    exit = true;
                    break;
                case "8":
                    exit = true;
                    break;
                default:
                    System.out.println("CHOIX INVALIDE");
            }
        } while (!exit);
    }

    public static void gestionDeRendezVous() throws ParseException {
        boolean exit = false;

        do {
            System.out.println("Gestion des rendez-vous VaxTodo");
            System.out.println("1. Reservation d'une période");
            System.out.println("2. Annulation d'un rendez-vous");
            System.out.println("3. Modifier un rendez-vous");
            System.out.println("4. Creer un rendez-vous");
            System.out.println("5. Consulter le calendrier des disponibilités");
            System.out.println("6. Consulter la liste des visiteurs");
            System.out.println("7. Envoie la notification par courriel pour les prochains rendez-vous");
            System.out.println("8. Quitter");

            String choix = ecouterChoix();


            switch (choix) {
                case "1":
                    String numberOfVisitors = ecouterChoix("Entrez le nombre de visiteurs present dans le local SVP");
                    if(isNumeric(numberOfVisitors)){
                        int numberVisitors = Integer.parseInt(numberOfVisitors);
                        if(numberVisitors >= 40){
                            System.out.println("Erreur: il y a trop de visiteurs en ce moment. Attendez");
                            exit = true;
                            break;
                        }else{
                            consultCalendar();
                            Date choixDate = parseDate(ecouterChoix(), "dd/MM/yyyy");
                            if(remplirFormulaire()){
                                System.out.println("GOOD");
                            }
                            Reservation reservation = new Reservation();
                            if(resController.createReservation(reservation)){
                                System.out.println("Reservation reussie");

                            }else{
                                System.out.println("Reservation echouee");
                            }
                            break;
                        }
                    }else{
                        System.out.println("Ceci n'etait pas un nombre, SVP recommencer");
                        break;
                    }
                case "2":
                    String numero = ecouterChoix("Entrez le numero de reservation");

                    Reservation found = resController.getReservation(Integer.parseInt(numero));

                    System.out.println(found);

                    if(resController.deleteReservation(found.getReservationId())){
                        System.out.println("Annulation reussie");
                    }else{
                        System.out.println("Annulation pas reussie, essayez-encore");
                    };
                    break;
                case "3":
                    String resModifier = ecouterChoix("Entrez le numero de reservation a modifier");
                    Reservation foundModified = resController.getReservation(Integer.parseInt(resModifier));

                    System.out.println(foundModified);

                    if(resController.editReservation(foundModified)){
                        System.out.println("Modification reussie");
                    }else{
                        System.out.println("Modification pas reussie, essayez-encore");
                    };
                    break;
                case "4":
                    remplirFormulaire();
                    consultCalendar();
                    Date dateChoisie = parseDate(ecouterChoix("Selectionnez la date dd/MM/yyyy"), "dd/MM/YYYY");
                    Reservation newReservation = new Reservation();
                    newReservation.setDateVisite(dateChoisie);
                    if(resController.createReservation(newReservation)){
                        System.out.println("Creation du rendez-vous reussie");
                        envoyerCourriel();
                    };
                    break;
                case "5":
                    consultCalendar();
                    break;
                case "6":
                    consultVisitorList();
                case "7":
                    envoyerCourriel();
                case "8":
                    exit = true;
                    break;
                default:
                    System.out.println("CHOIX INVALIDE");
            }
        } while (!exit);

    }

    public static void envoyerCourriel(){
        System.out.println("Voici le message preecrit, voulez-vous le modifier? O/N");

        String choix = ecouterChoix("Voici le message preecrit, voulez-vous le modifier? O/N");

        if(choix.equals("O")){
            String newChoix = ecouterChoix("Ecrivez le nouveau message maintenant");
            System.out.println("Envoie des courriel reussie avec nouveau message:");
            System.out.println(newChoix);
        }else{
            System.out.println("Envoie des courriel reussie");
        }
    }
    public static void gestionDesFormulaires() throws ParseException {
        boolean exit = false;

        do {
            System.out.println("Gestion des formulaires VaxTodo");
            System.out.println("1. Remplir formulaire");
            System.out.println("2. Mise a jour du profil de vaccination");
            System.out.println("3. Quitter");

            String choix = ecouterChoix();


            switch (choix) {
                case "1":
                    remplirFormulaire();
                    break;
                case "2":
//                    miseAJourProfil();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("CHOIX INVALIDE");
            }
        } while (!exit);
    }

    public static boolean remplirFormulaire() throws ParseException {
        boolean exit = false;

        do {
            System.out.println("Est-ce que le visiteur peut remplir les informations? O/N");
            String choix = ecouterChoix();
            if(choix.equals("O")){
                System.out.println("Entrez les informations personelles");
                String infos = ecouterChoix();
                if(infos.equals("Bons informations")){
                    String formulaire = genererFormulaire(infos);
                    System.out.println(formulaire);
                    System.out.println("Impression formulaire");
                    exit = true;
                    return true;
                }
            }else{
                System.out.println("Prendre un autre rendez-vous? O/N");
                String prendreChoix = ecouterChoix();
                if(prendreChoix.equals("O")){
                    gestionDeRendezVous();
                }
                return false;
            }

            switch (choix) {
                case "1":
                    remplirFormulaire();
                    break;
                case "2":
//                    miseAJourProfil();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("CHOIX INVALIDE");
            }
        } while (!exit);
        return false;
    }

    public static String genererFormulaire(String infos){
        return infos;
    }

    public static void consultCalendar() throws ParseException {
        String dateString = ecouterChoix("Entrez la date dans le format dd/MM/yyyy");

        Date date = parseDate(dateString,"dd/MM/yyyy");

        ArrayList<Date> dates = resController.getPlagesDisponible(date);

        System.out.println("Voici la liste des plages disponibles");
        for(Date someDate : dates){
            System.out.println(someDate);
        }

    }

    public static void consultVisitorList() throws ParseException {
        Date date = parseDate(ecouterChoix("Entrez la date a consulter dd/MM/yyyy"), "dd/MM/yyyy");
        ArrayList<Reservation> found = resController.getReservationsDetails(date);
        System.out.println("There are this many people");
        System.out.println(found.size());
    }
    public void displayVisiteursPage(){

    }

    public void displayAddVisiteurPage(){

    }

    public void displayEditVisiteurPage(){

    }

    public void displayBenevolePage(){

    }

    public void displayAddBenevolePage(){

    }

    public void displayEditBenevolePage(){

    }

    public void displayCalendrierPage(){

    }

    public void displayCreateFormPage(){

    }

    public void displayUpdateFormPage(){

    }

    public void logout(){

    }

    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //https://stackoverflow.com/questions/882420/parse-string-to-date-with-different-format-in-java
    private static Date parseDate(String date, String format) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }
}
