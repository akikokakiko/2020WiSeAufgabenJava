package market;

public class Main{
  public static void main(String[] args) {
    Marktanteil start = new Marktanteil(5000, 5000);
    Marktsimulator markt = new Marktsimulator(start, 20, 0.8, 0.7);
    markt.simuliere();
    markt.zeigeMarktverlauf();

  }
}
