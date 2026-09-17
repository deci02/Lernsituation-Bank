package Objektverarbeitung;

import java.io.*;
import java.util.ArrayList;

public class VereineBearbeiten {
	private static final String file = "vereine.txt";
	private static ObjectOutputStream oos;

	public static void clear() {
		try {
			VereineBearbeiten.oos = getInstanceOos();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void speichern(Verein verein) {
		try {
			ArrayList<Verein> liste = new ArrayList<>();
			File f = new File(file);

			if (f.exists()) {
				ObjectInputStream ois = initOis();
				while (true) {
					try {
						Verein v = (Verein) ois.readObject();
						if (v.getName().equals(verein.getName())) {
							liste.add(verein);
						} else {
							liste.add(v);
						}
					} catch (EOFException e) {
						break;
					}
				}
				ois.close();
			}

			boolean exists = false;

			for (Verein v : liste) {
				if (v.getName().equals(verein.getName())) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				liste.add(verein);
			}

			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			for (Verein v : liste) {
				oos.writeObject(v);
			}
			oos.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Verein> listToString() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = initOis();
		Verein o = null;
		ArrayList<Verein> a = new ArrayList<Verein>();
		while (true) {
			try {
				o = (Verein) ois.readObject();
				a.add(o);
			} catch (EOFException e) {
				break;
			}
		}
		ois.close();
		return a;
	}

	private static ObjectInputStream initOis() throws FileNotFoundException, IOException {
		File f1 = new File(file);
		FileInputStream fis = new FileInputStream(f1);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois;
	}

	public static void ausgeben() {
		try {
			System.out.println(listToString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ObjectOutputStream getInstanceOos() throws FileNotFoundException, IOException {
		if (oos == null) {
			return new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		}
		return oos;
	}

	public static void tabelleAusgeben() {
		try {
			ArrayList<Verein> liste = listToString();

			liste.sort((v1, v2) -> {
				if (v1.getPunkte() != v2.getPunkte()) {
					return Integer.compare(v2.getPunkte(), v1.getPunkte());
				}

				int differenz1 = v1.getToreGeschossen() - v1.getToreKassiert();
				int differenz2 = v2.getToreGeschossen() - v2.getToreKassiert();

				return Integer.compare(differenz2, differenz1);
			});

			System.out.println("Verein\t\tPunkte\tTore");

			for (Verein v : liste) {
				System.out.println(v.getName() + "\t\t" + v.getPunkte() + "\t" + v.getToreGeschossen() + ":"
						+ v.getToreKassiert());
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}