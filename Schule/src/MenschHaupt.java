
public class MenschHaupt {
	// Main-Methode, um Objekte zu instanziieren
	public static void main(String[] args) {
		Person objekt1 = new Person("Stefan Raab", 56, 'm', 1.81, 88.8, 1, 3);
		Person objekt2 = new Person("Angela Merkel", 69, 'w', 1.65, 83.5, 1, 1);
		objekt1.sprechen();
		objekt2.sprechen();
		objekt1.abnehmen(3);
		objekt1.zunehmen(1.5);
		objekt2.zunehmen(1.2);
		objekt2.abnehmen(2.2);
		System.out.println(objekt1.errechnenBmi());
		System.out.println(objekt2.errechnenBmi());
		System.out.println(objekt1.ermittelnJahreBisRunderGeburtstag());
		System.out.println(objekt2.ermittelnJahreBisRunderGeburtstag());
		System.out.println(objekt1.getName() + " feiert seinen nächsten runden Geburtstag im Jahr "
				+ objekt1.ausgebenInformationRunderGeburtstag());
		System.out.println(objekt2.getName() + " feiert ihren nächsten runden Geburtstag im Jahr "
				+ objekt2.ausgebenInformationRunderGeburtstag());
		System.out.println("Familiengröße von Stefan Raab: " + objekt1.familiengroesse);
		System.out.println("Familiengröße von Angela Merkel: " + objekt2.familiengroesse);
		Person objekt3 = new Person("Angela Merkel", 69, 1.65);
		Person objekt4 = new Person("Stefan Raab", 56, 1.81);
		objekt3.sprechen("lang");
		objekt4.sprechen("kurz");
	}
}
