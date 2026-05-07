package Paketstation;

import java.util.ArrayList;

public class Paketstation {

	private ArrayList<Fach> myFaecher;
	private int groesse;

	public Paketstation(int groesse) {
		this.myFaecher = new ArrayList<Fach>();
		this.groesse = groesse;
	}

	public String einlagern(Paket p) {
		for (int i = 0; i < groesse; i++) {
			try {
				if (myFaecher.get(i).isFrei()) {
					try {
						myFaecher.get(i).einlagern(p);
						return "Paket in Fach " + (i + 1) + " eingelagert.";
					} catch (Exception e) {
						Paket.decreaseSeNr();
						continue;
					}
				}
			} catch (IndexOutOfBoundsException e) {
				Fach f = new Fach();
				try {
					f.einlagern(p);
				} catch (Exception e1) {
					Paket.decreaseSeNr();
					e1.printStackTrace();
				}
				myFaecher.add(f);
				return "Paket in Fach " + (i + 1) + " eingelagert";
			}
		}
		Paket.decreaseSeNr();
		return "Packstation ist voll";
	}

	public String entnehmen(int nr) {
		try {
			myFaecher.get(nr - 1).entnehmen();
			return "Fach " + nr + " geleert.";
		} catch (ArrayIndexOutOfBoundsException e) {
			return "Fach existiert nicht.";
		} catch (Exception e) {
			return "Fach ist nicht leer.";
		}
	}

	public String entnehmen(String empfaenger) {
		ArrayList faecher = new ArrayList();
		for (int i = 0; i < myFaecher.size(); i++) {
			Fach f = myFaecher.get(i);
			if (f.getMyInhalt().getEmpfaenger().equals(empfaenger)) {
				try {
					f.entnehmen();
					faecher.add(i);
				} catch (Exception e) {
					return "Fehler, Fach ist leer: " + (f.getMyInhalt().getNr() + 1);
				}
			}
		}
		if (faecher.size() == 0) {
			return "keine Fächer gefunden";
		} else if (faecher.size() == 1) {
			return "Fach " + (Integer.parseInt(faecher.get(0).toString()) + 1) + " geleert.";
		} else {
			return ("Fächer " + faecher.toString() + " geleert.");
		}
	}

	public String listenPakete() {
		String s = "Fach \t Empfänger \t Sendungsnummer \n";
		for (int i = 0; i < myFaecher.size(); i++) {
			Paket inhalt = myFaecher.get(i).getMyInhalt();
			if (inhalt == null) {
				s = s.concat((i + 1) + "\tleer\t-\n");
			} else {
				s = s.concat((i + 1) + "\t" + inhalt.getEmpfaenger() + "\t" + inhalt.getNr() + "\n");
			}
		}
		return s;
	}

}
