
public enum Type {
	DNA, RNA, unclassified;

	/** Gets the type from a string representation
	 *
	 * @param s The string to be checked
	 * @return the type
	 */
	static public Type fromString(String s) {
		if (s.equalsIgnoreCase("DNA")) // Check for DNA
			return Type.DNA;
		else if (s.equalsIgnoreCase("RNA")) // Check for RNA
			return Type.RNA;
		else return Type.unclassified; // Default case
	}

}
