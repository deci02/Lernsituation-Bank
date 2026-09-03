package Objektverarbeitung;

public class HauptObjekteSpeichern{
	public static void main(String[] args){
		Verein hsv = new Verein("HSV");
		VereineBearbeiten.speichern(hsv);

		Verein rb = new Verein("RB");
		VereineBearbeiten.speichern(rb);

		Verein bvb = new Verein("BVB");
		VereineBearbeiten.speichern(bvb);
	}
}
