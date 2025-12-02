package vererbung;

public abstract class Person {

	private String vorname;
	private String name;
	protected double gehalt;

	public Person(String vorname, String name) {
		this.vorname = vorname;
		this.name = name;
		this.setGehalt(this.ermittelnGehalt());
	}

	public void setGehalt(double gehalt) {
		this.gehalt = this.ermittelnGehalt();
	}

	public String erzeugenZeile() {
		return getTyp().concat("\t").concat(getName()).concat("\t").concat(vorname).concat("\t")
				.concat(String.valueOf(this.gehalt).concat("\t").concat(erzeugenDetail()));
	}

	public String getName() {
		return this.name;
	}

	public abstract String getTyp();

	public abstract double ermittelnGehalt();

	public abstract String erzeugenDetail();

}
