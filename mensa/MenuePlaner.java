package mensa;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuePlaner {
  // Attribute
  private List<Zutat> zutatenListe;
  private Map<String, List<Gericht>> speiseplan;

  //Konstruktor
  public MenuePlaner(Zutat[] zutatenArray) {
      zutatenListe = new ArrayList<Zutat>(Arrays.asList(zutatenArray));
      speiseplan = new HashMap<>();
  }

  //Methoden
  private int zufallszahl(int minimum, int maximum) {
      return (int)(Math.random() * (maximum + 1 - minimum)) + minimum;
  }

  public Gericht erstelleGericht() {
    int anzahlZutaten = zufallszahl(3, 5);
    int hinzugefuegt;
    Gericht gericht = new Gericht();
    for(hinzugefuegt = 0; hinzugefuegt < anzahlZutaten; hinzugefuegt++) {
      Zutat zutat = zutatenListe.get((int)(Math.random() * (zutatenListe.size()-1)));
      gericht.addZutat(zutat);
      }
    return gericht;
    }

  public void erstelleMenueFuerWochentag(String tag, int anzahlGerichte) {
    List<Gericht> menue = new ArrayList<Gericht>();
    for(int i=0; i<anzahlGerichte; i++) {
      menue.add(erstelleGericht());
    }
    speiseplan.put(tag, menue);
  }

  public void erstelleSpeiseplan() {
    erstelleMenueFuerWochentag("Montag", 4);
    erstelleMenueFuerWochentag("Dienstag", 4);
    erstelleMenueFuerWochentag("Mittwoch", 5);
  }

  public String getMenueFuerWochentag(String tag) {
    StringBuilder mfw = new StringBuilder();
    if (speiseplan.containsKey(tag)) {
      mfw.append(tag +"\n");
      List<Gericht> sortieren = new ArrayList<Gericht>();
      sortieren = speiseplan.get(tag);
      Collections.sort(sortieren);
      for (int i = 0; i < sortieren.size(); i++) {
        mfw.append(sortieren.get(i).toString() + "\n");
      }
      }
      return mfw.toString();
    } else {
      return "Die Mensa hat geschlossen!";
    }
  }

}
