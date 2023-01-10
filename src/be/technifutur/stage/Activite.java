package be.technifutur.stage;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Activite implements Serializable {

    private int prix;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    private String nom;
    private Map<Integer, Personne> participants = new TreeMap<>();

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

    public Map<Integer, Personne> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<Integer, Personne> participants) {
        this.participants = participants;
    }
}
