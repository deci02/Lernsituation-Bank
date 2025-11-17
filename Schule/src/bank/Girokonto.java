package bank;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Girokonto extends Konto {

	private double dispo;

	public Girokonto(String ktoNummer, Kunde kunde, double zinsen, double sollzins, double ersteinzahlung, double dispo,
			Bank bank, LocalDateTime datum) {
		super(ktoNummer, kunde, zinsen, ersteinzahlung, bank, datum);
		this.dispo = dispo;
		super.sollzins = sollzins;
	}

	public void abheben(double betrag, LocalDateTime datum) {
		if (super.kontostand + dispo < betrag) {
			System.out.println("Kreditlimit von Konto ".concat(super.getKtoNummer())
					.concat(" überzogen. Buchung über -").concat(new DecimalFormat("#,##0.00").format(betrag))
					.concat(" Euro\nvom ").concat(datum.format(DateTimeFormatter.ofPattern("dd.MMM yyyy")))
					.concat(" wurde nicht ausgeführt.\n"));
		} else {
			super.einzahlen((betrag * -1), datum, "Auszahlung");
		}
	}

}
