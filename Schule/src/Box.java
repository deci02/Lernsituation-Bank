
public class Box {
	private double breite;
	private double hoehe;
	private double laenge;

	public Box(double b, double h, double l) {
		this.breite = b;
		this.hoehe = h;
		this.laenge = l;
	}

	public Box(Box alteBox) {
		this.breite = alteBox.getBreite();
		this.hoehe = alteBox.getHoehe();
		this.laenge = alteBox.getLaenge();
	}

	public double berechneVolumen() {
		return this.getBreite() * this.getHoehe() * this.getLaenge();
	}

	public double berechneFlaeche() {
//		return (this.breite * this.laenge + this.breite * this.hoehe + this.laenge * this.hoehe) * 2;
		double f;
		f = 2 * berechneFlaecheVorn() + 2 * berechneFlaecheOben() + 2 * berechneFlaecheSeitlich();
		return f;
	}

	private double berechneFlaecheSeitlich() {
		return this.getHoehe() * this.getLaenge();
	}

	private double berechneFlaecheOben() {
		return this.getBreite() * this.getLaenge();
	}

	private double berechneFlaecheVorn() {
		return this.getHoehe() * this.getBreite();
	}

	public Box groessereBox() {
		Box groessereBox = new Box(this.breite, this.hoehe, this.laenge);
		groessereBox.setBreite(getBreite() * 1.25);
		groessereBox.setHoehe(getHoehe() * 1.25);
		groessereBox.setLaenge(getLaenge() * 1.25);
		return groessereBox;
	}

	public Box kleinereBox() {
		Box groessereBox = new Box(this.breite, this.hoehe, this.laenge);
		groessereBox.setBreite(getBreite() * 0.75);
		groessereBox.setHoehe(getHoehe() * 0.75);
		groessereBox.setLaenge(getLaenge() * 0.75);
		return groessereBox;
	}

	public boolean passtIn(Box aeussereBox) {
		if (this.breite <= aeussereBox.getBreite() && this.hoehe <= aeussereBox.getHoehe()
				&& this.laenge <= aeussereBox.getLaenge()) {
			return true;
		} else {
			return false;
		}
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	
}
