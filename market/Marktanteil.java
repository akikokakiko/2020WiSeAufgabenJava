package market;
import java.lang.Math;

public class Marktanteil {
  // Attribute
  private int kaeuferVonA;
  private int kaeuferVonB;

  //Konstruktor
  public Marktanteil(int kaeuferVonA, int kaeuferVonB) {
      this.kaeuferVonA = kaeuferVonA;
      this.kaeuferVonB = kaeuferVonB;
  }


  //Methoden
  public int getKaeuferVonA() {

    return kaeuferVonA;
  }

  public int getKaeuferVonB() {

    return kaeuferVonB;
  }

  public Marktanteil naechsterTag(double bleibBeiA, double bleibBeiB) {
    int moveToA = 0;
    int moveToB = 0;
    int currentA = getKaeuferVonA();
    int currentB = getKaeuferVonB();
    for(int i = 0; i < currentA; i++) {
      if(Math.random() > bleibBeiA) {
        moveToB ++;
      }
    }
    for(int i = 0; i < currentB; i++) {
      if(Math.random() > bleibBeiB) {
        moveToA ++;
      }
    }
    int a = currentA - moveToB + moveToA;
    int b = currentB - moveToA + moveToB;
    return new Marktanteil(a, b);
  }

  public String toString(){
    double sum = kaeuferVonA + kaeuferVonB;
    double AP = kaeuferVonA/sum*100;
    double BP = kaeuferVonB/sum*100;

    return "Marktanteil Käufer Produkt A: " + kaeuferVonA + "(" + Math.round(AP) +"%) " + "Käufer Produkt B: " + kaeuferVonB + "(" + Math.round(BP) +"%) ";
  }


}
