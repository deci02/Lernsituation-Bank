package vererbung;

public class main {

	public static void main(String[] args) {
		Verein v = new Verein();
		Spieler s1 = new Spieler("Mats", "Hummels", "Abwehr", 25);
		Spieler s2 = new Spieler("Mario", "Götze", "Mittelfeld", 14);
		Trainer t = new Trainer("Jürgen", "Klopp", s2);
		Arzt a = new Arzt("Markus", "Braun", "Orthopäde");

		v.hinzufuegenMitglied(s1);
		v.hinzufuegenMitglied(s2);
		v.hinzufuegenMitglied(t);
		v.hinzufuegenMitglied(a);

		v.ausgebenGehaltsliste();
	}

}
