package fczachor.cipher;

/**
 * MODEL
 * @author Florian Czachor
 * @version 27.11.2018
 */

// Imports
import javax.swing.*;

public class Model {
	
	// Attributes
	public MonoAlphabeticCipher mac;
	public SubstitutionCipher suc;
	public ShiftCipher shc;
	public TranspositionCipher tsc;
	public KeywordCipher kc;
	
	// Constructor
	public Model(){
		this.mac = new MonoAlphabeticCipher();	
		this.suc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		this.shc = new ShiftCipher(0);
		this.tsc = new TranspositionCipher(0);
		this.kc = new KeywordCipher("");
		this.mac = this.suc;
	}
}
