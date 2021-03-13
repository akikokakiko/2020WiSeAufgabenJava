package serie4;

public class Main {
    public static void main(String[] args) {
        BuchstabenStat bs = new BuchstabenStat();
        String projectPath = System.getProperty("user.dir") + "/src/serie4/Mitgabe/";
        try {
            bs.analysiere(projectPath + "Faust.txt");
        } catch(FalscherDateitypException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch(UngueltigesZeichenException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        bs.zeigeTop10();
        bs.schreibeStatistik(projectPath + "FaustStat.txt");
    }
}
