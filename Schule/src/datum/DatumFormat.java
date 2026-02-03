package datum;

public abstract class DatumFormat extends Datum {
	public DatumFormat(int day, int month, int year) {
		super(day, month, year);
	}

	public abstract void druckeKurz();

	public abstract void druckeNormal();

	public abstract void druckeErweitert();
}
