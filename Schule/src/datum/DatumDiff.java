package datum;

import java.time.LocalDate;

public final class DatumDiff {

	public static int diff(LocalDate datum1, LocalDate datum2) {
		return (datum2.getYear() - datum1.getYear()) * 365 + (datum2.getMonthValue() - datum1.getMonthValue()) * 31
				+ (datum2.getDayOfMonth() - datum1.getDayOfMonth());
	}

}
