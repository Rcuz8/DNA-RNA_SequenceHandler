
public interface NodeStructure {

	/* Gets the value of the node.
	 */
	char value();
	
	/* Sets the value of the node to the new input.
	 * 
	 * @param c The character to which we are going to set the value.
	 */
	void setValue(char c);
	
	/* Check if there is another Node behind the current one.
	 * @return whether or not another node exists behind the current one.
	 */
	boolean hasNext();
	
	/* Get the next node.
	 * @return the next node.
	 */
	Node next();
	/* Sets the next Node to the one provided as a param.
	 * @param n The node to be the next node behind the existing one.
	 */
	void setNext(Node n);
}
