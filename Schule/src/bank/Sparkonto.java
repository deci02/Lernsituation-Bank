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

}
