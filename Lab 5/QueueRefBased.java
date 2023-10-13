public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 0;
		QueueNode current = front;

		while(current != null) {
			count++;
			current = current.getNext();
		}	
		return count;			
	}

	public boolean isEmpty() {
		if(front == null)
			return true;
		else
			return false;
	}

	public void enqueue (int value) {
		QueueNode newElement = new QueueNode(value);

		if(front == null) {
			front = newElement;
			back = newElement;
		}
		else {
			back.setNext(newElement);
			back = newElement;
		}
		back.setNext(null);
	}

	public int dequeue() {
		int removed;

		if(front == null)
			return -1;

		else {
			removed = front.getValue();
			front = front.getNext();
		}

		if(front == null)
			back = null;

		return removed;
	}

	public int peek()  {
		return front.getValue();
	}

	public void makeEmpty() {
		front = null;
		back = null;
	}
}
