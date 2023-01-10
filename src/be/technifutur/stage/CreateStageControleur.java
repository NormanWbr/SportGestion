package be.technifutur.stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class CreateStageControleur implements StageControleur {

    private final Input input;

    public CreateStageControleur(Input input){
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
        liste.put(liste.size(),activite);
    }

    @Override
    public void ajouterRepas(TreeMap<Integer, Activite> liste) {
        Activite activite = new Activite();
        activite.setNom("Repas");
        String inputJour = input.read("Date : jj/mm/aaaa");
        activite.getHoraire().setJour(LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        String time = input.read("1.Matin\n2.Midi\n3.Soir");
        switch (time){
            case "1" -> {
                activite.getHoraire().setDebut(LocalTime.of(8,00));
                activite.getHoraire().setFin(LocalTime.of(9,00));
            }
            case "2" ->{
                activite.getHoraire().setDebut(LocalTime.of(12,00));
                activite.getHoraire().setFin(LocalTime.of(13,00));
            }
            case "3" ->{
                activite.getHoraire().setDebut(LocalTime.of(19,00));
                activite.getHoraire().setFin(LocalTime.of(20,00));
            }
        }
        liste.put(liste.size(),activite);

    }

    @Override
    public void ajouterLogement(TreeMap<Integer, Activite> liste) {
        Activite activite = new Activite();
        activite.setNom("Logement");
        String inputJour = input.read("Date : jj/mm/aaaa");
        activite.getHoraire().setJour(LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        activite.getHoraire().setDebut(LocalTime.of(21,00));
        activite.getHoraire().setFin(LocalTime.of(06,00));
        liste.put(liste.size(),activite);
    }

    @Override
    public void deleteActivite(TreeMap<Integer, Activite> liste) {
        if (liste.size()>0){
            for (Map.Entry<Integer, Activite> entry : liste.entrySet()) {
                int key = entry.getKey();
                Activite value = entry.getValue();
                System.out.println("ID : " + key);
                System.out.println("Nom : " + value.getNom());
                System.out.println("Date : " + value.getHoraire().getJour());
                System.out.println("Debut : " + value.getHoraire().getDebut());
            }
            liste.remove(Integer.parseInt(input.read("Entrez l'ID de l'activite à supprimer")));
        }else{
            System.out.println("Pas d'activite à supprimer");
        }

    }
}
