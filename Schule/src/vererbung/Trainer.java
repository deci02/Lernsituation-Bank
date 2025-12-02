package vererbung;

public class Trainer extends Person {

	private Spieler liebster;
	private final double monatsgehalt = 165000;

	public Trainer(String vorname, String name, Spieler liebster) {
		super(vorname, name);
		this.liebster = liebster;
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
		return "Lieblingsspieler: ".concat(this.liebster.getName());
	}

}
