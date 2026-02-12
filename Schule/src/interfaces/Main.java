package interfaces;

import java.util.Enumeration;
import java.util.Random;
import java.util.random.RandomGeneratorFactory;

public class Main implements Arraybearbeitung, Enumeration<Integer> {

	public int[] arr;
	private int index;

	public static void main(String[] args) {
		Main a = new Main(5);
		Main b = new Main(1);
		Main c = new Main(0);
		Main d = new Main(100);
		a.alles();
		b.alles();
		c.alles();
		d.alles();
	}

	public void alles() {
		this.ausgeben();
		System.out.println("Anzahl: " + this.zaehlen());
		System.out.println("Summe: " + this.summieren());
	}
	
	public Main(int length) {
		arr = new int[length];
		fuellenRandom();
	}

	@Override
	public boolean hasMoreElements() {
		if (nextElement() == null) {
			index = 0;
			return false;
		}
		return true;
	}

	@Override
	public Integer nextElement() {
		if (arr.length == index) {
			return null;
		}
		return Integer.valueOf(arr[index]);
	}

	@Override
	public void ausgeben() {
		while (hasMoreElements()) {
			System.out.println(arr[index]);
			index = index + 1;
		}
	}

	@Override
	public int zaehlen() {
		return arr.length;
	}

	@Override
	public int summieren() {
		int sum = 0;
		while (hasMoreElements()) {
			sum = sum + arr[index];
			index = index + 1;
		}
		return sum;
	}

	private void fuellenRandom() {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10);
		}
	}

}
