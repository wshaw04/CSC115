public interface Queue<T> {
	
	/*
	 * Purpose: get the number of items currently in the queue.
	 * Parameters: none
	 * Returns: int - the number of items in the queue
	 */
	int size();

	/*
	 * Purpose: determines whether the queue is empty
	 * Parameters: none
	 * Returns: boolean - true if queue is empty, false otherwise
	 */
	boolean isEmpty();

	/*
	 * Purpose: insert the value onto the back of the queue
	 * Parameters: int value - the value to insert
	 * Returns: void - nothing
	 *
	 * Examples:
	 *	If q is {x, y, z}:
	 *   then after q.enqueue(a), q is {x, y, z, a} (the front 
	 *   of the queue is the left-most value in the sequence, 
	 *   back of the queue is the right-most value in the sequence)
	 *
	 *  If q is {}: then after enqueue(a), q is {a}.
	 */
	void enqueue (T value);

	/*
	 * Purpose: remove and return the value from the front of queue
	 * Parameters: none
	 * Returns: int - the value removed from the front of the queue
	 * Throws: QueueEmptyException - if the queue is empty
	 *
	 * Examples:
	 *  If q is {x, y, z}:
	 *   then after q.dequeue(), q is {y, z} and x is returned 
	 */
	T dequeue() throws EmptyQueueException;

	/*
	 * Purpose: gets the value at the front of the queue
	 * Parameters: none
	 * Returns: int - the value at the front of the queue
	 * Throws: QueueEmptyException - if the queue is empty
	 *
	 * Examples:
	 *  If q is {x, y, z}:
	 *   then after q.peek(), q is {x, y, z} and x is returned
	 */
	T peek() throws EmptyQueueException;

	/*
	 * Purpose: clears the queue of all its content.
	 * Parameters: none
	 * Returns: void - nothing
	 *
	 * Examples:
	 *  If q is {x, y, z}
	 *   then after q.dequeueAll(), q is {}.
	 *  If q is {}:
	 *   then after q.dequeueAll(), q is {}.
	 */
	void dequeueAll();
}

