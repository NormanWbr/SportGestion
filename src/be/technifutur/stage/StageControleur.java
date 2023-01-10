package be.technifutur.stage;


import java.util.TreeMap;

public interface StageControleur {
    void ajouterActivite(TreeMap<Integer, Activite> liste);

    void ajouterRepas(TreeMap<Integer, Activite> liste);

    void ajouterLogement(TreeMap<Integer, Activite> liste);

    void deleteActivite(TreeMap<Integer, Activite> liste);
}
