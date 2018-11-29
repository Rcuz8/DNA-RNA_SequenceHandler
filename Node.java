
public class Node extends Object implements NodeStructure {
	// The value of the node
	private char value;
	// The node behind the current one.
	private Node next;
	
	/* Constructs a Node object. 
	 * 
	 * @param c The char value of the node
	 */
	public Node(char c) {
		value = Character.toUpperCase(c); // Capitalize and initialize the node value
	}
	
	/* Constructs a Node object. 
	 * 
	 * @param nxt The next node behind the one being constructed
	 * @param c The char value of the node
	 */
	public Node(Node nxt, char c) {
		next = nxt;
		value = Character.toUpperCase(c);  // Capitalize and initialize the node value
	}

	/* Constructs a Node object.
	 *
	 * @param n The node that this object is being created based upon
	 */
	public Node(Node n) {
		next = n.next();
		value = n.value();  // Capitalize and initialize the node value
	}
	
	@Override
	public char value() {
		return value;
	}

	@Override
	public void setValue(char c) {
		value = Character.toUpperCase(c);  // Capitalize and set the node value
	}

	@Override
	public boolean hasNext() {
		return (next != null);
	}

	@Override
	public Node next() {
		return next;
	}

	@Override
	public void setNext(Node n) {
		next = n;
	}

}
