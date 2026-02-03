package datum;

import java.time.format.TextStyle;
import java.util.Locale;

public class EnglishDatumFormat extends DatumFormat {

	public EnglishDatumFormat(int day, int month, int year) {
		super(day, month, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void druckeKurz() {
		System.out.println(new Integer(datum.getYear()).toString().substring(2) + "-" + datum.getMonthValue() + "-"
				+ datum.getDayOfMonth());
	}

	@Override
	public void druckeNormal() {
		System.out.println(datum.getYear() + "-" + datum.getMonthValue() + "-" + datum.getDayOfMonth());
	}

	@Override
	public void druckeErweitert() {
		System.out.println(datum.getYear() + "-" + datum.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + "-"
				+ datum.getDayOfMonth());
	}

}
