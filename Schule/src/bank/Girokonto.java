package bank;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Girokonto extends Konto {

	private double sollzins;
	private double dispo;

	public Girokonto(String ktoNummer, Kunde kunde, double zinsen, double sollzins, double ersteinzahlung, double dispo,
			Bank bank, LocalDateTime datum) {
		super(ktoNummer, kunde, zinsen, ersteinzahlung, bank, datum);
		this.sollzins = sollzins;
		this.dispo = dispo;
	}

	public void abheben(double betrag, LocalDateTime datum) {
		if (super.kontostand + dispo < betrag) {
			System.out.println("Kreditlimit von Konto ".concat(super.getKtoNummer())
					.concat(" überzogen. Buchung über -").concat(new DecimalFormat("#,##0.00").format(betrag))
					.concat(" Euro\nvom ").concat(datum.format(DateTimeFormatter.ofPattern("dd.MMMyyyy")))
					.concat(" wurde nicht ausgeführt.\n"));
		} else {
			super.einzahlen((betrag * -1), datum, "Auszahlung");
		}
	}

	public void berechnenZinsen(LocalDateTime datum) {
		int prev = 0;
		double curr_kont = 0;
		double zinsen = 0;
		for (int i = 1; i < super.myBew.size(); i++) {
			if (super.myBew.get(prev).getYear() != super.myBew.get(i).getYear()
					|| (super.myBew.get(i).getMonth() / 4 != super.myBew.get(prev).getMonth() / 4)) {
				for (int j = 0; j < i; j++) {
					if (curr_kont > 0) {
						zinsen = zinsen + curr_kont * this.habenzins * 0.001
								* ((super.myBew.get(i).getMonth() - super.myBew.get(prev).getMonth()) / 365);
					} else {
						zinsen = zinsen + curr_kont * this.sollzins * 0.001
								* ((super.myBew.get(i).getMonth() - super.myBew.get(prev).getMonth()) / 365);
					}
					curr_kont = curr_kont + super.myBew.get(i).betrag;
				}
				// todo: datum setzen
				super.einzahlen(zinsen, datum, "Zinsen");
				curr_kont = curr_kont + zinsen;
			}
		}
		if (datum.getYear() != super.myBew.get(super.myBew.size() - 1).getYear()
				|| datum.getMonthValue() / 4 != super.myBew.get(super.myBew.size() - 1).getMonth() / 4) {
			// todo: hier zinsrechnung einbauen, tests erfolgreich
			int index = 1;
			curr_kont = 0;
			zinsen = 0;
			for (int i = 0; i < super.myBew.size() - 1; i++) {
				curr_kont = curr_kont + super.myBew.get(i).betrag;
			}
			LocalDateTime indexdatum = LocalDateTime.of(0, 1, 1, 0, 0, 0, 0);
			while (index == 1) {
				if (super.myBew.get(super.myBew.size() - 1).getMonth() == 1
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 2
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 3) {
					indexdatum = indexdatum.plusMonths(3);
				} else if (super.myBew.get(super.myBew.size() - 1).getMonth() == 4
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 5
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 6) {
					indexdatum = indexdatum.plusMonths(6);
				} else if (super.myBew.get(super.myBew.size() - 1).getMonth() == 7
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 8
						|| super.myBew.get(super.myBew.size() - 1).getMonth() == 9) {
					indexdatum = indexdatum.plusMonths(9);
				} else {
					indexdatum = indexdatum.plusMonths(12);
				}
				indexdatum = indexdatum.plusYears(super.myBew.get(super.myBew.size() - 1).getYear());
				super.einzahlen(zinsen, indexdatum, "Zinsen");
				curr_kont = curr_kont + zinsen;
				System.out.println(indexdatum.toString());
				if (datum.getYear() == indexdatum.getYear()
						&& datum.getMonthValue() / 4 != super.myBew.get(super.myBew.size() - 1).getMonth() / 4) {
					index = 0;
				}
			}
		}
	}

}
