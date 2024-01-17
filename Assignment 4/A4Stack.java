public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}

	public void push(T value) {
	 	A4Node<T> newValue = new A4Node<>(value);

	 	newValue.setNext(head);

	 	head = newValue;
	}

	public T pop() {
		if(isEmpty()) {
			return null;
		}

		else {
			T result = head.getData();
			head = head.getNext();
			return result;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T top() {
		if(isEmpty()) {
			return null;
		}

		else {
			return head.getData();
		}
	}

	public void popAll() {
		head = null;
	}

}