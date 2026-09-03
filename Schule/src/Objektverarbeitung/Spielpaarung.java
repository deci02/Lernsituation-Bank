package Objektverarbeitung;

public class Spielpaarung{
	private Verein verein1;
	private Verein verein2;
	private boolean gespielt;
	private String ergebnis;

	public Spielpaarung(Verein v1, Verein v2){
		verein1 = v1;
		verein2 = v2;
	}

	public void ergebnisErfassen(String ergebnis){
		this.ergebnis = ergebnis;
		this.gespielt = true;
	}
}
