package Kardinalitaeten;

public class Person {
	public boolean valid;
	private String name;
	private Hobby[] hobbies;

	public Person(String name, Hobby hobby) {
		this.name = name;
		this.hobbies = new Hobby[1];
		this.hobbies[0] = hobby;
		this.valid = true;
		if (hobby.getBezeichnung() != "dummy") {
			hobby.hinzufuegenPerson(this);
		}
	}
	
	public void loeschenDummy() {
		Hobby[] hobbiesCopy = new Hobby[hobbies.length - 1];
		hobbiesCopy[0] = hobbies[1];
		this.hobbies = hobbiesCopy;
	}

	public void hinzufuegenHobby(Hobby h) {
		if (this.valid) {
		Hobby[] hobbiesCopy = new Hobby[hobbies.length + 1];
		for (int i = 0; i < hobbies.length; i++) {
			hobbiesCopy[i] = hobbies[i];
		}
		hobbiesCopy[hobbiesCopy.length - 1] = h;
		this.hobbies = hobbiesCopy;
		} else {
			System.out.println(this.name + " darf nicht mehr existieren");
		}
	}

	public void loeschenHobby(Hobby h) {
		Hobby[] hobbiesCopy = new Hobby[hobbies.length - 1];
		boolean indexGefunden = false;
		for (int i = 0; i < hobbies.length; i++) {
			if (this.hobbies[i].equals(h)) {
				indexGefunden = true;
			} else {
				if (indexGefunden) {
					hobbiesCopy[i - 1] = this.hobbies[i];
				} else {
					hobbiesCopy[i] = this.hobbies[i];
				}
			}
		}
		h.loeschenPersonInternal(this);
		this.hobbies = hobbiesCopy;
		this.valid = checkHasHobbies();
	}

	public void loeschenHobbyInternal(Hobby h) {
		Hobby[] hobbiesCopy = new Hobby[hobbies.length - 1];
		boolean indexGefunden = false;
		for (int i = 0; i < hobbies.length; i++) {
			if (this.hobbies[i].equals(h)) {
				indexGefunden = true;
			} else {
				if (indexGefunden) {
					hobbiesCopy[i - 1] = this.hobbies[i];
				} else {
					hobbiesCopy[i] = this.hobbies[i];
				}
			}
		}
		this.hobbies = hobbiesCopy;
		this.valid = checkHasHobbies();
	}
	
	public void ausgebenHobbies() {
		if (this.valid) {
			for (int i = 0; i < this.hobbies.length; i++) {
				System.out.println(this.name + ": " + this.hobbies[i].getBezeichnung());
			}
		} else {
			System.out.println(this.name + " durfte zu einem früheren Zeitpunkt schon nicht mehr existieren.");
		}
		System.out.println("");
	}

	private boolean checkHasHobbies() {
		if (hobbies.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String getName() {
		return name;
	}
}
