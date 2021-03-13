package serie4;

public class UngueltigesZeichenException extends Exception {
  //Konstruktor
  public UngueltigesZeichenException() {
    super("Ungültiges Zeichen");
  }

  public UngueltigesZeichenException(String dateiname, int zeilenummer) {
    super("Ungültiges Zeichen in " + dateiname + " Zeile " + zeilenummer);
  }
}
