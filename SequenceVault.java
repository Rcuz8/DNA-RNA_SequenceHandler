
public class SequenceVault<E> extends Printable<E> implements SequenceVaultStructure {
	// Array of the sequences
	Sequence[] sequences;
	// Max size that sequences can be
	final int MAX_SIZE;
	// Current size of sequences
	int size;
	
	/* Constructs a SequenceVault object.
	 * 
	 * @param max_size The maximum size of the sequences array.
	 */
	public SequenceVault(int max_size) {
		MAX_SIZE = max_size; // Initialize maximum size
		sequences = new Sequence[MAX_SIZE]; // Initialize the sequence array
		size = 0; // Initialize the size to default zero
	}
	
	@Override
	public void insert(int pos, Type t, char[] seq) {
		// Prevent adding  element at position after size.
		assert pos <= MAX_SIZE : "Insertion position exceeds the size of the array!";
		// Check that the sequence is non-empty
		if ((seq+"") != null && !(seq+"").equals("")) {
			Sequence s = new Sequence(seq, t);
			if (s.sequenceValid()) {
				prl("\ninit to new, valid sequence!");
				// initialize next element in sequence list
				sequences[size] = s;
			} else {
				prl("\nCould not insert new sequence as it was not syntactically correct!");
			}

		} else {
			prl("\ninit to empty eeq");
			// initialize next element in sequence list
			sequences[size] = new Sequence(t);
		}

		prl("Sequences[" + pos + "] is now valid: " + (sequences[size] != null));
		// increment the size
		size++;
	}

	@Override
	public void remove(int pos) {
		// Check if there is an element at pos
		if (sequences[pos] != null) {
			// Clear sequence
			sequences[pos] = null;
			// Decrease the size
			size--;
		} else {
			prl("\n Removal failed. There is no element at position " + pos + " of sequences!");
		}
	}

	@Override
	public void print() {
		// Print User-Friendly message
		prl("\nSequence Vault:\n---------------");
		// Iterate through elements
		for (int i = 0; i < size; i++) {
			if (sequences[i] != null)
				// Print sequence element
				prl(sequences[i].toString());
		}

		// Print User-Friendly message
		prl("\n---------------");

	}

	@Override
	public void printPos(int pos) {
		prl("\nCalled print at position " + pos);

//		// Prevent element at position after size.
		if (sequences[pos] != null) {
			// Print User-Friendly message
			prl("Element #" + (pos+1) + ": " + sequences[pos].toString());
		} else {
			prl("Printing failed as there is no element at the position specified!");
		}

	}

	@Override
	public void clip(int pos, int start, int end) {
		// Check index params to ensure valid specifications
		if (sequences[pos] != null && start < end && end < sequences[pos].length()) {
			// Get head node
			Node new_head = sequences[pos].getHead();
			// Iterate while the start or the Linked List is greater than zero
			while (start > 0) {
				if (!new_head.hasNext()) return; // This means there was an error
				// Set n to the next element
				new_head = new_head.next();
				// Decrement start
				start--;
				// Decrement end (to keep same distance)
				end--;
			}

			/* Now we should have the correct node as the new head node new_head */

			Node tempCounter = new_head;
			// Iterate while start is less than n (while there are that many elements
			while (start < end) {
				// Incremenet temp counter
				tempCounter = tempCounter.next();
				// incremenet start
				start++;
			}
			// Remove temp counter (now the element in linked list at position end) next
			tempCounter.setNext(null);
			// Set the new head node to the desired position in sequences
			sequences[pos].setHead(new_head);
		} else {
			prl("Cannot clip as index params are invalid!");
		}

	}

	@Override
	public void copy(int pos1, int pos2) {
		prl("Attempting copy..");
		// Check that the indices are within the proper bounds
		if (pos1 >= 0 && pos2 >= 0 && pos2 < MAX_SIZE) {
			// Check that there is an element at pos1 of sequences
			if (sequences[pos1] != null) {
				prl("Copying " + sequences[pos1].toString() + " to " + pos2);
				// Copy the first element into the second element
				sequences[pos2] = sequences[pos1];
				prl("Copied " + sequences[pos1].toString() + " to " + sequences[pos2].toString());
			} else {
				prl("Could not copy because no suitable element exists at position " + pos1);
			}

		} else {
			// Index out of bounds
			prl("Could not copy because no suitable element exists at position " + pos1);
		}

	}

	@Override
	public void transcribe(int pos) {
		// Check that position is in bounds
		if (pos > 0 && pos < MAX_SIZE && sequences[pos] != null) {
			// Check that the element is transcribeable
			if (sequences[pos].isTranscribeable()) {
				// Execute transcription
				sequences[pos].transcribe();
			} else {
				prl("Sequence at position " + pos + " not transcribeable!");
			}
		} else {
			prl("There is no element at the position to be transcribed! ");
		}
	}

	@Override
	public int maxSize() {
		return MAX_SIZE;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Sequence s) {
		if (s != null) {
			prl(size/2);
			/* Attempting an interesting implementation of a linear search to
			 * potentially generate a small bit of additional efficiency.
			 * This implementation works from the middle out. Should save
			 * N/2 loops. Instead of 2n+1 times, will execute 1.5n+1 times.
			 */
			// Initialize the first position
			int mid = size/2;
			// Iterate through sequences
			for (int i = 0; i < mid; i++) {
				prl(mid+i);
				prl(mid-i);
				if (sequences[mid+i].equals(s)) return mid+i;
				if (sequences[mid-i].equals(s)) return mid-i;
			}
			return -1; // Default value for element not found
		} else {
			return -1; // Default value for element not found
		}

	}
	
}
