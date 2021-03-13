package mensa;

import java.util.ArrayList;
import java.util.List;

public class Gericht implements Comparable<Gericht>{
  // Attribute
  private List<Zutat> zutaten;
  private double preis;

  //Konstruktor
  public Gericht() {
    zutaten = new ArrayList<Zutat>();
    preis = 1.0;
  }

  //Methoden

  public void addZutat(Zutat zutat) {
    zutaten.add(zutat);
    preis += zutat.getPreis();
  }

  public boolean hatZutat(Zutat zutat){
    if(zutaten.contains(zutat)) {
      return true;
    } else {
      return false;
    }
  }

  public String getName() {
    StringBuilder gerichtName = new StringBuilder();
    for(int i=0; i<zutaten.size(); i++) {
      String fullname = zutaten.get(i).getName();
      gerichtName.append(fullname.substring(0,3));
    }
    return gerichtName.toString();
  }

  public boolean istVegan() {
    for(int i=0; i<zutaten.size(); i++){
      if(!(zutaten.get(i).getVegan())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int compareTo(Gericht vergleichsobjekt) {
    if(this.preis < vergleichsobjekt.preis) {
      return -1;
    } else if (this.preis == vergleichsobjekt.preis) {
      return 0;
    } else {
      return 1;
    }
  }

  public String toString() {
    StringBuilder komponenten = new StringBuilder();
    komponenten.append(getName() + " ");
    if(istVegan() == true) {
      komponenten.append("(vegan) ");
    }
    for(int i=0; i<zutaten.size(); i++) {
      komponenten.append(zutaten.get(i).getName() + " ");
    }
    komponenten.append(String.format("%.2f", this.preis) + " Euro");
    return komponenten.toString();
  }


}
