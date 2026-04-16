package Exceptions;

public class BinaryToStringNumber {

	public static void main(String[] args) {
		try {
			System.out.println(umwandeln("10001110"));
			System.out.println(umwandeln("11111111"));
			System.out.println(umwandeln("00000000"));
//			System.out.println(umwandeln("12345678"));
//			System.out.println(umwandeln("123456789"));
			System.out.println(umwandeln("1234567"));
		} catch (NoBinaryNumberException e) {
			System.err.println(e);
		} finally {
			System.out.println("das ist der finally block");
		}

	}

	public static int umwandeln(String bin) throws NoBinaryNumberException, ArrayIndexOutOfBoundsException {
		if (bin.length() != 8) {
			throw new ArrayIndexOutOfBoundsException("String ist nicht 8 Stellen lang: " + bin.length() + " Stellen");
		}
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) != '0' && bin.charAt(i) != '1') {
				throw new NoBinaryNumberException(bin, i + 1);
			}
		}
		return Integer.parseInt(bin);
	}

}
