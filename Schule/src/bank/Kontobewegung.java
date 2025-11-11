package bank;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Kontobewegung {

	protected double betrag;
	private LocalDateTime datum;
	private Konto myKonto;
	private String kommentar;

	public Kontobewegung(double betrag, LocalDateTime datum, Konto konto, String kommentar) {
		this.betrag = betrag;
		this.datum = datum;
		this.myKonto = konto;
		this.kommentar = kommentar;
	}

	public LocalDateTime getLocalDateTime() {
		return this.datum;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.GERMANY));
		return datum.format(DateTimeFormatter.ofPattern("dd.MMMyyyy")).concat("\t")
				.concat(String.valueOf(df.format(betrag))).concat("\tEuro\t").concat(kommentar);
	}

	protected int getYear() {
		return datum.getYear();
	}

	protected int getMonth() {
		return datum.getMonthValue();
	}
}
