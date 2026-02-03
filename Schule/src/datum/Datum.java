package datum;

import java.time.LocalDate;

public class Datum {
	public LocalDate datum;

	public Datum(int day, int month, int year) {
		datum = LocalDate.of(year, month, day);
	}
	
	public void set(LocalDate datum) {
		this.datum = datum;
	}

	public LocalDate get() {
		return datum;
	}
}
