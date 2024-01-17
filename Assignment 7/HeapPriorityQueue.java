/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeMin is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected T[] storage;
	protected int currentSize;
	
	// Feel free to change rootIndex to 0 if you want to 
	// use 0-based indexing (either option is fine)
	private static final int rootIndex = 0;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> dataType) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE+1);
		}
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> clazz, int size) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size+1);
		}
		currentSize = 0;
	}

	public void insert (T element) throws HeapFullException {
		if(this.isFull()) {
			throw new HeapFullException();
		}

		else {
			currentSize++;
			storage[currentSize - 1] = element;
			bubbleUp(currentSize - 1);
		}
	}
	
	private void bubbleUp(int index) {
		int parentIndex = (index - 1) / 2;
		T temp;

		if(index != 0) {
			if(storage[parentIndex].compareTo(storage[index]) > 0)  {
				temp = storage[parentIndex];
				storage[parentIndex] = storage[index];
				storage[index] = temp;
				bubbleUp(parentIndex);
			}
		}
	}

	public T removeMin() throws HeapEmptyException {
		if(this.isEmpty()) {
			throw new HeapEmptyException("Heap is already empty");
		}

		T removed = storage[0];

		if(currentSize > 1) {
			storage[0] = storage[currentSize - 1];
			currentSize--;
			bubbleDown(0);
		}
		else {
			currentSize = 0;
		}

		return removed;
	}
	
	private void bubbleDown(int index) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		int minIndex;
		T temp;

		if(rightIndex < currentSize && storage[leftIndex].compareTo(storage[rightIndex]) > 0) {
			minIndex = rightIndex;
		}
		else {
			minIndex = leftIndex;
		}

		if(minIndex < currentSize && storage[index].compareTo(storage[minIndex]) > 0) {
			temp = storage[minIndex];
			storage[minIndex] = storage[index];
			storage[index] = temp;
			bubbleDown(minIndex);
		}
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean isFull() {
		return currentSize >= storage.length;
	}
	
	public int size () {
		return currentSize;
	}
	
	// FOR DEBUGGING:
	public String toString() {
		String s = "";
		String sep = "";
		if (rootIndex == 0) {
			for (int i = 0; i < currentSize; i++) {
				s += sep + storage[i];
				sep = " ";				
			}
		} else if (rootIndex == 1) {
			for(int i=1; i<=currentSize; i++) {
				s += sep + storage[i];
				sep = " ";
			}
		}
		return s;
	}
}
