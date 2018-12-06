package fczachor.cipher;

/**
 * KEYWORD CIPHER
 * This class extends MonoAlphabeticCipher.
 * Generates a secret alphabet
 * from a given keyword or password.
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	public KeywordCipher(String key){
		this.newAlphabet(key);
	}
	
	// Methods
	
	//NEW ALPHABET
	public void newAlphabet(String key){
		key = key.toLowerCase();
		String finishedAlphabet = "";
		
		for (int i = 0; i < key.length(); i++) {
			boolean used = false;
			for (int j = 0; j < finishedAlphabet.length(); j++) {
				if (finishedAlphabet.charAt(j) == key.charAt(i))
					used = true;
			}
			if (!used) {
				switch (key.charAt(i)) {
				case 'ä':
					finishedAlphabet = finishedAlphabet + 'ä';
					break;
				case 'ö':
					finishedAlphabet = finishedAlphabet + 'ö';
					break;
				case 'ü':
					finishedAlphabet = finishedAlphabet + 'ü';
					break;
				case 'ß':
					finishedAlphabet = finishedAlphabet + 'ß';
					break;
				default:
					if (key.charAt(i) >= 97 && key.charAt(i) <= 122)
						finishedAlphabet += key.charAt(i);
				}
			}
		}
		int keywordLength = finishedAlphabet.length();
		for (int i = 0; i < 30; i++) {
			boolean used2 = false;
			char nextLetter = (char) (97 + i);
			switch (nextLetter) {
			case 123:
				nextLetter = 'ä';
				break;
			case 124:
				nextLetter = 'ö';
				break;
			case 125:
				nextLetter = 'ü';
				break;
			case 126:
				nextLetter = 'ß';
				break;
			}
			for (int j = 0; j < keywordLength; j++) {
				if (nextLetter == finishedAlphabet.charAt(j))
					used2 = true;
			}
			if (!used2) {
				switch (nextLetter) {
				case 123:
					finishedAlphabet = finishedAlphabet +'ä';
					break;
				case 124:
					finishedAlphabet = finishedAlphabet +'ö';
					break;
				case 125:
					finishedAlphabet = finishedAlphabet +'ü';
					break;
				case 126:
					finishedAlphabet = finishedAlphabet +'ß';
					break;
				default:
					finishedAlphabet = finishedAlphabet + nextLetter;
				}
			}
		}
		super.setSecretAlphabet(finishedAlphabet);
	}
}
