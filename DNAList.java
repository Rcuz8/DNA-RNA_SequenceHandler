import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DNAList {
	// Constructor for DNAList in the event that biol is executed.
	DNAList(String[] args) {
	// Get array size from first parameter
		int array_size = Integer.parseInt(args[0]);
		// Get file name from first parameter
		// & Get path for input file (natural path + the project path)
		String path = args[1]; // Should be given correctly and should not need System.getProperty("user.dir") + "/src/" + args[1];
		// Create a new File object given the filepath
		File file = new File(path);
		// Get the number of non-empty liens in the file
		int lines = getFileLinesCount(file);
		/* Initialize vault with a max size of double the number of real lines
		 * in the file to handle the case of all lines being insertion into the
		 * array.
		 */
		vault = new SequenceVault(array_size);
		// Execute the code from the file's contents
		executeFromFile(file);
	}

	// This is the main medium in which we do everything, the sequence vault.
	static SequenceVault vault;

	public static void main(String[] args) {
		// Get array size from first parameter
		int array_size = Integer.parseInt(args[0]);
		// Get file name from first parameter
		// & Get path for input file (natural path + the project path)
		String path = args[1]; // Should be given correctly and should not need System.getProperty("user.dir") + "/src/" + args[1];
		// Create a new File object given the filepath
		File file = new File(path);
		// Get the number of non-empty liens in the file
		int lines = getFileLinesCount(file);
		/* Initialize vault with a max size of double the number of real lines
		* in the file to handle the case of all lines being insertion into the
		* array.
		*/
		vault = new SequenceVault(array_size);
		// Execute the code from the file's contents
		executeFromFile(file);
	}

	/** Parses the file's code and calls the execution of each additional non-empty line
	 *
	 * @param file The file to be parsed
	 */
	public static void executeFromFile(File file) {

		Scanner sc = null;
		try {
			// pass the path to the file as a parameter
			sc = new Scanner(file);

			// Check that the scanner has another line of input
			while (sc.hasNextLine()) {
				// Retreive that line
				String s = sc.nextLine();
				// Check whether or not that line is equal to an empty string (empty line)
				if (!s.equals("")) // If not
					execute(s); // Execute the code equivalent of the pseudocode of the line
			}

		} catch (FileNotFoundException e) { // Catch the file not being found
			e.printStackTrace(); // Print the stack trace (should not be executed)
		}
	}

	/** Parses the file and retreives the number of non-empty lines in the file.
	 *
	 * @param file The file to be parsed
	 * @return The number of non-empty lines in the file.
	 */
	public static int getFileLinesCount(File file) {

		int count = 0;
		Scanner sc = null;
		try {
			// pass the path to the file as a parameter
			sc = new Scanner(file);

			// Check that the scanner has another line of input
			while (sc.hasNextLine()) {
				// Retreive that line
				String s = sc.nextLine();
				// Check whether or not that line is equal to an empty string (empty line)
				if (!s.equals("")) // If not
					count++; // Increment the counter
			}

		} catch (FileNotFoundException e) { // Catch the file not being found
			e.printStackTrace(); // Print the stack trace (should not be executed)
		}
		return count;
	}

	/** Executes one provided line of pseudocode
	 * <br/>
	 * Please note the following valid commands
	 * <br/>
	 * <ul>
	 *   insert pos type sequence
	 * 	 remove pos
	 * 	 print
	 * 	 print pos
	 * 	 clip pos start end
	 * 	 copy pos1 pos2 
	 * 	 transcribe pos1
	 * </ul>
	 *
	 * @param pseudocode A line of pseudocode to be executed
	 */
	static void execute(String pseudocode) {
		// Trip the outside white spaces
		pseudocode = pseudocode.trim();
		// Split the code by it's spaces
		String[] pseudoList = pseudocode.split("\\s+");

		printArray(pseudoList);
		/* Handle the executions */

		if (pseudoList[0].equals("insert")) {
			// Parse the position (next element)
			int pos = Integer.parseInt(pseudoList[1]);
			// Parse the type (next element)
			Type t = Type.fromString(pseudoList[2]);
			// Check for another input (element)
			if (pseudoList[3] != null) {
				// Parse the sequence (next element)
				char[] seq = pseudoList[3].toCharArray();
				//prl("\nInserting new element into pos " + pos + " with value ");printArray(seq);
				// Insert element into vault
				vault.insert(pos,t,seq);

			} else {
				//prl("\nInserting new element into pos " + pos + " with null value");
				// Insert empty element into vault
				vault.insert(pos,t,null);
			}

		} else if (pseudoList[0].equals("remove")) {
			// Parse the position (next element)
			int pos = Integer.parseInt(pseudoList[1]);
			// remove element from vault
			vault.remove(pos);
		} else if (pseudoList[0].equals("print")) {

			// Check if there is another input (position)
			if (pseudoList.length > 1 && pseudoList[1] != null) {
				// Parse the position (next element)
				int pos = Integer.parseInt(pseudoList[1]);
				// Check that pos is valid
				if (vault.sequences[pos] != null)
					// print element from vault
					vault.printPos(pos);
				else
					prl("\nInvalid position specified: exceeds sequence list length!");
			} else {
				// print vault contents (array)
				vault.print();
			}
		} else if (pseudoList[0].equals("clip")) {
			// Parse the position (next element)
			int pos = Integer.parseInt(pseudoList[1]);
			// Parse the start (next element)
			int start = Integer.parseInt(pseudoList[2]);
			// Parse the end (next element)
			int end = Integer.parseInt(pseudoList[3]);
			// Clip vault array at position pos
			vault.clip(pos, start, end);

		} else if (pseudoList[0].equals("copy")) {
			prl("copying..");
			// Parse the first position (next element)
			int pos1 = Integer.parseInt(pseudoList[1]);
			// Parse the second position (next element)
			int pos2 = Integer.parseInt(pseudoList[2]);
			prl("doing copy w " + pos1 + " " + pos2);
			// Copy element in vault array to another position in vault array
			vault.copy(pos1, pos2);

		} else if (pseudoList[0].equals("transcribe")) {
			// Parse the position (next element)
			int pos = Integer.parseInt(pseudoList[1]);
			// Transcribe vault array at position pos
			vault.transcribe(pos);

		}
		prl("\n");
	}

	/** Convenience method that prints input
	 *
	 * @param e input to be printed
	 */
	public static <E> void pr(E e) {
		System.out.print(e);
	}

	/** Convenience method that prints input
	 *
	 * @param s input to be printed
	 */
	static public void pr(String s) {
		System.out.print(s);
	}

	/** Convenience method that prints input
	 *
	 * @param i input to be printed
	 */
	static public void pr(int i) {
		System.out.print(i);
	}

	/** Convenience method that prints input
	 *
	 * @param e input to be printed
	 */
	static public <E> void prl(E e) {
		System.out.println(e);
	}

	/** Convenience method that prints input
	 *
	 * @param s input to be printed
	 */
	static public void prl(String s) {
		System.out.println(s);
	}

	/** Convenience method that prints input
	 *
	 * @param i input to be printed
	 */
	static public void prl(int i) {
		System.out.println(i);
	}

	/** Convenience method that prints an array
	 *
	 * @param arr input to be printed
	 */
	static public void printArray(String[] arr) {
		for (String s: arr)
			System.out.print(s + " ");
	}

	/** Convenience method that prints an array
	 *
	 * @param arr input to be printed
	 */
	static public void printArray(char[] arr) {
		for (char c: arr)
			System.out.print(c + " ");
	}
}
