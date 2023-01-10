package be.technifutur.stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class CreateStageControleur implements StageControleur {

    private final Input input;

    public CreateStageControleur(Input input) {
        this.input = input;
    }

    @Override
    public void ajouterActivite(TreeMap<Integer, Activite> liste) {
        Activite activite = new Activite();
        activite.setNom(input.read("Nom de l'activité"));
        String inputJour = input.read("Date : jj/mm/aaaa");
        activite.getHoraire().setJour(LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        String heureDebut = input.read("Heure de début : hh:mm");
        activite.getHoraire().setDebut(LocalTime.parse(heureDebut));
        String heureFin = input.read("Heure de fin : hh:mm");
        activite.getHoraire().setFin(LocalTime.parse(heureFin));
        liste.put(liste.size(), activite);
    }

    @Override
    public void ajouterRepas(TreeMap<Integer, Activite> liste) {
        Activite activite = new Activite();
        activite.setNom("Repas");
        String inputJour = input.read("Date : jj/mm/aaaa");
        activite.getHoraire().setJour(LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        String time = input.read("1.Matin\n2.Midi\n3.Soir");
        switch (time) {
            case "1" -> {
                activite.getHoraire().setDebut(LocalTime.of(8, 00));
                activite.getHoraire().setFin(LocalTime.of(9, 00));
            }
            case "2" -> {
                activite.getHoraire().setDebut(LocalTime.of(12, 00));
                activite.getHoraire().setFin(LocalTime.of(13, 00));
            }
            case "3" -> {
                activite.getHoraire().setDebut(LocalTime.of(19, 00));
                activite.getHoraire().setFin(LocalTime.of(20, 00));
            }
        }
        liste.put(liste.size(), activite);

    }

    @Override
    public void ajouterLogement(TreeMap<Integer, Activite> liste) {
        Activite activite = new Activite();
        activite.setNom("Logement");
        String inputJour = input.read("Date : jj/mm/aaaa");
        activite.getHoraire().setJour(LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        activite.getHoraire().setDebut(LocalTime.of(21, 00));
        activite.getHoraire().setFin(LocalTime.of(06, 00));
        liste.put(liste.size(), activite);
    }

    @Override
    public void deleteActivite(TreeMap<Integer, Activite> liste) {
        if (liste.size() > 0) {
            listeActivite(liste);
            liste.remove(Integer.parseInt(input.read("Entrez l'ID de l'activite à supprimer")));
        } else {
            System.out.println("Pas d'activite à supprimer");
        }

    }

    @Override
    public void ajouterParticipant(TreeMap<Integer, Activite> liste) {
        if (liste.size() > 0) {
            listeActivite(liste);
            int id = Integer.parseInt(input.read("Entrez l'ID de l'activite"));
            Personne personne = new Personne();
            personne.setNom(input.read("Entrez le nom de la personne"));
            personne.setClub(input.read("Entrez le club de la personne"));
            liste.get(id).getParticipants().put(liste.get(id).getParticipants().size(), personne);
        } else {
            System.out.println("Pas d'activite");
        }
    }

    @Override
    public void supprimerParticipant(TreeMap<Integer, Activite> liste) {
        if (liste.size() > 0) {
            listeActivite(liste);
            int id = Integer.parseInt(input.read("Entrez l'id de l'activite ou vous souhaitez supprimer un participant"));
            if (liste.get(id).getParticipants().size() > 0) {
                listeParticipants(liste, id);
                int personne = Integer.parseInt(input.read("Entrez l'id de la personne à suprimer"));
                liste.get(id).getParticipants().remove(personne);
            } else {
                System.out.println("Pas de participant");
            }
        } else {
            System.out.println("Pas d'activite");
        }
    }

    @Override
    public void listeActivite(TreeMap<Integer, Activite> liste) {
        for (Map.Entry<Integer, Activite> entry : liste.entrySet()) {
            int key = entry.getKey();
            Activite value = entry.getValue();
            System.out.println("==========");
            System.out.println("ID : " + key);
            System.out.println("Nom : " + value.getNom());
            System.out.println("Date : " + value.getHoraire().getJour());
            System.out.println("Debut : " + value.getHoraire().getDebut());
        }
    }

    @Override
    public void listeParticipants(TreeMap<Integer, Activite> liste, int id) {
        for (Map.Entry<Integer, Personne> entry : liste.get(id).getParticipants().entrySet()) {
            int key = entry.getKey();
            Personne value = entry.getValue();
            System.out.println("ID : " + key);
            System.out.println("Nom : " + value.getNom());
            System.out.println("Club : " + value.getClub());
        }
    }
}
