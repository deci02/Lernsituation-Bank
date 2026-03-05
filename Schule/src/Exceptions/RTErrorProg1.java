package Exceptions;

public class RTErrorProg1 {
	public static void main(String[] args) {
		int i, base = 0;
		for (base = 10; base >= 2; --base) {
			i = Integer.parseInt("40", base);
			System.out.println("40 base " + base + " = " + i);
		}
	}
}