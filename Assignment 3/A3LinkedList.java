// Name: William Shaw
// Student number: V01012421

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node newNode = new A3Node(s);
		length++;

		if(head == null) {
			head = newNode;
			tail = newNode;
		}

		else {
			newNode.setNext(head);
			newNode.setPrev(null);
			head.setPrev(newNode);
			head = newNode;
		}

	}

	public void addBack(String s) {
		A3Node newNode = new A3Node(s);
		length++;

		if(tail == null) {
			head = newNode;
			tail = newNode;
		}

		else {
			newNode.setNext(null);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void removeFront() {
		if(head != null) {
			if(head.getNext() == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.getNext();
				head.getPrev().setNext(null);
				head.setPrev(null);
				length--;
			}
		}
		else {
			return;
		}
	}
	
	public void removeBack() {
		if(tail != null) {
			if(tail == head) {
				tail = null;
				head = null;
				length = 0;
			}
			else {
				tail = tail.getPrev();
				tail.getNext().setPrev(null);
				tail.setNext(null);
				length--;
			}
		}
		else {
			return;
		}
	}
	
	public void insertInto(String s) {
	    A3Node newNode = new A3Node(s);
	    length++;

	    if(head == null) {
	        head = newNode;
	        tail = newNode;
	    }

	    else {
	        A3Node cur = head;
	        A3Node prev = null;

	        while(cur != null && s.compareTo(cur.getData()) >= 0) {
	            prev = cur;
	            cur = cur.getNext();
	        }

	        if(prev == null) {
	            newNode.setNext(head);
	            newNode.setPrev(null);
	            head.setPrev(newNode);
	            head = newNode;
	        }

	        else {
	            newNode.setPrev(prev);
	            newNode.setNext(cur);
	            prev.setNext(newNode);
	        }
	    }

	    tail = newNode;
	}


	public void rotate(int n) {
	    if(n <= 0 || head == null || head == tail) 
	        return;
	   
	    for (int i = 0; i < n; i++) {
	        A3Node cur = tail;
	        tail = tail.getPrev();
	        tail.setNext(null);
	        cur.setNext(head);
	        cur.setPrev(null);
	        head.setPrev(cur);
	        head = cur;
	    }
	}

	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	