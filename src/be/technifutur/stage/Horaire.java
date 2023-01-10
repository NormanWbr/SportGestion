package be.technifutur.stage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Horaire implements Serializable {
    private LocalDate jour;
    private LocalTime debut;
    private LocalTime fin;

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public LocalTime getDebut() {
        return debut;
    }

    public void setDebut(LocalTime debut) {
        this.debut = debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
}
