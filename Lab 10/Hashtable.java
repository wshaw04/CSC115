public class Hashtable{
    
private static final int TABLE_SZ = 7; // a prime number

	Student[] table;
	int count;  // number of Students in the table

	public Hashtable() {
		table = new Student[TABLE_SZ];
		count = 0;
	}


	/* MethodName: insertCollisions
	 * Purpose: insert (or update entry) s in this Hashtable with no collision handling strategy
	 * Parameters: Student - s
	 * Throws:  TableFullException - if inserting a new key into a full table
	 *          CollisionException - if inserting a new key into table at index that is full
	 * Returns: nothing
	 */

	public void insertCollisions(Student s) throws TableFullException, CollisionException {
		int index = s.hashCode() % TABLE_SZ;

		if(table[index] == null) {
			table[index] = s;
			count++;
		}
		else {
			if(s.getSID().equals(table[index].getSID())) {
				table[index].setGrade(s.getGrade());
			}
			else {
				if(count == TABLE_SZ) { //if sID does not match
					throw new TableFullException();
				}
				else {
					throw new CollisionException();
				}
			}
		}
	}


	/* MethodName: getCollisions
	 * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getCollisions(String sID) throws KeyNotFoundException {
		int index = sID.hashCode() % TABLE_SZ;

		if(table[index] != null && sID.equals(table[index].getSID())) {
			return table[index].getGrade();
		}
		else {
			throw new KeyNotFoundException();
		}
	}


	/* MethodName: insertLinearProbing
	 * Purpose: insert (or update entry) s in this Hashtable with Linear Probing to handle collisions
	 * Parameters: Student - s
	 * Throws: TableFullException  - if inserting a new key into a full table
	 * Returns: nothing
	 */
	public void insertLinearProbing(Student s) throws TableFullException {
	    int index = s.hashCode() % TABLE_SZ;
	    int probeCount = 0;

	    while(probeCount < TABLE_SZ) {
	        if(table[index] == null || table[index].getSID().equals(s.getSID())) {
	            break;
	        }

	        index = (index + 1) % TABLE_SZ;
	        probeCount++;
	    }

	    if(probeCount == TABLE_SZ) {
	        throw new TableFullException();
	    }

	    if(table[index] == null) {
	        table[index] = s;
	        count++;
	    }
	    else {
	        table[index] = s;
	    }
	}


	/* getLinearProbing
	 * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getLinearProbing(String sID) throws KeyNotFoundException {
		int index = sID.hashCode() % TABLE_SZ;
		int probeCount = 0;

		while(probeCount < TABLE_SZ) {
			if(table[index] == null) {
				break;
			}

			if(sID.equals(table[index].getSID())) {
				return table[index].getGrade();
			}
		index = (index + 1) % TABLE_SZ;
		probeCount++;
		}
		
	throw new KeyNotFoundException();
	}

	/*
	 * Purpose: returns the number of elements in this Hashtable
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this Hashtable separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<TABLE_SZ; i++) {
			if (table[i] != null) {
				s  += table[i] + "\n";
			}
		}
		
		return s;
	}
    

}
