package Paketstation;

public class Fach {

	private Paket myInhalt;

	public Fach() {
	}

	public boolean isFrei() {
		return (getMyInhalt() == null);
	}

	public void einlagern(Paket p) throws Exception {
		if (isFrei()) {
			this.myInhalt = p;
		} else {
			throw new Exception("Fach ist nicht leer.");
		}
	}

	public Paket getMyInhalt() {
		return myInhalt;
	}

	public void entnehmen() throws Exception {
		if (!isFrei()) {
			this.myInhalt = null;
		} else {
			throw new Exception("Fach ist leer.");
		}
	}

}
