package fczachor.cipher;

/**
 * KEYWORD CIPHER
 * This class extends MonoAlphabeticCipher.
 * The characters of a message 
 * are re-sorted (of plain text)
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class TranspositionCipher implements Cipher {
	
	// Attributes
	private int transpositionLevel;

	// Constructor
	public TranspositionCipher(int transpositionLevel) {
		if (transpositionLevel >= 1) {
			this.transpositionLevel = transpositionLevel;
		} else {
			this.transpositionLevel = 1;
		}
	}
	
	// Methods

	// DECRYPT
	public String decrypt(String input) {
		input = input.toLowerCase();
		if (input.indexOf(' ') == -1) {
			return input;
		}
		String[] pieces = new String[this.transpositionLevel + 1];
		int spaceAmount = 0;
		
		// Check if structure fits to level
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				spaceAmount++;
			}
			if (i == input.length() - 1 && spaceAmount != this.transpositionLevel) {
				return input;
			}
		}
		int lastSpaceIndex = 0;
		int longestPiece = 0;
		for (int i = 0; i < this.transpositionLevel + 1; i++) {
			if (i != this.transpositionLevel) {
				pieces[i] = input.substring(lastSpaceIndex, input.indexOf(' ', lastSpaceIndex));
				if (pieces[i].length() > longestPiece) {
					longestPiece = pieces[i].length();
				}
			} else {
				pieces[i] = input.substring(lastSpaceIndex);
				if (pieces[i].length() > longestPiece) {
					longestPiece = pieces[i].length();
				}
			}
			lastSpaceIndex = input.indexOf(' ', lastSpaceIndex) + 1;
		}
		int pieceLengthTotal = 0;
		
		// Length of all pieces together
		for (int i = 0; i < pieces.length; i++) {
			pieceLengthTotal = pieceLengthTotal + pieces[i].length();
		}
		String ausgabe = "";
		int firstPieceIndex = 0, lastPieceIndex = 0, lettersUsed = 0;
		if (this.transpositionLevel > 1) {
			xyz: for (int i = 0; i < longestPiece; i++) {
				if (i % 2 == 0) {
					for (int j = (i == 0) ? 0 : 1; j < pieces.length; j++) {
						if (j == 0) {
							ausgabe = ausgabe + pieces[j].charAt(firstPieceIndex);
							firstPieceIndex++;
							lettersUsed++;
						} else if (j == pieces.length - 1) {
							ausgabe = ausgabe + pieces[j].charAt(lastPieceIndex);
							lastPieceIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							ausgabe = ausgabe + pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLengthTotal) {
							break xyz;
						}
					}
				} else {
					for (int j = pieces.length - 2; j > -1; j--) {
						if (j == 0) {
							ausgabe = ausgabe + pieces[j].charAt(firstPieceIndex);
							firstPieceIndex++;
							lettersUsed++;
						} else if (!(pieces[j].length() < (i + 1))) {
							ausgabe = ausgabe + pieces[j].charAt(i);
							lettersUsed++;
						}
						if (lettersUsed == pieceLengthTotal) {
							break xyz;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < longestPiece; i++) {
				if (i == longestPiece - 1 && pieces[0].length() != pieces[1].length()) {
					ausgabe = ausgabe + pieces[0].charAt(i);
				} else {
					ausgabe = ausgabe + pieces[0].charAt(i) + "" + pieces[1].charAt(i);
				}
			}
		}
		return ausgabe;
	}
	
	// ENCRYPT
	public String encrypt(String text) {
		text = text.toLowerCase();
		String filteredText = "";
		for (int i = 0; i < text.length(); i++) { // Filter out anything but a letter
			char currentLetter = text.charAt(i);
			switch (currentLetter) {
			case 'ä':
			case 'ö':
			case 'ü':
			case 'ß':
				filteredText = filteredText + currentLetter;
				break;
			default:
				if (currentLetter >= 97 && currentLetter <= 122)
					filteredText = filteredText + currentLetter;
			}
		}
		String output = "";
		char[][] array = new char[this.transpositionLevel + 1][filteredText.length()];
		boolean plus = false;
		int k = 0;
		for (int i = 0; i < filteredText.length(); i++) {
			array[k][i] = filteredText.charAt(i);
			if (!plus) {
				k++;
			}
			if (plus) {
				k--;
			}
			if (k == this.transpositionLevel) {
				plus = true;
			}
			if (k == 0) {
				plus = false;
			}
		}
		int verwendet = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					output = output + array[i][j];
					verwendet++;
				}
			}
			if (verwendet >= filteredText.length())
				break;
			if (i != array.length - 1)
				output = output + ' ';
		}
		return output;
	}
	
	// SET TRANSPOSITION LEVEL
	public void setTranspositionLevel(int transpositionLevel) {
		if (transpositionLevel >= 1)
			this.transpositionLevel = transpositionLevel;
	}
}
