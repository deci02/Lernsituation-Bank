package arbeitszeitermittlung;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Arbeitszeit {
	private String name;
	private ArrayList<LocalDateTime> az;
	private long zeit;
	private double gehalt;

	public Arbeitszeit(ArrayList daten) {
		name = daten.get(0).toString();
		az = (ArrayList<LocalDateTime>) daten.get(2);
		gehalt = (double) daten.get(1);

		rechnen();
		output();
	}

	private void rechnen() {
		LocalDateTime prev = LocalDateTime.MIN;
		LocalDateTime curr;
		zeit = 0;
		for (int i = 0; i < az.size(); i++) {
			curr = az.get(i);
			if (i % 2 == 1) {
				zeit = zeit + ChronoUnit.MINUTES.between(prev, curr);
			}
			prev = curr;
		}
	}

	private void output() {
		DecimalFormat d = new DecimalFormat("#,##0.00");
		DateTimeFormatter t = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		d.setRoundingMode(RoundingMode.HALF_UP);
		System.out.println("Der Arbeitnehmer " + name + " hat in der Woche vom " + az.getFirst().toLocalDate().format(t)
				+ "\nbis zum " + az.getLast().toLocalDate().format(t) + " " + zeit / 60 + " Stunden und " + (zeit % 60)
				+ " Minuten gearbeitet. \nHierfür erhält er einen Lohn von " + d.format(gehalt * (double) zeit / 60)
				+ " Euro.");
	}

}
