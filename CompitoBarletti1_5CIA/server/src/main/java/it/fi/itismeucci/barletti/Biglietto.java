package it.fi.itismeucci.barletti;

public class Biglietto {
    private int identificativo;
    private String numeroBiglietto;
    

    public Biglietto() {
    }

    public Biglietto(int identificativo, String numeroBiglietto) {
        this.identificativo = identificativo;
        this.numeroBiglietto = numeroBiglietto;
    }

    public int getIdentificativo() {
        return this.identificativo;
    }

    public void setIdentificativo(int identificativo) {
        this.identificativo = identificativo;
    }

    public String getNumeroBiglietto() {
        return this.numeroBiglietto;
    }

    public void setNumeroBiglietto(String numeroBiglietto) {
        this.numeroBiglietto = numeroBiglietto;
    }

    public Biglietto identificativo(int identificativo) {
        setIdentificativo(identificativo);
        return this;
    }

    public Biglietto numeroBiglietto(String numeroBiglietto) {
        setNumeroBiglietto(numeroBiglietto);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " identificativo='" + getIdentificativo() + "'" +
            ", numeroBiglietto='" + getNumeroBiglietto() + "'" +
            "}";
    }
}
