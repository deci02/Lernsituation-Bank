package Objektverarbeitung;

import java.io.*;

public class BeispielObjekt implements Serializable {
	String name;
	String tier;
	double zahl;

	public BeispielObjekt(String a, String b, double c){
		this.name = a;
		this.tier = b;
		this.zahl = c;
	}

	public String toString(){
		String reString = ("Das Objekt heißt " + name + " und ist " + tier + " mit der Zahl " + zahl);
		return reString;
	}
}
