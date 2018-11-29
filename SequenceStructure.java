
public interface SequenceStructure {
	
	/* Checks that the current sequence's letters are consistent
	 * with their type.
	 * 
	 * @return whether or not the current sequence's letters are consistent
	 * with their type.
	 */
	boolean sequenceValid();
	
	/* Checks that the inputed sequence's letters are consistent
	 * with the existing sequences type.
	 * 
	 * @param n The sequence to be checked for validity.
	 * @return whether or not the inputed sequence's letters are consistent
	 * with the existing sequences type.
	 */
	boolean inputValid(Sequence s);
	
	/* Clears the sequence and resets the sequence's type to it's default
	 * value.
	 * 
	 */
	void clearSequence();
	
	/* Sets the sequence to a new sequence (provided as a param).
	 * 
	 * @param n the head node of the new sequence (as a linked list).
	 */
	void setSequence(Node n);
	
	/* Removes the node from the sequence.
	 * 
	 * @param n the node to be removed from the sequence.
	 */
	void remove(Node n);
	
	/* Custom String descriptor for the sequence.
	 * 
	 * @return a String describing the sequence. Displays Sequence type
	 * and the elements in the sequence.
	 */
	String toString();
	
	/* Returns the head of the sequence.
	 * 
	 * @return the head of the sequence.
	 */
	Node getHead();
	
	/* Sets the head of the sequence to a new head.
	 * 
	 * @param n the new head of the sequence.
	 */
	void setHead(Node n);
	
	/* Returns the sequence's type.
	 * 
	 * @return the sequence's type.
	 */
	Type getType();
	
	/* Sets the sequence's type to the inputed type.
	 * 
	 * @param The type to set the existing type to.
	 */
	void setType(Type t);
	
	/* Returns whether or not the sequence is transcribeable. Returns
	 * true if the sequence is of type DNA, but returns false if it is
	 * of type RNA.
	 * 
	 * @return whether or not the sequence is transcribeable.
	 */
	boolean isTranscribeable();
	
	/* Transcribes the sequence. DNA can be transcribed, however, RNA
	 * cannot be.
	 * 
	 * <h3> NOTE: 
	 * <p> Please check that the sequence can be transcribed using the
	 * isTranscribeable function before using for safety.
	 * 
	 */
	void transcribe();
}
