package be.technifutur.stage;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static ScannerInput input = new ScannerInput();


    public static void main(String[] args) {
        Comparator<Activite> comparator = new Comparator<Activite>() {
            public int compare(Activite a, Activite b) {
                int comparaison = 0;
                if (comparaison == 0){
                    comparaison = a.getHoraire().getJour().compareTo(b.getHoraire().getJour());
                }
                if (comparaison == 0){
                    comparaison = a.getHoraire().getDebut().compareTo(b.getHoraire().getDebut());
                }
                if (comparaison == 0){
                    comparaison = a.getHoraire().getFin().compareTo(b.getHoraire().getFin());
                }
                return comparaison;
            }
        };

        TreeMap<Integer, Activite> liste = new TreeMap<>();
        StageControleur stage = new CreateStageControleur(input);
        StageVue vue = new StageVue();
        boolean stop = false;

        while (!stop) {
            switch (input.read("1.Ajouter une activive\n2.Ajouter un repas\n3.Ajouter un logement\n4.Supprimer une activive\n99.Quitter le programme")){
                case "1" -> {
                    stage.ajouterActivite(liste);
                }
                case "2" -> {
                    stage.ajouterRepas(liste);
                }
                case "3" -> {
                    stage.ajouterLogement(liste);
                }
                case "4" -> {
                    stage.deleteActivite(liste);
                }
                case "99" ->{
                    System.out.println("Vous quittez le programme");
                    stop = true;
                }
            }
        }
    }
}
