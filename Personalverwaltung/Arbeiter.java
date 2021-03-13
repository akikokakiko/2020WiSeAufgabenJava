package Personalverwaltung;

public class Arbeiter extends Mitarbeiter {
    // Attribute
    private double stundenlohn;
    private double geleisteteStunden;

    //Konstruktor
    public Arbeiter(String name, double stundenlohn, double geleisteteStunden) {
        super(name);
        this.stundenlohn = stundenlohn;
        this.geleisteteStunden = geleisteteStunden;
    }

    //Methoden
    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }

    public double getGeleisteteStunden() {
        return geleisteteStunden;
    }

    public void setGeleisteteStunden(double geleisteteStunden) {
        this.geleisteteStunden = geleisteteStunden;
    }

    @Override
    public double berechneVerdienst() {
        return geleisteteStunden*stundenlohn;
    }

    public String toString() {
        return getName() + " Stundenlohn: " + String.format("%.2f", stundenlohn) + " Euro geleistete Stunden: " + geleisteteStunden + " Stunden";
    }
}
