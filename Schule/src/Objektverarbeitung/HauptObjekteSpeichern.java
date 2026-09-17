package Objektverarbeitung;

import java.util.Scanner;

public class HauptObjekteSpeichern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1 Vereine erfassen");
			System.out.println("2 Spielpaarungen generieren");
			System.out.println("3 Tabelle ausgeben");
			System.out.println("4 Spielergebnis erfassen");
			System.out.println("5 Ende");
			System.out.println("6 Paarungen ausgeben");

			int auswahl = scanner.nextInt();
			scanner.nextLine();

			switch (auswahl) {
			case 1:
				System.out.print("Vereinsname: ");
				VereineBearbeiten.speichern(new Verein(scanner.nextLine()));
				break;
			case 2:
				Spielpaarung.generieren();
				break;
			case 3:
				VereineBearbeiten.tabelleAusgeben();
				break;
			case 4:
				System.out.print("Verein 1: ");
				String verein1 = scanner.nextLine();
				System.out.print("Verein 2: ");
				String verein2 = scanner.nextLine();
				Spielpaarung p = Spielpaarung.suchen(verein1, verein2);
				if (p != null) {
					System.out.print("Ergebnis: ");
					p.ergebnisErfassen(scanner.nextLine());
				} else {
					System.out.println("Spielpaarung nicht gefunden.");
				}
				break;
			case 5:
				scanner.close();
				return;
			case 6:
				System.out.println(Spielpaarung.listToString());
				break;
			}
		}
	}
}
