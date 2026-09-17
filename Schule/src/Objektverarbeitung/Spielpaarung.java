package Objektverarbeitung;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Spielpaarung implements Serializable {
	private String verein1;
	private String verein2;
	private String ergebnis;
	private static ArrayList<Verein> liste;

	public Spielpaarung(Verein v1, Verein v2) {
		verein1 = v1.getName();
		verein2 = v2.getName();
	}

	public static void generieren() {
		try {
			File f1 = new File("spielpaarungen.txt");
			FileOutputStream fos = new FileOutputStream(f1);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			liste = VereineBearbeiten.listToString();
			for (int i = 0; i < liste.size(); i++) {
				for (int j = 0; j < liste.size(); j++) {
					if (i == j) {
						continue;
					}
					Spielpaarung p = new Spielpaarung(liste.get(i), liste.get(j));
					oos.writeObject(p);
				}
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ergebnisErfassen(String ergebnis) {

		String[] tore = ergebnis.split(":");

		int tore1 = Integer.parseInt(tore[0]);
		int tore2 = Integer.parseInt(tore[1]);

		Verein v1 = vereinLaden(verein1);
		Verein v2 = vereinLaden(verein2);

		this.ergebnis = ergebnis;

		v1.setToreGeschossen(v1.getToreGeschossen() + tore1);
		v1.setToreKassiert(v1.getToreKassiert() + tore2);

		v2.setToreGeschossen(v2.getToreGeschossen() + tore2);
		v2.setToreKassiert(v2.getToreKassiert() + tore1);

		if (tore1 > tore2) {
			v1.setPunkte(v1.getPunkte() + 3);
		} else if (tore1 < tore2) {
			v2.setPunkte(v2.getPunkte() + 3);
		} else {
			v1.setPunkte(v1.getPunkte() + 1);
			v2.setPunkte(v2.getPunkte() + 1);
		}

		VereineBearbeiten.speichern(v1);
		VereineBearbeiten.speichern(v2);
		speichern(this);
	}

	public String toString() {
		return (verein1 + ":" + verein2 + "\t" + getErgebnis());
	}

	public static String listToString() {
		String out = "";
		try {
			File f1 = new File("spielpaarungen.txt");
			FileInputStream fis = new FileInputStream(f1);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);

			Spielpaarung o;
			while (true) {
				try {
					o = (Spielpaarung) ois.readObject();
					out = (out + "\n" + o.toString());
				} catch (Exception e) {
					break;
				}
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return out;
	}

	public String getErgebnis() {
		return this.ergebnis;
	}

	public String getVerein1() {
		return verein1;
	}

	public String getVerein2() {
		return verein2;
	}

	public static Spielpaarung suchen(String name1, String name2) {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("spielpaarungen.txt")));
			while (true) {
				try {
					Spielpaarung p = (Spielpaarung) ois.readObject();
					if (p.verein1.equals(name1) && p.verein2.equals(name2)) {
						ois.close();
						return p;
					}
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void speichern(Spielpaarung geaendert) {
		try {
			ArrayList<Spielpaarung> liste = new ArrayList<>();

			// Alte Paarungen einlesen
			FileInputStream fis = new FileInputStream("spielpaarungen.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);

			while (true) {
				try {
					Spielpaarung p = (Spielpaarung) ois.readObject();
					if (p.verein1.equals(geaendert.verein1) && p.verein2.equals(geaendert.verein2)) {
						liste.add(geaendert);
					} else {
						liste.add(p);
					}
				} catch (Exception e) {
					break;
				}
			}
			ois.close();
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("spielpaarungen.txt")));
			for (Spielpaarung p : liste) {
				oos.writeObject(p);
			}

			oos.close();

		} catch (Exception e) {
		}
	}

	private Verein vereinLaden(String name) {

		try {
			ArrayList<Verein> vereine = VereineBearbeiten.listToString();

			for (Verein v : vereine) {
				if (v.getName().equals(name)) {
					return v;
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
