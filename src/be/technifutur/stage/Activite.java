package be.technifutur.stage;

import java.util.Map;
import java.util.TreeMap;

public class Activite {
    private String nom;
    private Map<Personne, Integer> participants = new TreeMap<>();

    private  Horaire horaire = new Horaire();

    public Horaire getHoraire() {
        return horaire;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<Personne, Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<Personne, Integer> participants) {
        this.participants = participants;
    }

}
