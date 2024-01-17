import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		int index = Math.abs(key.hashCode()) % tableSize;

		List<Entry<K,V>> list = table.get(index);
		Iterator<Entry<K,V>> iter = list.iterator();

		while(iter.hasNext()) {
			Entry<K,V> entry = iter.next();

			if(entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		int index = Math.abs(key.hashCode()) % tableSize;

		List<Entry<K,V>> list = table.get(index);
		Iterator<Entry<K,V>> iter = list.iterator();

		while(iter.hasNext()) {
			Entry<K,V> entry = iter.next();
			if(entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		throw new KeyNotFoundException();
	}


	public List<Entry<K,V>>	entryList() {
		// Tip: you will need to iterate through each index in the table (and each index holds a list)
		//      you will THEN need to iterate through each element in the linked list chain at a 
		//      specific index and add each element to l
		
		List<Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();

		for(int i = 0; i < tableSize; i++) {
			int index = i % tableSize;
			List<Entry<K,V>> list = table.get(index);
			Iterator<Entry<K,V>> iter = list.iterator();

			while(iter.hasNext()) {
				Entry<K,V> entry = iter.next();
				resultList.add(entry);
			}
		}
		return resultList;
	}
	
	public void put (K key, V value){
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		List<Entry<K,V>> list = table.get(index);
		Iterator<Entry<K,V>> iter = list.iterator();

		while(iter.hasNext()) {
			Entry<K, V> entry = iter.next();
			if(entry.getKey().equals(key)) {
				entry.setValue(value);
				return;
			}
		}
		list.add(new Entry<K,V>(key, value));
		count++;
	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}