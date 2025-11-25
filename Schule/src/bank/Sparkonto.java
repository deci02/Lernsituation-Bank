package bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sparkonto extends Konto {

	public Sparkonto(String ktoNummer, Kunde kunde, double zinsen, double ersteinzahlung, Bank bank,
			LocalDateTime datum) {
		super(ktoNummer, kunde, zinsen, ersteinzahlung, bank, datum);
	}

	private void abheben(double betrag) { // todo
		if (super.kontostand < betrag) {
			System.out.println("Kontostand zu niedrig");
		} else {
			super.kontostand = super.kontostand - betrag;
		}
	}

	public Kontobewegung einzahlen(double betrag, LocalDateTime datum, String kommentar) {
		Kontobewegung curr = super.einzahlen(betrag, datum, kommentar);
		if (curr.getYear() != myBew.getLast().getYear()) {
			this.jahresabschluss(
					LocalDateTime.of(Kontobewegung.QuarterStart.Q1.getStartDate(curr.getYear()), LocalTime.of(0, 0)));
			myBew.add(new Kontobewegung(this.calcZinssumme(),
					LocalDateTime.of(Kontobewegung.QuarterStart.Q1.getStartDate(curr.getYear()), LocalTime.of(0, 0)),
					this, "Zinsen"));
		}
		return curr;
	}

	protected double calcZinssumme() {
		double zinssumme = 0;
		for (int i = myBew.size() - 1; i >= 0; i--) {
			zinssumme = zinssumme + myBew.get(i).zinsbetrag;
			if (myBew.get(i).jahreswechsel == true) {
				break;
			}
		}
		return zinssumme;
	}

	protected void jahresabschluss(LocalDateTime datum) {
		super.einzahlen(0, datum, "Zinsen");
		this.myBew.getLast().betrag = this.calcZinssumme();
		this.myBew.getLast().jahreswechsel = true;
		this.kontostand = this.kontostand + this.myBew.getLast().betrag;
	}

}
