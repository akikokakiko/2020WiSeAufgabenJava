package Baum;

public class BaumProzessor {
  private Knoten wurzelDesBaumes;
  private Operator operator;

  public BaumProzessor(Knoten wurzelDesBaumes, Operator operator) {
    this.wurzelDesBaumes = wurzelDesBaumes;
    this.operator = operator;
  };

  public void berechneErgebnis() {
    verarbeiteKnoten(wurzelDesBaumes);
    System.out.println(operator.getBezeichnung());
  }

  public void verarbeiteKnoten(Knoten knoten){
    operator.verarbeiteWert(knoten.getWert());
    for(Knoten kinder : knoten.getKinder()) {
      verarbeiteKnoten(kinder);
    }
  }
}
