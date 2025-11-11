// Klasse Person mit Parametern "name" und "alter" als Strings (Zeichenketten) und ints (Ganzzahlen)
public class Person {
	private String name;
	private int alter;
	private char geschlecht;
	private double groesse;
	private String Anrede;
	private String Pronomen;
	private double gewicht;
	private double bmi;
	public int familiengroesse;

	// Konstruktor
	public Person(String meinName, int meinAlter, char meinGeschlecht, double meineGroesse, double meinGewicht,
			int partner, int kinder) {
		this.setName(meinName);
		this.alter = meinAlter;
		this.geschlecht = meinGeschlecht;
		this.setGroesse(meineGroesse);
		this.setGewicht(meinGewicht);
		this.bmi = errechnenBmi();
		this.familiengroesse = ermittelnFamiliengroesse(partner, kinder);
		this.getAnrede();
		this.getPronomen();
	}
	
	public Person(String meinName, int meinAlter, double meineGroesse) {
		this.setName(meinName);
		this.alter = meinAlter;
		this.setGroesse(meineGroesse);
	}

	public void setName(String meinName) {
		this.name = meinName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setGewicht(double meinGewicht) {
		this.gewicht = meinGewicht;
	}
	
	public double getGewicht() {
		return this.gewicht;
	}
	
	public void setGroesse(double meineGroesse) {
		this.groesse = meineGroesse;
	}
	
	public double getGroesse() {
		return this.groesse;
	}
	
	public void sprechen(String laengeDerRede) {
		if (laengeDerRede.equals("kurz")) {
			System.out.println("Guten Tag! Mein Name ist " + this.name + ". Mein Alter beträgt " + this.alter
					+ " Jahre und meine \nGröße in Metern ist " + this.groesse + ".");
		} else if (laengeDerRede.equals("lang")) {
			System.out.println("Ich heiße " + this.name + " und bin " + this.alter + " Jahre alt und " + this.groesse + "m groß.");
		}
	}
	
	public void getAnrede() {
		if (this.geschlecht == 'w') {
			this.Anrede = "Frau";
		} else if (this.geschlecht == 'm') {
			this.Anrede = "Herr ";
		}
	}

	public void getPronomen() {
		if (this.geschlecht == 'w') {
			this.Pronomen = "Sie";
		} else if (this.geschlecht == 'm') {
			this.Pronomen = "Er";
		}
	}

	public void abnehmen(double gewichtsabnahme) {
		System.out.println(this.name + " hat " + this.gewicht + " Kilogramm gewogen.");
		this.gewicht = this.gewicht - gewichtsabnahme;
		System.out.println(this.Pronomen + " hat " + gewichtsabnahme + " Kilogramm abgenommen.");
		System.out.println(this.Pronomen + " wiegt jetzt " + this.gewicht);
	}

	public void zunehmen(double gewichtszunahme) {
		System.out.println(this.name + " hat " + this.gewicht + " Kilogramm gewogen.");
		this.gewicht = this.gewicht - gewichtszunahme;
		System.out.println(this.Pronomen + " hat " + gewichtszunahme + " Kilogramm zugenommen.");
		System.out.println(this.Pronomen + " wiegt jetzt " + this.gewicht);
	}

	public double errechnenBmi() {
		double bodyIndex = this.gewicht / (this.groesse * this.groesse);
		return bodyIndex;
	}

	public int ermittelnJahreBisRunderGeburtstag() {
		int Jahre = 0;
		Jahre = 10 - (this.alter % 10);
		return Jahre;
	}

	public int ausgebenInformationRunderGeburtstag() {
		return ermittelnJahreBisRunderGeburtstag() + 2024;
	}

	// Methode wie in ABAP
	public void sprechen() {
		System.out.println(this.Anrede + this.name + " ist " + alter + " Jahre alt. " + this.Pronomen + " ist "
				+ this.groesse + "m groß.");
	}

	public double dividieren(double a, double b) {
		double c;
		c = a / b;
		return c;
	}

	public int ermittelnFamiliengroesse(int partner, int kinder) {
		return partner + kinder;
	}

}