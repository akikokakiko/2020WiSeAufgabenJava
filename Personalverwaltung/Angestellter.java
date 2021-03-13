package Personalverwaltung;

public class Angestellter extends Mitarbeiter {
    // Attribute
    private double gehalt;

    //Konstruktor
    public Angestellter(String name, double gehalt) {
        super(name);
        this.gehalt = gehalt;
    }

    //Methoden
    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    @Override
    public double berechneVerdienst() {
        return gehalt;
    }

    public String toStoring() {
        return getName() + " Gehalt: " + String.format("%.2f", getGehalt()) + " Euro";
    }
}
