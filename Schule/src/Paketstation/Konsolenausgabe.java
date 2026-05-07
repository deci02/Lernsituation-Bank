package Paketstation;

import java.util.Scanner;

public class Konsolenausgabe {
	public Paketstation myPaketstation;
	private static boolean aktiv;

	public static void main(String[] args) {
		Konsolenausgabe ausgabe = new Konsolenausgabe(new Paketstation(2));
		aktiv = true;
		while (aktiv == true) {
			ausgabe.ausgebenMenue();
		}
	}

	public Konsolenausgabe(Paketstation stat) {
		myPaketstation = stat;
	}

	public int ausgebenMenue() {
		System.out.println("\nPaketstation Menü \r\n" + "(1) Paket einlagern \r\n" + "(2) Paket entnehmen \r\n"
				+ "(3) Pakete listen \r\n" + "(4) beenden \r\n" + "Bitte Eingabe tätigen: ");
		Scanner scanner = new Scanner(System.in);
		switch (Integer.parseInt(scanner.nextLine())) {
		case 1:
			System.out.println("Bitte Empfänger eingeben: ");
			String empfaenger = scanner.nextLine();
			System.out.println(myPaketstation.einlagern(new Paket(empfaenger)));
			break;
		case 2:
			System.out.println("Bitte Empfänger oder Nummer eingeben: ");
			String eingabe = scanner.nextLine();
			try {
				int fach = Integer.parseInt(eingabe);
				System.out.println(myPaketstation.entnehmen(fach));
			} catch (NumberFormatException e) {
				empfaenger = eingabe;
				System.out.println(myPaketstation.entnehmen(empfaenger));
			}
			break;
		case 3:
			System.out.println(myPaketstation.listenPakete());
			break;
		case 4:
			aktiv = false;
			break;
		}
		return 0;
	}

	public void verarbeitenEingabe() {
	}

	public String verfassenEinlagerung() {
		return "Paket wurde eingelagert.";

	}

	public String erfassenLeerung() {
		return "";
	}
}
