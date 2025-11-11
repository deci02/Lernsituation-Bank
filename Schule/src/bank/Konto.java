package bank;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konto {

	private String ktoNummer;
	protected double kontostand;
	protected double habenzins;
	private Kunde myKunde;
	private Bank myBank;
	protected ArrayList<Kontobewegung> myBew;

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
		kontostand = kontostand + betrag;
		myBew.add(new Kontobewegung(betrag, datum, this, kommentar));
	}

}
