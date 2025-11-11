package package_2;

//import java.math.RoundingMode;

public class Artikel {
	private String artikelbez;
	private int bestand;
	private double nettopreis;
	private double kgProStck;
	final private double STEUERSATZ = 7;

	public Artikel(String bezeich, int best, double pr, double kg) {
		this.artikelbez = bezeich;
		this.bestand = best;
		this.nettopreis = pr;
		this.kgProStck = kg;
	}

	public void veraendernBestand(int menge) {
		this.bestand =+ menge;
//		System.out.println("Liefermenge " + this.getArtikelbez() + ": " + menge);
		System.out.println(ausgebenInformationen(menge));
	}

	public String ausgebenInformationen(int liefermenge) {
		return "Die Lieferung des Artikels " + this.getArtikelbez() + " hat eine Menge von " + liefermenge
				+ " Stück. Mit einem Stückpreis von " + this.holenBruttopreis() + "€ und einem Gesamtwert von "
				+ this.berechnenPreisLieferung(liefermenge) + "€.";
	}

	public double holenBruttopreis() {
		return Math.round(this.nettopreis * (1 + this.STEUERSATZ / 100));
	}

	public double berechnenPreisLieferung(int liefermenge) {
		return this.holenBruttopreis() * liefermenge;
	}

	public double getKgProStck() {
		return kgProStck;
	}

	public int getBestand() {
		return bestand;
	}

	public String getArtikelbez() {
		return artikelbez;
	}
}