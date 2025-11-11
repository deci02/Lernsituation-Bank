package bank;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {

	private String blz;
	private String institsutname;
	private ArrayList<Kunde> myKunden;
	private ArrayList<Konto> myKonten;

	public Bank(String blz, String inst) {
		myKunden = new ArrayList<Kunde>();
		myKonten = new ArrayList<Konto>();
		this.blz = blz;
		this.institsutname = inst;
	}

	public void ausgebenKunden() {
		for (int i = 0; i < myKunden.size(); i++) {
			System.out.println(myKunden.get(i).toString());
		}
	}

	public void ausgebenKonten() {
		String ausgabe = "";
		ArrayList<Kontobewegung> bew = new ArrayList<Kontobewegung>();
		for (int i = 0; i < myKonten.size(); i++) {
			ausgabe = ausgabe.concat("\nKontoauszug".concat("\n\tKto-Nr.: ").concat(myKonten.get(i).getKtoNummer())
					.concat("\n\tBLZ: ").concat(this.blz).concat(", ").concat(this.institsutname)
					.concat("\n\tKontostand: ").concat(new DecimalFormat("#,##0.00").format(myKonten.get(i).kontostand))
					.concat(" Euro\n\n"));
			bew = myKonten.get(i).getKontobewegungen();
			for (int j = 0; j < bew.size(); j++) {
				ausgabe = ausgabe.concat(String.valueOf(j + 1)).concat("\t")
						.concat(myKonten.get(i).myBew.get(j).toString()).concat("\n");
			}
		}
		System.out.println(ausgabe);

	}

	public void addKunde(Kunde kunde) {
		myKunden.add(kunde);
	}

	public void addKonto(Konto konto) {
		myKonten.add(konto);
	}

	public String getBLZ() {
		return this.blz;
	}

	public String getInstitut() {
		return this.institsutname;
	}
}
