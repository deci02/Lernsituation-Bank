package bank;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.Month;

public class Kontobewegung {

	protected double betrag;
	private LocalDateTime datum;
	private Konto myKonto;
	protected String kommentar;
	protected double zinsbetrag;
	protected boolean quartalswechsel;
	protected boolean jahreswechsel;

	public enum QuarterStart {
		Q1(Month.JANUARY, 1), Q2(Month.APRIL, 1), Q3(Month.JULY, 1), Q4(Month.OCTOBER, 1);

		private final Month month;
		private final int day;

		QuarterStart(Month month, int day) {
			this.month = month;
			this.day = day;
		}

		public LocalDate getStartDate(int year) {
			return LocalDate.of(year, month, day);
		}

	}

	public Kontobewegung(double betrag, LocalDateTime datum, Konto konto, String kommentar) {
		this.betrag = betrag;
		this.datum = datum;
		this.myKonto = konto;
		this.kommentar = kommentar;
	}

	public LocalDate checkQuartalswechsel(Kontobewegung curr, Kontobewegung prev) {
		int yearStart = prev.getYear();
		int yearEnd = curr.getYear();

		if (yearStart != yearEnd) {
			this.jahreswechsel = true;
		}

		for (int year = yearStart; year <= yearEnd; year++) {
			for (QuarterStart q : QuarterStart.values()) {
				LocalDate qStart = q.getStartDate(year);

				if (!qStart.isBefore(prev.getLocalDateTime().toLocalDate())
						&& !qStart.isAfter(curr.getLocalDateTime().toLocalDate())) {
					this.quartalswechsel = true;
					return qStart;
				}
			}
		}
		return null;
	}

	public LocalDateTime getLocalDateTime() {
		return this.datum;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.GERMANY));
		if (Math.abs(betrag) >= 1000) {
			return datum.format(DateTimeFormatter.ofPattern("dd. MMM yyyy")).concat("\t")
					.concat(String.valueOf(df.format(betrag))).concat("\tEuro\t").concat(kommentar);
		} else {
			return datum.format(DateTimeFormatter.ofPattern("dd. MMM yyyy")).concat("\t")
					.concat(String.valueOf(df.format(betrag))).concat("\t\tEuro\t").concat(kommentar);
		}
	}

	protected int getYear() {
		return datum.getYear();
	}

	protected int getMonth() {
		return datum.getMonthValue();
	}
}
