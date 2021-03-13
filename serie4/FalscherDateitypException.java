package serie4;

public class FalscherDateitypException extends Exception {
  //Konstruktor
  public FalscherDateitypException(String dateiname) {

    super(dateiname + " hat eine nicht kompatible Dateiendung.");
  }
}
