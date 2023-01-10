package be.technifutur.stage;

import java.util.Map;
import java.util.TreeMap;

public class Personne {
    private String nom;
    private String club;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Map<Activite, Integer> getParticipe() {
        return participe;
    }

    public void setParticipe(Map<Activite, Integer> participe) {
        this.participe = participe;
    }

    Map<Activite, Integer> participe = new TreeMap<>();
}
