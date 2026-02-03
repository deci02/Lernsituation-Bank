package datum;

import java.time.format.TextStyle;
import java.util.Locale;

public class GermanDatumFormat extends DatumFormat {

	public GermanDatumFormat(int day, int month, int year) {
		super(day, month, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void druckeKurz() {
		System.out.println(datum.getDayOfMonth() + "." + datum.getMonthValue() + "."
				+ new Integer(datum.getYear()).toString().substring(2));
	}

	@Override
	public void druckeNormal() {
		System.out.println(datum.getDayOfMonth() + "." + datum.getMonthValue() + "." + datum.getYear());
	}

	@Override
	public void druckeErweitert() {
		System.out.println(datum.getDayOfMonth() + ". " + datum.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN)
				+ " " + datum.getYear());
	}

}
