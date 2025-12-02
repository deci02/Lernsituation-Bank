package vererbung;

import java.util.ArrayList;

public class Verein {

	private ArrayList<Person> mitglieder = new ArrayList<Person>();

	public void hinzufuegenMitglied(Person p) {
		this.mitglieder.add(p);
	}

	public void ausgebenGehaltsliste() {
		System.out.println("Typ\tName\tVorname\tJahresgehalt\tSonstiges");
		System.out.println("--------------------------------------");
		for (int i = 0; i < this.mitglieder.size(); i++) {
			System.out.println(this.mitglieder.get(i).erzeugenZeile());
		}
	}

}
