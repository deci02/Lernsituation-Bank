package Exceptions;

public class NoBinaryNumberException extends RuntimeException {

	public NoBinaryNumberException() {
		super();
	}
	
	public NoBinaryNumberException(String text) {
		super(text);
	}
	
	public NoBinaryNumberException(String bin, int pos) {
		super("Fehler bei der Binärzahl " + bin + " an Position " + pos);
	}
}
