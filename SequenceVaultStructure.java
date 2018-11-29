
public interface SequenceVaultStructure {
	/** Insert a sequence into the sequence array at the provided position.
	 * 
	 * @param pos The position to be inserted into the sequence array at.
	 * @param t The type of sequence
	 * @param seq The array of characters which are the values of the sequence.
	 */
	public void insert(int pos, Type t, char[] seq);
	
	/** Remove the nth element from the sequence array.
	 * 
	 * @param pos The position to be removed
	 */
	public void remove(int pos);
	
	/** Print the sequence array
	 */
	public void print();
	
	/** Print the nth element of the sequence array
	 * @param pos The element to be printed
	 */
	public void printPos(int pos);
	
	/** Replaces the sequence at the nth position of the array
	 * with a snippet of itself within the boundaries of 
	 * start and end.
	 * 
	 * @param pos The position of the sequence in the sequence array to be changed.
	 * @param start the starting position within the sequence to not be clipped.
	 * @param end the last position within the sequence to not be clipped.
	 */
	public void clip(int pos, int start, int end);
	
	/** Copies one element of the sequence array onto another.
	 * 
	 * @param pos1 The element in the sequence array to be copied.
	 * @param pos2 The element in the sequence array to have pos1 pasted onto.
	 */
	public void copy(int pos1, int pos2);
	
	/** Transcribes the sequence in the sequence array at the position provided.
	 * 
	 * @param pos The position in the sequence array of the sequence to be transcribed.
	 */
	public void transcribe(int pos);
	
	/** Returns the max size of the sequence of the array.
	 * 
	 * @return the max size of the sequence of the array.
	 */
	public int maxSize();
	
	/** Returns the size of the sequence of the array.
	 * 
	 * @return the size of the sequence of the array.
	 */
	public int size();
	
	/** Finds the index of the provided element in the sequence array
	 * 
	 * @param el the element to be found
	 * @return the index of the element.
	 */
	public int indexOf(Sequence s);
}
