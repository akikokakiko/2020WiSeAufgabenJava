package Personalverwaltung;

public class Verwaltung {
    // Attribute
    private Mitarbeiter[] mitarbeiter;

    //Konstruktor
    public Verwaltung(int anzahlMitarbaiter) {
        mitarbeiter = new Mitarbeiter[anzahlMitarbaiter];
    }

    //Methoden
    public Mitarbeiter[] getMitarbeiter() {
        return mitarbeiter;
    }

    public boolean addMitarbeiter(Mitarbeiter neuerMitarbeiter) {
        for (int i=0; i<mitarbeiter.length; i++) {
            if (mitarbeiter[i] == null) {
                mitarbeiter[i] = neuerMitarbeiter;
                return true;
            }
        }
        return false;
    }

    public boolean removeMitarbeiter(Mitarbeiter removeMitarbeiter) {
        for(int i=0; i<mitarbeiter.length; i++) {
           if(mitarbeiter[i] == removeMitarbeiter) {
               mitarbeiter[i] = null;
               return true;
            }
        }
        return false;
    }

    public double berechnePersonalkosten() {
        double sum = 0.0;
        for(int i=0; i<mitarbeiter.length; i++) {
            if(mitarbeiter[i] != null) {
                sum += mitarbeiter[i].berechneVerdienst();
            }
        }
        return sum;
    }


    public void zeigeArbeiterMitWenigerAlsXStunden(double stunden) {
        System.out.println("Arbeiter mit weniger als " +String.format("%.1f", stunden)+ " Stunden:");
        for(Mitarbeiter mitarbeiter : this.mitarbeiter) {
            if(mitarbeiter instanceof Arbeiter && ((Arbeiter) mitarbeiter).getGeleisteteStunden() <= stunden) {
                System.out.println(mitarbeiter.toString());
            }
        }

    }
}
