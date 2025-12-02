package vererbung;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Verein {

	private ArrayList<Person> mitglieder = new ArrayList<Person>();

	public void hinzufuegenMitglied(Person p) {
		this.mitglieder.add(p);
	}

	public void ausgebenGehaltsliste() {
		double gesamt = 0;
		System.out.println("Typ\tName\tVorname\tJahresgehalt\tSonstiges");
		System.out.println("--------------------------------------");
		for (int i = 0; i < this.mitglieder.size(); i++) {
			System.out.println(this.mitglieder.get(i).erzeugenZeile());
			gesamt += this.mitglieder.get(i).gehalt;
		}
		System.out.println(
				"Summe der Jahresgehälter: ".concat(new DecimalFormat("#,##0.00").format(gesamt)).concat(" €"));
	}

}
