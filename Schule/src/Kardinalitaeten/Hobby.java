package Kardinalitaeten;

public class Hobby {
	public boolean valid;
	private String bezeichnung;
	private Person[] personen;

	public Hobby(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Hobby(String bezeichnung, Person person) {
		this.bezeichnung = bezeichnung;
		this.personen = new Person[1];
		personen[0] = person;
		person.hinzufuegenHobby(this);
		this.valid = true;
	}

	public void hinzufuegenPerson(Person p) {
		if (this.valid) {
		Person[] hobbiesCopy = new Person[personen.length + 1];
		for (int i = 0; i < personen.length; i++) {
			hobbiesCopy[i] = personen[i];
		}
		hobbiesCopy[hobbiesCopy.length - 1] = p;
		this.personen = hobbiesCopy;
		} else {
			System.out.println(this.bezeichnung + " darf nicht mehr existieren");
		}
	}

	public void loeschenPerson(Person p) {
		p.loeschenHobbyInternal(this);
		Person[] personenCopy = new Person[personen.length - 1];
		boolean indexGefunden = false;
		for (int i = 0; i < personen.length; i++) {
			if (this.personen[i].equals(p)) {
				indexGefunden = true;
			} else {
				if (indexGefunden) {
					personenCopy[i - 1] = this.personen[i];
				} else {
					personenCopy[i] = this.personen[i];
				}
			}
		}
		this.personen = personenCopy;
		this.valid = checkHasPersonen();
	}

	public void loeschenPersonInternal(Person p) {
		Person[] personenCopy = new Person[personen.length - 1];
		boolean indexGefunden = false;
		for (int i = 0; i < personen.length; i++) {
			if (this.personen[i].equals(p)) {
				indexGefunden = true;
			} else {
				if (indexGefunden) {
					personenCopy[i - 1] = this.personen[i];
				} else {
					personenCopy[i] = this.personen[i];
				}
			}
		}
		this.personen = personenCopy;
		this.valid = checkHasPersonen();
	}
	
	public void ausgebenPersonen() {
		if (this.valid) {
			for (int i = 0; i < this.personen.length; i++) {
				System.out.println(this.bezeichnung + ": " + this.personen[i].getName());
			}
		} else {
			System.out.println(this.bezeichnung + " durfte schon zu einem früheren Zeitpunkt nicht mehr existieren.");
		}
		System.out.println("");
	}

	private boolean checkHasPersonen() {
		if (personen.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

}
