package arbeitszeitermittlung;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		ArrayList daten = new ArrayList(); 
		ArrayList<LocalDateTime> arbeitszeiten = new ArrayList<LocalDateTime>(); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 21, 8, 0)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 21, 16, 0)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 22, 7, 55)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 22, 12, 15)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 23, 9, 30)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 23, 13, 15)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 24, 9, 15)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 24, 18, 0)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 25, 8, 5)); 
		arbeitszeiten.add(LocalDateTime.of(2024, 6, 25, 15, 30)); 
		daten.add("Peter Lustig"); 
		daten.add(12.5); 
		daten.add(arbeitszeiten); 
		Arbeitszeit a1 = new Arbeitszeit(daten); 
	}
}
