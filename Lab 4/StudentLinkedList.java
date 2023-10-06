public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		StudentNode newStudent = new StudentNode(s, null);
		count++;

		if(head == null) {
			head = newStudent;
		}

		else {
			StudentNode cur = head;

			while(cur.getNext() != null) {
				cur = cur.getNext();
			}

			cur.setNext(newStudent);
		}
	}

	public int size() {
		return count;
	}

	public void removeFront() {
		if(head != null) {
			head = head.getNext();
			count--;
		}
	}

	public boolean contains(Student s) {
		for(StudentNode cur = head; cur != null; cur = cur.getNext()) {
			if(cur.getData().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
