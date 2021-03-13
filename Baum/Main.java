package Baum;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Knoten k1 = new Knoten(1.0, new ArrayList<Knoten>());
    Knoten k2 = new Knoten(5.3, new ArrayList<Knoten>());
    Knoten k3 = new Knoten(4.4, Arrays.asList(k1, k2));
    Knoten k4 = new Knoten(9.2, new ArrayList<Knoten>());
    Knoten k5 = new Knoten(3.1, Arrays.asList(k4));
    Knoten w = new Knoten(7.0, Arrays.asList(k3, k5));

    Summe summe = new Summe();
    Durchschnitt ds = new Durchschnitt();

    BaumProzessor bp = new BaumProzessor(w, summe);
    bp.berechneErgebnis();

    bp = new BaumProzessor(w, ds);
    bp.berechneErgebnis();
  }
}
