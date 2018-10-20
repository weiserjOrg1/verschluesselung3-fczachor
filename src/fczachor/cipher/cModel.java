package fczachor.cipher;

import javax.swing.JOptionPane;

public class cModel {
	private String output;
	private SubstitutionCipher su1;
	private ShiftCipher sh1;
	private int which;
	private KeywordCipher k1;
	
	
	public cModel() {
		this.which = 1;
		this.output = "N.A.";
		
		try {
			this.su1 = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
			this.sh1 = new ShiftCipher(0);
			this.k1 = new KeywordCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		}catch(Egseptions e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	public void setSubCipher(String alpha) throws Egseptions {

			this.su1.setSecretAlphabet(alpha);
	}
	
	public void setShiftCipher(int value)  {
		try {
			this.sh1.setShiftValue(value);
		}catch(Egseptions e) {
			
		}
			
	}
	
	public void setKeyCipher(String key) throws Egseptions{
		this.k1.setKeyword(key);
	}
	
	public void setEncryptText(String t) {
		switch(this.which) {
			case 1: this.output = this.su1.encrypt(t);
				break;
			case 2: this.output = this.sh1.encrypt(t);
				break;
			case 3: this.output = this.k1.encrypt(t);
				break;
			default: 
				break;
		}
	}
	
	public void setDecryptText(String t) {
		switch(this.which) {
		case 1: this.output = this.su1.decrypt(t);
			break;
		case 2: this.output = this.sh1.decrypt(t);
			break;
		case 3: this.output = this.k1.decrypt(t);
			break;
		default: 
			break;
		}
	}
	
	public String getOutput() {
		return this.output;
	}
	
	
	public void setWhich(int i) {
		this.which = i;
	}
	
	public int getWhich() {
		return this.which;
	}
}