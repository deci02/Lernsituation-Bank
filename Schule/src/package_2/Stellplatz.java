package package_2;

public class Stellplatz {

	private String nummer;
	private Artikel myArtikel;
	private double maxGewicht;

	public Stellplatz(String nr, Artikel art, double gew) {
		this.nummer = nr;
		this.myArtikel = art;
		this.maxGewicht = gew;
	}

	public String ausgeben() {
		return ("Auf Platz " + this.nummer + " stehen " + (this.myArtikel.getBestand() * this.myArtikel.getKgProStck())
				+ "kg " + this.myArtikel.getArtikelbez());
	}

	public void pruefenGewicht() {
		if ((this.myArtikel.getBestand() * this.myArtikel.getKgProStck()) > this.maxGewicht) {
			System.out.println("Die Palette mit " + this.myArtikel.getArtikelbez() + " ist überladen.");
		} else if ((this.myArtikel.getBestand() * this.myArtikel.getKgProStck()) == this.maxGewicht) {
			System.out.println("Die Palette mit " + this.myArtikel.getArtikelbez() + " ist passend voll.");
		} else {
			System.out.println("Die Palette mit " + this.myArtikel.getArtikelbez() + " ist noch nicht voll.");
		}
	}
	
	public void umlagern(Artikel art) {
		this.myArtikel = art;
	}
}
