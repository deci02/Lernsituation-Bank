public class Filiale {

	public double quartal1;
	public double quartal2;
	public double quartal3;
	public double quartal4;
	private String fName;

	public Filiale(String name, double q1, double q2, double q3, double q4) {
		quartal1 = q1;
		quartal2 = q2;
		quartal3 = q3;
		quartal4 = q4;
		fName = name;
	}

	public double berechnenJahresumsatz() {
		return quartal1 + quartal2 + quartal3 + quartal4;
	}

	public String getName() {
		return this.fName;
	}

	public double ermittelnMinimum() {
		if (quartal1 < quartal2 && quartal1 < quartal3 && quartal1 < quartal4) {
			return quartal1;
		} else if (quartal2 < quartal3 && quartal2 < quartal4) {
			return quartal2;
		} else if (quartal3 < quartal4) {
			return quartal3;
		} else {
			return quartal4;
		}
	}

	public double ermittelnMaximum() {
		if (quartal1 > quartal2 && quartal1 > quartal3 && quartal1 > quartal4) {
			return quartal1;
		} else if (quartal2 > quartal3 && quartal2 > quartal4) {
			return quartal2;
		} else if (quartal3 > quartal4) {
			return quartal3;
		} else {
			return quartal4;
		}
	}

	public double berechnenDurchschnitt() {
		return (quartal1 + quartal2 + quartal3 + quartal4) / 4;
	}

	public void aendernQuartalsUmsatz(int q, double umsneu) {
		if (q == 1) {
			this.quartal1 = umsneu;
		} else if (q == 2) {
			this.quartal2 = umsneu;
		} else if (q == 3) {
			this.quartal3 = umsneu;
		} else {
			this.quartal4 = umsneu;
		}
	}

	public String toString() {
		return "Die Filiale " + getName() + " hat eienen Jahresumsatz von " + berechnenJahresumsatz()
				+ " Euro. Der höchste Quartalsumsatz war " + ermittelnMaximum()
				+ " Euro. Der niedrigste Quartalsumsatz war " + ermittelnMinimum()
				+ "Euro. Der durchschnittliche Quartalsumsatz beträgt " + berechnenDurchschnitt() + " Euro.";
	}

	public static void ermittelnRangfolge(Filiale koeln, Filiale duess, Filiale bonn) {
		String groesste;
		String kleinste;
		String mitte;
		double umsatzGroesste;
		double umsatzKleinste;
		double umsatzMitte;
		if (koeln.berechnenJahresumsatz() > duess.berechnenJahresumsatz()
				&& koeln.berechnenJahresumsatz() > bonn.berechnenJahresumsatz()) {
			groesste = "Köln";
			umsatzGroesste = koeln.berechnenJahresumsatz();
		} else if (duess.berechnenJahresumsatz() > bonn.berechnenJahresumsatz()) {
			groesste = "Düsseldorf";
			umsatzGroesste = duess.berechnenJahresumsatz();
		} else {
			groesste = "Bonn";
			umsatzGroesste = bonn.berechnenJahresumsatz();
		}
		if (koeln.berechnenJahresumsatz() < duess.berechnenJahresumsatz()
				&& koeln.berechnenJahresumsatz() < bonn.berechnenJahresumsatz()) {
			kleinste = "Köln";
			umsatzKleinste = koeln.berechnenJahresumsatz();
		} else if (duess.berechnenJahresumsatz() < bonn.berechnenJahresumsatz()) {
			kleinste = "Düsseldorf";
			umsatzKleinste = duess.berechnenJahresumsatz();
		} else {
			kleinste = "Bonn";
			umsatzKleinste = bonn.berechnenJahresumsatz();
		}
		if ((groesste.equals("Köln") && kleinste.equals("Bonn"))
				|| (groesste.equals("Bonn") && kleinste.equals("Köln"))) {
			mitte = "Düsseldorf";
			umsatzMitte = duess.berechnenJahresumsatz();
		} else if ((groesste.equals("Köln") && kleinste.equals("Düsseldorf"))
				|| (groesste.equals("Düsseldorf") && kleinste.equals("Köln"))) {
			mitte = "Bonn";
			umsatzMitte = bonn.berechnenJahresumsatz();
		} else {
			mitte = "Köln";
			umsatzMitte = koeln.berechnenJahresumsatz();
		}
		System.out.println("kleinste Filiale: " + kleinste + umsatzKleinste);
		System.out.println("mittlere Filiale: " + mitte + umsatzMitte);
		System.out.println("größte Filiale: " + groesste + umsatzGroesste);
	}
	
	

}
