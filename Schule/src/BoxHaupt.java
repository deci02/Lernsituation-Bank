
public class BoxHaupt {

	public static void main(String[] args) {
		
		Box box = new Box(2.5, 5.0, 6.0);
		System.out.println("Fläche: " + box.berechneFlaeche() + " Volumen: " + box.berechneVolumen());
		Box box2 = new Box(box);
		Box box3 = box2.groessereBox();
		Box box4 = box2.kleinereBox();
	}
	
}
