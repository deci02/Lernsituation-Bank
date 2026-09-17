package Objektverarbeitung;

import java.io.Serializable;

public class Verein implements Serializable {
	private String name;
	private int punkte;
	private int toreGeschossen;
	private int toreKassiert;

	public Verein(String name) {
		this.name = name;
	}

	public String toString() {
		return (name + "\t" + getPunkte() + "\t" + getToreGeschossen() + ":" + getToreKassiert());
	}

	public String getName() {
		return name;
	}

	public int getToreGeschossen() {
		return toreGeschossen;
	}

	public void setToreGeschossen(int toreGeschossen) {
		this.toreGeschossen = toreGeschossen;
	}

	public int getToreKassiert() {
		return toreKassiert;
	}

	public void setToreKassiert(int toreKassiert) {
		this.toreKassiert = toreKassiert;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
}
