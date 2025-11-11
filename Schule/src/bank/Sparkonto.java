package bank;

import java.time.LocalDateTime;

public class Sparkonto extends Konto {

	public Sparkonto(String ktoNummer, Kunde kunde, double zinsen, double ersteinzahlung, Bank bank,
			LocalDateTime datum) {
		super(ktoNummer, kunde, zinsen, ersteinzahlung, bank, datum);
	}

	private void abheben(double betrag) {
		if (super.kontostand < betrag) {
			System.out.println("Kontostand zu niedrig");
		} else {
			super.kontostand = super.kontostand - betrag;
		}
	}

	public void berechnenZinsen() {
		int prev = 0;
		for (int i = 1; i < super.myBew.size(); i++) {
			if (super.myBew.get(prev).getYear() != super.myBew.get(i).getYear()) {
				super.einzahlen(super.kontostand * super.habenzins,
						LocalDateTime.of(myBew.get(i).getYear(), 1, 1, 0, 0), "Zinsen");
			}
		}
	}

}
