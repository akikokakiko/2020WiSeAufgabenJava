package Baum;

public class Summe implements Operator {
  private double summe;

  public Summe() {
    summe = 0.0;
  }

  @Override
  public void verarbeiteWert(double wert) {
    summe += wert;
  }

  @Override
  public double liefereErgebnis() {
    return summe;
  }

  @Override
  public String getBezeichnung() {
    return "Summe: " + liefereErgebnis();
  }
}
