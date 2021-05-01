
/* my array list: an array that behaves like a list 
 * E/16/083
 */

public class MySet<T/* Can we have any T */> {

	int nextItem; // position
	int currentCapacity; // field to store the size of the array
	T[] data; // DO NOT CHANGE

	private static int defaultSizeToCreate = 10; // how many elements to create

	@SuppressWarnings("unchecked")
	public MySet(int elements) {
		this.nextItem = 0;
		defaultSizeToCreate = elements;		//static removes this
		this.currentCapacity = elements;

		this.data = (T[]) new Object[defaultSizeToCreate];	//static removes this
	}

	public MySet() {
		this(defaultSizeToCreate);
	}

	public boolean isEmpty() {
		return this.nextItem == 0;
	}

	public boolean isFull() {
		// return false; /* never get filled */
		return nextItem == currentCapacity - 1;
	}
	@SuppressWarnings("unchecked")
	private void newArray() {

		int newSize = currentCapacity + defaultSizeToCreate;
		T[] newData = (T[]) new Object[newSize];
		for (int i = 0; i < this.currentCapacity; i++) {
			newData[i] = this.data[i];
		}
		currentCapacity = newSize;
		data = newData;

	}
	public boolean add(T item) {
		// check the item already exists
		for (int i = 0; i < nextItem; i++) {
			if (data[i].equals(item)) {
				return false; // item not added
			}
		}

		if (isFull()) {
			// crate a new array with currentCapacity+defaultSizeToCreate
			newArray();
		}
		/* Add the item to the array */
		data[nextItem++] = item;

    		try 
    		{    	
    			data[nextItem] = null;// DO NOT CHANGE
    		}
    		catch(ArrayIndexOutOfBoundsException e){
				// System.out.println(e);
			};
    		return true;

	}

	public T remove() {
		/*
		 * remove the first element in the array and copy the rest front. FIFO
		 * structure. If the ArrayList is empty return null
		 */
		T st;
		/* Option 1: */
		if (isEmpty()) {
			return null;
		} else {
			st = data[0];
			int i = 0;
			while (data[i] != null && i < currentCapacity - 1) {
				data[i] = data[i + 1];
				i += 1;
			}
			data[i] = null;
			return st;
		}

		/* Option 2: */
		// if (!isEmpty()) {
		// 	st = data[0];
		// 	int i = 0;
		// 	while (data[i] != null && i < currentCapacity - 1) {
		// 		data[i] = data[i + 1];
		// 		i += 1;
		// 	}
		// 	data[i] = null;
		// 	return st;
		// }
		// return null;

		// which option is better? why?
	}

}
