package be.technifutur.stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    private static ScannerInput input = new ScannerInput();

    public static void main(String[] args) {

        boolean stop = false;

        while (!stop) {
            switch (input.read("1. Ajouter un stage\n2. Inscrire un participant\n5. Stopper le programme")) {
                case "1" -> {
                    System.out.println("Ajouter un stage");
                }
                case "2" -> {
                    System.out.println("Inscrire un participant");
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
