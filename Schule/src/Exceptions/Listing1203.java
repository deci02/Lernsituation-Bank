package Exceptions;

public class Listing1203 {
	public static void main(String[] args) {
		int i, base = 0;
		try {
			for (base = 10; base >= 2; --base) {
				i = Integer.parseInt("40", base);
				System.out.println("40 base " + base + " = " + i);
			}
		} catch (NumberFormatException e) {
			System.out.println("***Fehler aufgetreten***");
			System.out.println("Ursache: " + e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}