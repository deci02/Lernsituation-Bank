package ISBN;

public class ISBN {

	private String isbn;
	private String isbnOhneBindestriche = "";
	private int isbnOhneBindestricheLaenge;
	private char[] isbnOhneStrichCharArray;
	private int pruefziffer;

	public ISBN(String isbn) {
		if (isbn.matches("[0-9\\-]*") && isbn.length() == 15) {
			this.isbn = isbn;
			this.auseinandernehmen();
			this.pruefzifferErrechnen();
			System.out.println(this.ausgeben());
		} else {
			System.out.println("ungültige Eingabe: " + isbn);
		}
	}

	public void auseinandernehmen() {
		String isbnOhneBindestriche = this.isbn.replace("-", ""); // diese Zeile würde reichen, ABER es soll ja
																	// zeichenweise geschehen. Also umständlich:
		this.isbnOhneStrichCharArray = new char[this.isbn.replace("-", "").length()];
		this.isbnOhneBindestricheLaenge = isbnOhneBindestriche.length();
		int tmp = 0;
		for (int i = 0; i < this.isbn.length(); i++) {
			if (this.isbn.charAt(i) == '-') {
				tmp++;
			} else {
				this.isbnOhneStrichCharArray[i - tmp] = this.isbn.charAt(i);
			}
		}

		for (int i = 0; i < this.isbnOhneBindestricheLaenge; i++) {
			this.isbnOhneBindestriche = this.isbnOhneBindestriche
					.concat(String.valueOf(this.isbnOhneStrichCharArray[i]));
		}
	}

	public void pruefzifferErrechnen() {
		int summe = 0;
		for (int i = 0; i < this.isbnOhneBindestricheLaenge; i++) {
			if (i % 2 == 0) {
				summe = summe + Integer.valueOf(String.valueOf(this.isbnOhneStrichCharArray[i]));
			} else {
				summe = summe + Integer.valueOf(String.valueOf(this.isbnOhneStrichCharArray[i])) * 3;
			}
		}
		this.pruefziffer = (10 - (summe % 10)) % 10;
	}

	public String ausgeben() {
		String fertigeIsbn = "";
		int tmp = 0;
		char[] fullIsbnCharArray = new char[this.isbn.length()];

		fullIsbnCharArray = this.isbn.toCharArray();
		for (int i = 0; i < this.isbn.length(); i++) {
			if (fullIsbnCharArray[i] == '-') {
				tmp++;
			}
		}

		int[] bindestriche = new int[tmp];
		int tmp2 = 0;
		for (int i = 0; i < this.isbn.length(); i++) {
			if (fullIsbnCharArray[i] == '-') {
				bindestriche[tmp2] = i;
				tmp2++;
			}
		}

		tmp2 = 0;
		for (int i = 0; i < this.isbnOhneBindestricheLaenge; i++) {
			if (bindestriche[tmp2] == (i + tmp2)) {
				fertigeIsbn = fertigeIsbn.concat("-");
				if (tmp2 < (bindestriche.length - 1)) {
					tmp2++;
				}
			}
			fertigeIsbn = fertigeIsbn.concat(String.valueOf(this.isbnOhneStrichCharArray[i]));
		}

//		for (int i = 0; i < this.isbn.length(); i++) {
//			if (this.isbn.charAt(i) == '-') {
//				j++;
//				fertigeIsbn = fertigeIsbn.concat("-");
//			} else {
//				fertigeIsbn = fertigeIsbn.concat(String.valueOf(this.isbnOhneBindestriche.charAt(i - j)));
//			}
//		}
		fertigeIsbn = fertigeIsbn.concat("-");
		fertigeIsbn = fertigeIsbn.concat(String.valueOf(this.pruefziffer));
		return fertigeIsbn;

		// auch das hier hätte ausgereicht
		// tmp = tmp.concat(String.valueOf(this.pruefziffer));
		// return isbn.concat(tmp);
	}

}
