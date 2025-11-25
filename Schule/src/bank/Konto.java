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

	protected Kontobewegung einzahlen(double betrag, LocalDateTime datum, String kommentar) {
		Kontobewegung prev = myBew.getLast();
		Kontobewegung curr = new Kontobewegung(betrag, datum, this, kommentar);
		prev.zinsbetrag = calcZinsbetrag(curr, prev);
		kontostand = kontostand + betrag;
		myBew.add(curr);
		return curr;
	}

	protected double calcZinsbetrag(Kontobewegung curr, Kontobewegung prev) {
		double zinsbetrag = 0;
		if (this.kontostand > 0) {
			zinsbetrag = this.kontostand * this.habenzins / 100 * ChronoUnit.DAYS
					.between(prev.getLocalDateTime().toLocalDate(), curr.getLocalDateTime().toLocalDate()) / 365;
		} else {
			zinsbetrag = this.kontostand * (this.sollzins / 100) * ChronoUnit.DAYS
					.between(prev.getLocalDateTime().toLocalDate(), curr.getLocalDateTime().toLocalDate()) / 365;
		}
		return zinsbetrag;
	}

}
