package it.fi.itismeucci.barletti;

import java.util.ArrayList;

public class Messaggio {
    private ArrayList<Biglietto> listaBiglietti;


    public Messaggio() {
    }

    public Messaggio(ArrayList<Biglietto> listaBiglietti) {
        this.listaBiglietti = listaBiglietti;
    }

    public ArrayList<Biglietto> getListaBiglietti() {
        return this.listaBiglietti;
    }

    public void setListaBiglietti(ArrayList<Biglietto> listaBiglietti) {
        this.listaBiglietti = listaBiglietti;
    }

    public Messaggio listaBiglietti(ArrayList<Biglietto> listaBiglietti) {
        setListaBiglietti(listaBiglietti);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " listaBiglietti='" + getListaBiglietti() + "'" +
            "}";
    }

}
