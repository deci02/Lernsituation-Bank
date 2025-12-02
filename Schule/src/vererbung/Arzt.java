package vererbung;

public class Arzt extends Person {

	private String fach;
	private final double monatsgehalt = 10000;

	public Arzt(String vorname, String name, String fach) {
		super(vorname, name);
		this.fach = fach;
	}

	@Override
	public String getTyp() {
		return "T";
	}

	@Override
	public double ermittelnGehalt() {
		return this.monatsgehalt * 12;
	}

	@Override
	public String erzeugenDetail() {
		return "Fachrichtung: ".concat(this.fach);
	}

}
