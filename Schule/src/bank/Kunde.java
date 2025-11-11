package bank;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Kunde {

	private String kundenNummer;
	private String name;
	private String adresse;
	private LocalDateTime kundeSeit;
	private ArrayList<Konto> myKonten;

	public Kunde(String name, String adresse, LocalDateTime seit) {
		myKonten = new ArrayList<Konto>();
		this.name = name;
		this.adresse = adresse;
		this.kundeSeit = seit;
	}

	public void addKonto(Konto konto) {
		myKonten.add(konto);
	}

	public int getKontoCount() {
		return myKonten.size();
	}

	public Konto getKontoI(int i) {
		return myKonten.get(i);
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		String ausgabe = "";
		ausgabe = "Kontoinhaber: ".concat(this.name);
		for (int i = 0; i < myKonten.size(); i++) {
			ausgabe = ausgabe.concat("\n\t").concat("Kto-Nr.: ").concat(myKonten.get(i).getKtoNummer()).concat(",")
					.concat("\n\tBLZ: ").concat(myKonten.get(i).getMyBank().getBLZ()).concat(", ")
					.concat(myKonten.get(i).getMyBank().getInstitut()).concat("\n\tKontostand: ")
					.concat(new DecimalFormat("#,##0.00").format(myKonten.get(i).kontostand)).concat(" Euro\n");
		}
		return ausgabe;
	}

}
