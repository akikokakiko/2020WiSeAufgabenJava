package market;

public class Marktsimulator{
  // Attribute
  private Marktanteil[] tagesMarktanteil;
  private double bleibBeiA;
  private double bleibBeiB;

  //Konstruktor
  public Marktsimulator(Marktanteil start, int tage, double bleibBeiA, double bleibBeiB) {
    tagesMarktanteil = new Marktanteil[tage+1];
    this.tagesMarktanteil[0] = start;
    this.bleibBeiA = bleibBeiA;
    this.bleibBeiB = bleibBeiB;
  }

  //Methoden
  public void simuliere() {
    for(int i=1; i< tagesMarktanteil.length; i++){
      tagesMarktanteil[i] = tagesMarktanteil[i-1].naechsterTag(bleibBeiA, bleibBeiB);
    }
  }

  public void zeigeMarktverlauf(){

    System.out.println("Marktentwicklung");
    System.out.print("Produkt A: ");
    for(int i=0; i<tagesMarktanteil.length; i++) {
      System.out.print(tagesMarktanteil[i].getKaeuferVonA() +" ");
    }
    System.out.println();
    System.out.print("Produkt B: ");
    for(int i=0; i<tagesMarktanteil.length; i++) {
      System.out.print(tagesMarktanteil[i].getKaeuferVonB() +" ");
    }
    System.out.println();
    System.out.println("Finale Marktaufteilung");
    String last = tagesMarktanteil[tagesMarktanteil.length-1].toString();
    System.out.println(last);


  }


}
