package vererbung;

public class Spieler extends Person {

	private String position;
	private int einsaetze;
	private final double monatsgehalt = 180000;
	private final double spielpraemie = 5000;

	public Spieler(String vorname, String name, String position, int einsaetze) {
		super(vorname, name);
		this.position = position;
		this.einsaetze = einsaetze;
	}

	@Override
	public String getTyp() {
		return "S";
	}

	@Override
	public double ermittelnGehalt() {
		return (this.monatsgehalt * 12 + this.spielpraemie * this.einsaetze);
	}

	@Override
	public String erzeugenDetail() {
		return "Position: ".concat(position).concat(" / Spieleinsätze: ").concat(String.valueOf(this.einsaetze));
	}

}
