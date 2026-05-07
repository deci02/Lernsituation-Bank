package Paketstation;

public class Paket {

	private String empfaenger;
	private int nr;
	private static int sendungsnr = 1;

	public Paket(String empfaenger) {
		this.empfaenger = empfaenger;
		this.nr = sendungsnr;
		this.sendungsnr += 1;
	}

	public static void decreaseSeNr() {
		sendungsnr -= 1;
	}

	public String getEmpfaenger() {
		return empfaenger;
	}

	public int getNr() {
		return nr;
	}

}
