package Personalverwaltung;

public class Main {
    public static void main(String[] args) {
        //Hinweis1
        Verwaltung vw = new Verwaltung(20);
        vw.addMitarbeiter(new Arbeiter("Taro Yamada", 80.0, 8.0));
        vw.addMitarbeiter(new Arbeiter("Akiko Yoshimura", 135.0, 10.0));
        vw.addMitarbeiter(new Arbeiter("Kazuki Koga", 42.0, 6.0));
        vw.addMitarbeiter(new Arbeiter("Yuki Murai", 40.5, 4.5));
        vw.addMitarbeiter(new Angestellter("Koichi Yoshimura", 550.0));
        vw.addMitarbeiter(new Angestellter("Yuko Takabayashi", 430.0));
        vw.addMitarbeiter(new Angestellter("Esther Yi", 380.0));
        vw.addMitarbeiter(new Angestellter("Bastian Ganze", 570.0));
        //Hinweis2
        System.out.println("Personalkosten: " + vw.berechnePersonalkosten() +" Euro");
        //Hinweis3
        vw.removeMitarbeiter(vw.getMitarbeiter()[3]);
        //Hinweis4
        System.out.println("Personalkosten: " + vw.berechnePersonalkosten() +" Euro");
        //Hinweis5
        vw.zeigeArbeiterMitWenigerAlsXStunden(7);
    }
}