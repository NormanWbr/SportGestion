package be.technifutur.stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Controller {

    private Pattern pattern = Pattern.compile("([1-9][0-9]*)\\.([1-9][0-9]*)(\\..)?");

    private static ScannerInput input = new ScannerInput();
    public Activite ajouterActivite;

    public Personne ajouterPersonne;


    public Activite getAjouterActivite() {
        return ajouterActivite;
    }

    public Activite setAjouterActivite(Activite ajouterActivite) {
        ajouterActivite.nom = input.read("Entrez le nom de l'activité");
        String inputJour = input.read("Date : jj/mm/aaaa");
        ajouterActivite.horaire.date =  LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String heureDebut = input.read("Heure de début : hh:mm");
        ajouterActivite.horaire.debut = LocalTime.parse(heureDebut);
        String heureFin = input.read("Heure de fin : hh:mm");
        ajouterActivite.horaire.fin = LocalTime.parse(heureFin);
        return ajouterActivite;
    }

    public Personne getAjouterPersonne() {
        return ajouterPersonne;
    }

    public void setAjouterPersonne(Personne ajouterPersonne) {
        this.ajouterPersonne = ajouterPersonne;
    }


    public void afficherListe(ArrayList<Activite> liste) {
        int cpt = 0;
        for (Activite l : liste){
            System.out.println("Activite :"+cpt);
            System.out.println((l.nom));
            System.out.println(l.horaire.date);
            System.out.println(l.horaire.debut);
            System.out.println("==========");
            cpt += 1;
        }
    }

    public void ajouterPersonne(int stageCpt, ArrayList<Activite> liste) {
        Personne personne = new Personne();
        personne.nom = input.read("Entrez le nom de la personne");
        personne.club = input.read("Entrez le club de la personne");
        liste.get(stageCpt).participant.add(personne);
    }

    public void afficherHoraire(ArrayList<Activite> liste) {
        TreeSet<Activite> treeListe = new TreeSet<>(liste);
    }
}
