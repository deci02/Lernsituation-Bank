package dkrypt_caesar;

import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc_encrypt = new Scanner(System.in);
		String encrypt = sc_encrypt.next();
		Scanner sc_schluess = new Scanner(System.in);
		int schluess = sc_schluess.nextInt();
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		char[] arr_s = new char[26];
		StringBuilder decrypt = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			if (i + schluess >= arr_s.length) {
				arr_s[i] = arr[i + schluess - 26];
			} else {
				arr_s[i] = arr[i + schluess];
			}
		}

		for (int i = 0; i < encrypt.length(); i++) {

			if (encrypt.charAt(i) == ' ') {
				decrypt.append(' ');
			} else {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] == encrypt.charAt(i)) {
						decrypt.append(arr_s[j]);
						break;
					}
				}
			}

		}
		System.out.println(decrypt.toString());
	}

}
