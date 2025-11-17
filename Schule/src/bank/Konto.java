package bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import bank.Kontobewegung.QuarterStart;

public class Konto {

	private String ktoNummer;
	protected double kontostand;
	protected double habenzins;
	private Kunde myKunde;
	private Bank myBank;
	protected ArrayList<Kontobewegung> myBew;
	protected double sollzins;

	public Konto(String ktoNummer, Kunde kunde, double zinsen, double ersteinzahlung, Bank bank, LocalDateTime datum) {
		myBew = new ArrayList<Kontobewegung>();
		this.ktoNummer = ktoNummer;
		this.myKunde = kunde;
		this.habenzins = zinsen;
		this.kontostand = ersteinzahlung;
		this.myBank = bank;
		myBew.add(new Kontobewegung(ersteinzahlung, datum, this, "Ersteinzahlung"));
	}

	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < myBew.size(); i++) {
			ausgabe.concat(String.valueOf(i)).concat(myBew.get(i).toString()).concat("\n");
		}
		return ausgabe;
	}

	public String getKtoNummer() {
		return ktoNummer;
	}

	public Bank getMyBank() {
		return myBank;
	}

	public Kunde getMyKunde() {
		return myKunde;
	}

	public ArrayList<Kontobewegung> getKontobewegungen() {
		return this.myBew;
	}

	protected void einzahlen(double betrag, LocalDateTime datum, String kommentar) {
		Kontobewegung prev = myBew.getLast();
		Kontobewegung curr = new Kontobewegung(betrag, datum, this, kommentar);
		calcZins(curr, prev);
		kontostand = kontostand + betrag;
		myBew.add(curr);
	}

	private void calcZins(Kontobewegung curr, Kontobewegung prev) {
		if (this.kontostand > 0) {
			curr.zinsbetrag = this.kontostand * this.habenzins / 100 * ChronoUnit.DAYS
					.between(prev.getLocalDateTime().toLocalDate(), curr.getLocalDateTime().toLocalDate()) / 365;
		} else {
			curr.zinsbetrag = prev.betrag * (this.sollzins / 100) * ChronoUnit.DAYS
					.between(prev.getLocalDateTime().toLocalDate(), curr.getLocalDateTime().toLocalDate());
		}
		LocalDate q = curr.checkQuartalswechsel(curr, prev);
		if (q != null) {
			LocalDateTime datum = LocalDateTime.of(q, LocalTime.of(0, 0));
			myBew.add(new Kontobewegung(curr.zinsbetrag, datum, this, "Zinsen"));
		}
	}

}
