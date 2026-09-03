package IOStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test {
	public static void main(String args[]) {
//		File myObj = new File("C:\\Users\\Dennis\\git\\Lernsituation-Bank\\Schule\\Ordner\\test.txt");
//
//		try (Scanner myReader = new Scanner(myObj)) {
//			myObj.delete();
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
//		try {
//			FileWriter myWriter = new FileWriter(myObj);
//			myWriter.write("Hello World");
//			myWriter.close();
//			File myFolder = new File("C:\\Users\\Dennis\\git\\Lernsituation-Bank\\Schule\\Ordner");
//			myFolder.mkdir();
//			myObj.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		try (Scanner myReader = new Scanner(myObj)) {
//			while (myReader.hasNextLine()) {
//				String data = myReader.nextLine();
//				System.out.println(data);
//			}
//			System.out.println(myObj.getAbsolutePath());
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
		File file = new File("C:\\Users\\Dennis\\git\\Lernsituation-Bank\\Schule\\Ordner\\test.txt");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		     FileWriter writer = new FileWriter(file)) {

		    System.out.println("Text eingeben (mit Strg+Z + Enter beenden):");

		    String line;
		    while ((line = reader.readLine()) != null) {
		        writer.write(line);
		        writer.write(System.lineSeparator());
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	private static void aufgabe2() {
		String a = "";
		try {
			a = new BufferedReader(new InputStreamReader(System.in)).readLine();
			System.out.println("Int: " + Integer.parseInt(a));
		} catch (NumberFormatException e1) {
			try {
				System.out.println("Double: " + Double.parseDouble(a));
			} catch (NumberFormatException e2) {
				System.out.println("String: " + a);
			}
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}

	private static void aufgabe1() {
		int a;
		try {
			System.out.print("Bitte Zeichen eingeben: ");
			while ((a = System.in.read()) != -1) {
				System.out.println((char) a + " hat den ASCII-Code " + a);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
