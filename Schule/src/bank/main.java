package bank;

import java.time.LocalDateTime;
import java.time.Month;

public class main {

	public static void main(String[] args) {
		Bank sparkassemuenster = new Bank("500 401 50", "Sparkasse Münster");

		Kunde paul = new Kunde("Paul Müller", "Münster", LocalDateTime.of(2023, Month.FEBRUARY, 10, 0, 0));
		Girokonto paulgiro1 = new Girokonto("50060080", paul, 1.5, 7.5, 1, 3000, sparkassemuenster,
				LocalDateTime.of(2025, Month.FEBRUARY, 10, 0, 0));

		Kunde lieschen = new Kunde("Lieschen Fleisig", "Osnabrück", LocalDateTime.of(2020, Month.MAY, 2, 0, 0));
		Girokonto lieschengiro1 = new Girokonto("50060090", lieschen, 1.5, 7.5, 1, 2000, sparkassemuenster,
				LocalDateTime.of(2025, Month.JANUARY, 2, 0, 0));
		Sparkonto lieschenspar1 = new Sparkonto("22222222", lieschen, 5, 1, sparkassemuenster,
				LocalDateTime.of(2025, Month.JANUARY, 2, 0, 0));

		sparkassemuenster.addKonto(paulgiro1);
		sparkassemuenster.addKunde(paul);
		sparkassemuenster.addKunde(lieschen);
		sparkassemuenster.addKonto(lieschengiro1);
		sparkassemuenster.addKonto(lieschenspar1);

		paul.addKonto(paulgiro1);
		lieschen.addKonto(lieschenspar1);
		lieschen.addKonto(lieschengiro1);

		paulgiro1.abheben(8500, LocalDateTime.of(2025, Month.FEBRUARY, 11, 0, 0));
		lieschengiro1.abheben(50, LocalDateTime.of(2025, Month.FEBRUARY, 11, 0, 0));
		lieschengiro1.abheben(100.5, LocalDateTime.of(2025, Month.FEBRUARY, 11, 0, 0));
		lieschenspar1.einzahlen(2850, LocalDateTime.of(2025, Month.FEBRUARY, 11, 0, 0), "Einzahlung ");

		LocalDateTime heute = LocalDateTime.now();

		paulgiro1.berechnenZinsen(heute);
		lieschengiro1.berechnenZinsen(heute);
		lieschenspar1.berechnenZinsen();

		sparkassemuenster.ausgebenKunden();
		sparkassemuenster.ausgebenKonten();
	}

}
