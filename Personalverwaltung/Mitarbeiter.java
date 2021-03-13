package Personalverwaltung;

public class Mitarbeiter {
  // Attribute
  private String name;

  //Konstruktor
  public Mitarbeiter(String name) {
    this.name = name;
  }

  //Methoden
  public String getName() {
    return name;
  }

  public double berechneVerdienst() {
    return 0.0;
  }

  public String toString() {
    return getName();
  }

}


