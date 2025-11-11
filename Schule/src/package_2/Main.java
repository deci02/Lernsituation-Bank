package package_2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Artikel salami = new Artikel("Ungarische Salami", 250, 9.9, 1.0);
		Artikel schinken = new Artikel("Prager Schinken", 100, 8.5, 2.0);
		Artikel steak = new Artikel("Argentinisches Steak", 600, 15.0, 0.25);

		Stellplatz Platz1 = new Stellplatz("P101", salami, 200);
		Stellplatz Platz2 = new Stellplatz("P102", schinken, 240);
		Stellplatz Platz3 = new Stellplatz("P103", steak, 250);

		System.out.println("Liefermenge Salami: ");
		Scanner sc1 = new Scanner(System.in);
		int menge1 = sc1.nextInt();
		salami.veraendernBestand(menge1);

		System.out.println("Liefermenge Schinken: ");
		Scanner sc2 = new Scanner(System.in);
		int menge2 = sc2.nextInt();
		schinken.veraendernBestand(menge2);

		System.out.println("Liefermenge Salami: ");
		Scanner sc3 = new Scanner(System.in);
		int menge3 = sc3.nextInt();
		steak.veraendernBestand(menge3);
		sc1.close();
		sc2.close();
		sc3.close();

		Platz1.pruefenGewicht();
		Platz2.pruefenGewicht();
		Platz3.pruefenGewicht();

		System.out.println(Platz1.ausgeben());
		System.out.println(Platz2.ausgeben());
		System.out.println(Platz3.ausgeben());

		Platz1.umlagern(steak);
		Platz2.umlagern(salami);
		Platz3.umlagern(schinken);

		System.out.println(Platz1.ausgeben());
		System.out.println(Platz2.ausgeben());
		System.out.println(Platz3.ausgeben());
	}
}
