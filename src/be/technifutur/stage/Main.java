package be.technifutur.stage;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static ScannerInput input = new ScannerInput();


    public static void main(String[] args) {

        TreeMap<Integer, Activite> liste = new TreeMap<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"))) {
            liste = (TreeMap) in.readObject();
            System.out.println("Fichier chargé");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fichier introuvable");
        }
        StageControleur stage = new CreateStageControleur(input);
        StageVue vue = new StageVue();
        boolean stop = false;

        while (!stop) {
            switch (input.read("=====\n" +
                    "1.Ajouter une activive\n" +
                    "2.Ajouter un repas\n" +
                    "3.Ajouter un logement\n" +
                    "4.Supprimer une activive\n" +
                    "5.Ajouter un participant\n" +
                    "6.Supprimer un participant\n" +
                    "96.Lister les activites\n" +
                    "97.Lister les activites et leurs participants\n" +
                    "98.Sauvegarder la liste\n" +
                    "99.Quitter le programme\n" +
                    "=====")){
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
                case"5" -> {
                    stage.ajouterParticipant(liste);
                }
                case "6" ->{
                    stage.supprimerParticipant(liste);
                }
                case "96" ->{
                    stage.listeActivite(liste);
                }
                case "97" ->{
                    stage.listeActivite(liste);
                    int id = Integer.parseInt(input.read("Entrez l'activite pour en lister ses participants"));
                    stage.listeParticipants(liste,id);
                }
                case "98" ->{
                    sauvegarderListe(liste);
                }
                case "99" ->{
                    System.out.println("Vous quittez le programme");
                    stop = true;
                }
            }
        }
    }

    private static void sauvegarderListe(TreeMap<Integer, Activite> liste) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            out.writeObject(liste);
            System.out.println("Sauvegarde effectuée");
        } catch (IOException e) {
            System.out.println("Impsossible de sauvegarder");
        }
    }
}
