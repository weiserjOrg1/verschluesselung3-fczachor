package fczachor.cipher;

public class Egseptions extends Exception{
	public Egseptions() {
		super("Something is wrong");
	}
	
	public Egseptions(String m) {
		super(m);
	}
}