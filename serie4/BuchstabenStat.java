package serie4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class BuchstabenStat {
  // Attribute
  private Map<Character, Integer> buchstabenHaeufigkeiten;
  private long buchstabenAnzahl;

  //Konstruktor
  public BuchstabenStat() {
    this.buchstabenHaeufigkeiten = new HashMap<Character, Integer>();
    this.buchstabenAnzahl = 0;
  }

  //Methoden

  private void pruefeDateityp(String dateiname) throws FalscherDateitypException {
    String end = dateiname.substring(dateiname.length() - 4);
    if (!end.matches("(?i).txt")) {
      throw new FalscherDateitypException(dateiname);
    }
  }

  private void verarbeiteZeichen(char zeichen) throws UngueltigesZeichenException {
    zeichen = Character.toUpperCase(zeichen);
    if (Character.isLetter(zeichen)) {
      if (buchstabenHaeufigkeiten.containsKey(zeichen)) {
        buchstabenHaeufigkeiten.replace(zeichen, buchstabenHaeufigkeiten.get(zeichen) + 1);
      } else {
        buchstabenHaeufigkeiten.put(zeichen, 1);
      }
      buchstabenAnzahl++;
    } else if (!Character.isDefined(zeichen)) {
      throw new UngueltigesZeichenException();
    }
  }

  private void verarbeiteZeile(String zeile) throws UngueltigesZeichenException {
    char[] c = zeile.toCharArray();
    for (char c1 : c) {
      verarbeiteZeichen(c1);
    }
  }

  public void analysiere(String dateiname) throws FalscherDateitypException, UngueltigesZeichenException {
    pruefeDateityp(dateiname);

    String data;
    int countLine = 0;
    try (FileReader fileReader = new FileReader(dateiname, java.nio.charset.StandardCharsets.UTF_8); BufferedReader bufferReader = new BufferedReader(fileReader)) {
      data = bufferReader.readLine();
      while (data != null) {
        countLine++;
        verarbeiteZeile(data);
        data = bufferReader.readLine();
      }
    } catch (FileNotFoundException e) {
      System.err.println("Die Datei kann nicht gefunden werden.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Einfabe/Ausgabe-Fehler treten auf.");
      System.exit(1);
    } catch (UngueltigesZeichenException e) {
      throw new UngueltigesZeichenException(dateiname, countLine);
    }
  }

  public void zeigeTop10() {
    System.out.println("Buchstaben-Top 10");
    Map<Character, Integer> sorted = buchstabenHaeufigkeiten.entrySet()
            .stream()
            .sorted(comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

    sorted.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
  }

  public String statistik() {
    StringBuilder str = new StringBuilder();
    Map<Character, Integer> buchstaben = new TreeMap<Character, Integer>(buchstabenHaeufigkeiten);
    buchstaben.entrySet().forEach(e -> str.append(e.getKey() + ": " + String.format("%.2f", (double)e.getValue() / buchstabenAnzahl) + "\n"));
    return str.toString();
  }

  public void schreibeStatistik(String dateiname){
    try(PrintWriter write = new PrintWriter(dateiname)) {
      write.println(statistik());
    } catch(IOException e) {
      System.err.println("Ein Ein/Aufgabe-Ausnahme tritt auf.");
      System.exit(1);
    }
  }

}

