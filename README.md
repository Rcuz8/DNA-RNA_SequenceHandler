
-----------------
 BACKGROUND INFO
-----------------

Author: RYAN COCUZZO

------
 TASK
------

The task was to create a DNA and RNA sequence storage and manipulation mechanism. 
This was done through the usage of multiple different types of lists for the data
storage and heavily uses ADTs to get the desired result and functionality to 
properly manipulate the lists and sequences.

-------
 FILES
-------

	biol.java - Wrapper class for the DNAList class to match lab specs.
	
	DNAList.java - Handles the inputs and deals out input commands to
		the sequence vault (the load-carrier).
	
	SequenceVault.java - Contains the heavy-lifting code for storing and
		manipulating sequences.
	
	Sequence.java - Contains the physical sequences to be manipulated.
		Also contained some functionality for manipulation.

	Type.java - An enum for DNA/RNA	

	Node.java - Linked List Node

	All other classes/interfaces are simply helpers.
	
	
---------------
 COMPILE & RUN
---------------

	Open terminal on folder. Run the following commands.

	~$ javac biol.java
	
	~$ java biol <array-size> <folder-location>
