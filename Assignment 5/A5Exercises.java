public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get the sum of the even values in the array
	 * Parameters: int[] arr
	 * Returns: int - the sum number of even-valued elements
	 * Post-condition - the array contents are unchanged
	 */
	public static int sumEven(int[] arr) {
		return sumEvenHelper(arr, 0, 0);
	}

	private static int sumEvenHelper(int[] arr, int index, int sum) {
		if(arr.length == 0 || index == arr.length) {
			return sum;
		}
		else if(arr[index] % 2 == 0) {
			sum += arr[index];
		}

		return sumEvenHelper(arr, index + 1, sum);
	}
	
	/*
	 * Purpose: add x to all values in the given array
	 * Parameters: int[] array - the array to modify
	 *             int x - the value to add to all elements
	 * Returns: void - nothing
	 */
	public static void addXToAll(int[] array, int x) {
		addXToAllHelper(array, x, 0);
	}

	private static void addXToAllHelper(int[] array, int x, int index) {
		if(array.length == 0 || index == array.length) {
			return;
		}
		else {
			array[index] += x;
			addXToAllHelper(array, x, index + 1);
		}
	}
	
	/*
	 * Purpose: get the maximum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - maximum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMaximum(int[] array) {
		return getMaximumHelper(array, 0, 0);
	}

	public static int getMaximumHelper(int[] array, int index, int max) {
		if(array.length == 0) {
			return -1;
		}
		else if(index == array.length) {
			return max;
		}

		if(array[index] > max) {
			max = array[index];
		}

		return getMaximumHelper(array, index + 1, max);
	}
	
	/*
	 * Purpose: determines if there is at least one occurrence of x
	 *          after the occurrence of y in the array
	 * Parameters: int[] array - the array to search
	 *             int x - the value that must come second
	 *             int y - the value that must come first
	 * Returns: boolean - true if there is at least one occurrence
	 *                    of x after the occurrence of y
	 */
	public static boolean comesAfter(int[] array, int x, int y) {
		return comesAfterHelper(array, 0, x, y, false);
	}

	private static boolean comesAfterHelper(int[] array, int index, int x, int y, boolean yFound) {
		if(array.length == 0 || index == array.length) {
			return false;
		}

		if(array[index] == y) {
			yFound = true;
		}

		if(yFound && array[index] == x) {
			return true;
		}

		return comesAfterHelper(array, index + 1, x, y, yFound);

	}

	/////////////
	// PART II //
	/////////////
	
	/*
	 * Purpose: get the total number of beads in s
	 * Parameters: Stack<BeadBox> s - the stack of bead boxes
	 * Returns: int - the total number of beads
	 * Post-condition: s is not modified
	 */
	public static int beadsCount(Stack<BeadBox> s) {
		return beadsCountHelper(s, 0);
	}

	private static int beadsCountHelper(Stack<BeadBox> s, int numberBeads) {
		if(s.isEmpty()) {
			return numberBeads;
		}

		BeadBox box = s.pop();
		numberBeads += box.getNumberBeads();
		int newTotal = beadsCountHelper(s, numberBeads);
		s.push(box);
		return newTotal;
	}

	/*
	 * Purpose: get the total number of bead boxes in s
	 * Parameters: Stack<BeadBox> s - the stack of bead boxes
	 * Returns: int - the total number of bead boxes
	 * Post-condition: s is not modified
	 */
	public static int beadBoxesCount(Stack<BeadBox> s) {
		return beadBoxesCountHelper(s, 0);
	}

	private static int beadBoxesCountHelper(Stack<BeadBox> s, int numBoxes) {
		if(s.isEmpty()) {
			return numBoxes;
		}

		BeadBox box = s.pop();
		int newTotal = beadBoxesCountHelper(s,numBoxes + 1);
		s.push(box);
		return newTotal;

	}
	
	/*
	 * Purpose: get the total weight of all bead boxes
	 * Parameters: Stack<BeadBox> s - the stack of bead boxes
	 * Returns: double - the total weight of all boxes
	 * Post-condition: s is not modified
	 */
	public static double totalWeight(Stack<BeadBox> s) {
		return totalWeightHelper(s, 0.0);
	}

	private static double totalWeightHelper(Stack<BeadBox> s, double weight) {
		if(s.isEmpty()) {
			return weight;
		}

		BeadBox box = s.pop();
		weight += box.boxWeight();
		double newWeight = totalWeightHelper(s, weight);
		s.push(box);
		return newWeight;
	}

	/*
	 * Purpose: get the average weight of the bead boxes in s
	 * Parameters: Stack<BeadBox> s - the stack of bead boxes
	 * Returns: double - the average weight of the bead boxes
	 *                   0.0 if there are no bead boxes in s
	 * Post-condition: s is not modified
	 */
	public static double averageWeight(Stack<BeadBox> s) {
		double totalWeight = totalWeight(s);
		int numberBoxes = beadBoxesCount(s);

		if(numberBoxes == 0) {
			return 0.0;
		}

		return totalWeight / numberBoxes;
	}

	/*
	 * Purpose: determine the bead boxes in s are stacked correctly
	 *          (ie. there is never a bead box stacked on top of 
	 *               another bead box that weighs LESS than it does)
	 * Parameters: Stack<BeadBox> s - the stack of bead boxes
	 * Returns: boolean - true if bead boxes in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<BeadBox> s) {
		return stackedCorrectlyHelper(s, null);
	}

	private static boolean stackedCorrectlyHelper(Stack<BeadBox> s, BeadBox previous) {
		if(s.isEmpty()) {
			return true;
		}

		BeadBox current = s.pop();

		if(previous != null && current.boxWeight() < previous.boxWeight()) {
			s.push(current);
			return false;
		}

		boolean stackedCorrectly = stackedCorrectlyHelper(s, current);
		s.push(current);

		return stackedCorrectly;
	}

}