
public class Sequence extends Object implements SequenceStructure {

	// The head node of the sequence
	private Node head;
	// The type of sequence that this object represents.
	private Type type;
	
	/* Constructs a Sequence. 
	 */
	public Sequence() {
		// Set the type to it's default value of unclassified.
		type = Type.unclassified;
	}
	
	/* Constructs a Sequence. 
	 * 
	 * @param head The head node of the sequence.
	 * @param t the sequence type
	 */
	public Sequence(char[] seq, Type t) {
		type = t;
		System.out.println("Sequence has first element: ");

		// Create the head node.
		Node top = new Node(seq[0]);
		// Create the first .next node for iteration
		Node current = top;
		for (char c: seq) {
			Node newNode = new Node(c);
			current.setNext(newNode);
			current = newNode;
		}
		// Set head to top
		head = top.next();
	}

	/* Constructs a Sequence. This is for an empty sequence.
	 *
	 * @param t the sequence type
	 */
	public Sequence(Type t) {
		type = t;
	}
	
	@Override
	public boolean sequenceValid() {
		// Set initial node to true
		Node node = head;
		
		/* Set a variable valid to track whether or not the element
		 * list as a whole is valid.
		 */
		boolean valid = true;
		
		if (type == Type.DNA) { // Execute this block for type DNA
			while (node.hasNext()) { // Execute as long as the node has a node behind it.
				// Check that the node's value is a DNA character
				if (node.value() == 'A' || node.value() == 'C' || node.value() == 'G' || node.value() == 'T') {
					// Do Nothing
				} else  // The character was not a DNA character
					valid = false; // Notify the validity tracker that the sequence is invalid 
				
				// Increment the current node to the next node behind it
				node = node.next(); 
			}
		} else if (type == Type.RNA) { // Execute this block for type RNA
			while (node.hasNext()) {  // Execute as long as the node has a node behind it.
				// Check that the node's value is a RNA character
				if (node.value() == 'A' || node.value() == 'C' || node.value() == 'G' || node.value() == 'U') {
					// Do Nothing
				} else   // The character was not a RNA character
					valid = false; // Notify the validity tracker that the sequence is invalid
				
				// Increment the current node to the next node behind it
				node = node.next(); 
			}
		}
		// Return the validity of the sequence.
		return valid;
	}

	@Override
	public boolean inputValid(Sequence s) {
		// Set initial node to true
		Node node = s.getHead();
		
		/* Set a variable valid to track whether or not the element
		 * list as a whole is valid.
		 */
		boolean valid = true;
		
		if (s.getType() == Type.DNA) { // Execute this block for type DNA
			while (node.hasNext()) { // Execute as long as the node has a node behind it.
				// Check that the node's value is a DNA character
				if (node.value() == 'A' || node.value() == 'C' || node.value() == 'G' || node.value() == 'T') {
					// Do Nothing
				} else  // The character was not a DNA character
					valid = false; // Notify the validity tracker that the sequence is invalid 
				
				// Increment the current node to the next node behind it
				node = node.next(); 
			}
		} else if (s.getType() == Type.RNA) { // Execute this block for type RNA
			while (node.hasNext()) {  // Execute as long as the node has a node behind it.
				// Check that the node's value is a RNA character
				if (node.value() == 'A' || node.value() == 'C' || node.value() == 'G' || node.value() == 'U') {
					// Do Nothing
				} else   // The character was not a RNA character
					valid = false; // Notify the validity tracker that the sequence is invalid
				
				// Increment the current node to the next node behind it
				node = node.next(); 
			}
		}
		// Return the validity of the sequence.
		return valid;
	}

	@Override
	public void clearSequence() {
		// Set head to null
		head = null;
		// Reset type
		type = Type.unclassified;
	}

	@Override
	public void setSequence(Node n) {
		// Set the head of the sequence to the inputed Node
		head = n;
	}

	@Override
	public void remove(Node n) {
		assert head != null : "Element does not exist!";
		// Set first node to the sequence's head.
		Node node = head;
		
		
		while (node.hasNext()) { // Iterate while the node has a next node following it.
			// Check if the next node's value matches the target value
			if (node.next().value() == n.value()) {
				/* Check if the next node has another node behind it. If it does,
				 * we will set the node we are looking at's next node to that one.
				 * If it does not, we will simple nullify the next node of the 
				 * node we are looking at.
				 */
				if (node.next().hasNext()) // Check if next node has node behind it
					node.setNext(node.next().next()); // Set the next node to the node behind the current next node
				else
					node.setNext(null); // Nullify/delete the next node
			}
			node = node.next();
		}
		
	}

	@Override
	public Node getHead() {
		return head;
	}

	@Override
	public void setHead(Node n) {
		head = n;
	}
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setType(Type t) {
		type = t;
	}

	@Override
	public boolean isTranscribeable() {
		return (type == Type.DNA);
	}

	@Override
	public void transcribe() {
		// Ensure that the type is valid
		assert (type != Type.RNA && type != Type.unclassified): "Invalid Transcription";
		// Ensure that the head is valid
		assert head != null: "Invalid Transcription: Head does not exist";
		// Get the head node
		Node n = head;
		// Iterate through nodes while the node has a value
		while (n != null) {
			switch(n.value()) { // Check the value of n
			case 'T': n.setValue('U'); break; // Convert Ts to Us to convert from DNA to RNA
			}
			n = n.next(); // Will have value unless node does not have next value
		}
	}

	@Override
	public String toString() {
		if (head == null ) return "This is an empty sequence!\n";
		// Define return value as the head node of the array
		String ret = head.value() + " ";
		// Iterate through nodes front to back
		for (Node n = head; n.hasNext(); n = n.next()) {
			// Add the next node's value and a space to the return value
			ret += n.next().value() + " ";
		}
		return ret;
	}

	/** Returns the length of the sequence
	 *
	 * @return the length of the sequence
	 */
	public int length() {
		if (head == null ) return 0;
		// Initialize the counter
		int count = 0;
		// Iterate through nodes front to back
		for (Node n = head; n.hasNext(); n = n.next()) {
			// Increment count
			count++;
		}
		return count;
	}
}
