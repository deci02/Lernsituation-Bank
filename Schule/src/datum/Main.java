package datum;

public class Main {

	public static void main(String[] args) {
		DatumFormat d[] = new DatumFormat[10];
		d[0] = new GermanDatumFormat(12, 10, 2025);
		d[1] = new GermanDatumFormat(13, 11, 2025);
		d[2] = new GermanDatumFormat(14, 12, 2025);
		d[3] = new GermanDatumFormat(5, 9, 2025);
		d[4] = new GermanDatumFormat(16, 5, 2025);
		d[5] = new EnglishDatumFormat(5, 11, 2025);
		d[6] = new EnglishDatumFormat(24, 4, 2025);
		d[7] = new EnglishDatumFormat(23, 8, 2025);
		d[8] = new EnglishDatumFormat(22, 12, 2025);
		d[9] = new EnglishDatumFormat(21, 10, 2025);

		for (int i = 0; i < d.length; i++) {
			d[i].druckeKurz();
			d[i].druckeNormal();
			d[i].druckeErweitert();
		}

		System.out.println(DatumDiff.diff(d[0].get(), d[5].get()));
	}

}
