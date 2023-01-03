package be.technifutur.stage;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class test {

    private static ScannerInput input = new ScannerInput();
    public static void main(String[] args) {
        boolean stop = false;
        ArrayList<Activite> liste = new ArrayList<>();
        Controller stage = new Controller();

        while (!stop) {
            switch (input.read("1. Ajouter un stage\n2. Inscrire un participant\n3. Afficher l'horaire\n5. Stopper le programme")) {
                case "1" -> {
                    System.out.println("Ajouter un stage");
                    Activite activite = new Activite();
                    liste.add(stage.setAjouterActivite(activite));
                }
                case "2" -> {
                    System.out.println("Inscrire un participant");
                    int stageCpt = Integer.parseInt(input.read("Entrez le stage dans lequel vous souhaitez ajouter une pesonne :"));
                    stage.afficherListe(liste);
                    stage.ajouterPersonne(stageCpt,liste);
                }
                case "3" ->{
                    stage.afficherHoraire(liste);
                }
                case "5" -> {
                    System.out.println("Stopper le programme");
                    stop = true;
                }
                default -> System.out.println("Rien");
            }
        }

    }
}
