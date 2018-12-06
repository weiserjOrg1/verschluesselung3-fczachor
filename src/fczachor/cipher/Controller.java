package fczachor.cipher;

/**
 * CONTROLLER
 * This class implements ActionListener.
 * It checks if a button or a circle is clicked
 * and performs an action.
 * @author Florian Czachor
 * @version 27.11.2018
 */

// Import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller implements ActionListener {

	// Attributes
	private Model m;
	private View v;
	private int helper;
	
	// Constructor
	public Controller() {
		this.m = new Model();
		this.v = new View(this, this.m);
		this.helper = 0; 									// if help is 0 = SubstitutionC, 1 = ShiftC, 2 = "Other" (Infinity)
	}

	// Methods
	
	// ACTIONPERFORMED
	public void actionPerformed(ActionEvent e) {
		
		// Shift Cipher
		if (this.v.isShiftCipher(e)) {
			this.v.activateShiftC();
			this.helper = 1;
		}
		
		// Substitution Cipher
		if (this.v.isSubCipher(e)) {
			this.v.activateSubC();
			this.helper = 0;
		}
		
		// Decrypts
		if (this.v.isDecrypt(e)) {
			if (this.v.isTrans()) {
				this.v.setOutput(this.m.tsc.decrypt(this.v.getText()));
			} else {
				this.v.setOutput(this.m.mac.decrypt(this.v.getText()));
			}
		}
		
		// Encrypts
		if (this.v.isEncrypt(e)) {	
			if (this.v.isTrans()) {
				this.v.setOutput(this.m.tsc.encrypt(this.v.getText()));
			} else {
				this.v.setOutput(this.m.mac.encrypt(this.v.getText()));
			}
		}
		
		// Applying
		if (this.v.isApply(e)) {
			if (this.helper == 0) {
				this.m.mac.setSecretAlphabet(this.v.getSubAlph());
			}
			if (this.helper == 1) {
				this.m.shc.setShiftValue(Integer.parseInt(this.v.getShiftAlph()));
			}
			if (this.helper == 2) {
				this.m.kc.newAlphabet(this.v.getKeyAlph());
			}
		}
		
		// Transposition Cipher 
		if (this.v.isTransCipher(e)) {
			this.v.activateTransC();
			this.helper = 0;
		}
		
		// Keyword Cipher 
		if (this.v.isKeyCipher(e)) {
			this.v.activateKeyC();
			this.helper = 2;
		}
	}
}
