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
				case '�':
					finishedAlphabet = finishedAlphabet + '�';
					break;
				case '�':
					finishedAlphabet = finishedAlphabet + '�';
					break;
				case '�':
					finishedAlphabet = finishedAlphabet + '�';
					break;
				case '�':
					finishedAlphabet = finishedAlphabet + '�';
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
				nextLetter = '�';
				break;
			case 124:
				nextLetter = '�';
				break;
			case 125:
				nextLetter = '�';
				break;
			case 126:
				nextLetter = '�';
				break;
			}
			for (int j = 0; j < keywordLength; j++) {
				if (nextLetter == finishedAlphabet.charAt(j))
					used2 = true;
			}
			if (!used2) {
				switch (nextLetter) {
				case 123:
					finishedAlphabet = finishedAlphabet +'�';
					break;
				case 124:
					finishedAlphabet = finishedAlphabet +'�';
					break;
				case 125:
					finishedAlphabet = finishedAlphabet +'�';
					break;
				case 126:
					finishedAlphabet = finishedAlphabet +'�';
					break;
				default:
					finishedAlphabet = finishedAlphabet + nextLetter;
				}
			}
		}
		super.setSecretAlphabet(finishedAlphabet);
	}
}
