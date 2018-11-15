public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {
		TST<Integer> tst = new TST<>();
		int score = 0;
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].length() ==0 || dictionary[i].length()==1 || dictionary[i].length() ==2) {
				score = 0;
			}

			else if (dictionary[i].length() == 3 || dictionary[i].length() == 4) {
				score = 1;
			}

			else if (dictionary[i].length() == 5) {
				score  = 2;
			}

			else if (dictionary[i].length() == 6) {
				score = 3;
			}

			else if (dictionary[i].length() == 7) {
				score = 5;
			}

			else if (dictionary[i].length() == 8) {
				score = 11;
			}
			else {
				score = 0;
			}
			tst.put(dictionary[i], score);
		}

	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		return new Bag<String>();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		TST<Integer> tst = new TST<>();
		if(tst.contains(word)) {
			return tst.get(word);
		}
		else {
			return 0;
		}
	}
}