
public class Artikel {
	public String artikelbezeichnung;
	public int bestand;
	public double nettopreis;
	public double kgProStck;
	public int steuersatz;

	public Artikel(String bezeich, int best, double pr, double kg, int steuer) {
		this.artikelbezeichnung = bezeich;
		this.bestand = best;
		this.nettopreis = pr;
		this.kgProStck = kg;
		this.steuersatz = steuer;
	}

	public void veraendernBestand(int liefermenge) {
		this.bestand = this.bestand + liefermenge;
		this.ausgebenInformationen(liefermenge);
	}

	public void ausgebenInformationen(int liefermenge) {
		System.out.println("Die Lieferung des Artikels " + this.artikelbezeichnung + " hat eine Menge von " + liefermenge + " Stück");
		System.out.println("Mit einem Stückpreis von " + this.holenBruttopreis() + "€ und einem Gesamtwert von " + this.berechnenPreisPosition(liefermenge) + "€.");
	}

	public double holenBruttopreis() {
		return this.nettopreis * (1 + (double)this.steuersatz/100);
	}

	public double berechnenPreisPosition(int liefermenge) {
		return this.holenBruttopreis() * liefermenge;
	}
}