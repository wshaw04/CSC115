/*
* Lab7Tester.java
*/
public class Lab7Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main (String[] args) {
		try {
			testBasicStack();
			testStackUseFunctions();
			testQueue();
		} catch (Exception e) {
			System.out.println("Your code threw an Exception.");
			System.out.println("Perhaps a stack trace will help:");
			e.printStackTrace(System.out);
		}
		System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
	}

	public static void testBasicStack() {
		
		System.out.println("testBasicStack: start");
		
		Stack s;
		int subtestSize;
		boolean subtestResult;
		
		s = new StackArrayBased();
		displayResults(s.isEmpty(), "isEmpty on empty stack");
		displayResults(s.size() == 0, "size on empty stack");
		
		s = new StackArrayBased();
		s.push('a');
		displayResults(!s.isEmpty(), "isEmpty - stack with one element");
		displayResults(s.size() == 1, "size - stack with one element");
		
		
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "isEmpty - stack with multiple elements");
		displayResults(s.size() == subtestSize, "size - stack with multiple elements");
		try {
			subtestResult = true;
			for (int i = subtestSize - 1; i >= 0; i--) {
				char ii = s.pop();
				subtestResult = subtestResult && (ii == (char)(i+'0'));
			}
			displayResults(subtestResult, "pop - stack with multiple elements");
			displayResults(s.isEmpty(), "isEmpty - after pop");
			displayResults(s.size() == 0, "size - after pop");
		}
		catch (StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't be");
		}
		
		
		s = new StackArrayBased();
		s.push('b');
		try {
			s.peek();
			displayResults(true, "exception not thrown when it shouldn't be");
		}
		catch (StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't be");
		}
		displayResults( !s.isEmpty(), "push/peek + isEmpty - stack with one elements");
		displayResults(s.size() == 1, "push/peek + size - stack with one elements");
		
		
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "push + isEmpty");
		displayResults(s.size() == subtestSize, "push + size");
		subtestResult = true;
		try {
			for (int i = subtestSize - 1; i >= 0; i--) {
				char ii = s.peek();
				subtestResult = subtestResult && (ii == (char)((subtestSize - 1) + '0'));
			}
			displayResults(subtestResult, "push + peek");
			displayResults(!s.isEmpty(), "push + peek + isEmpty");
			displayResults(s.size() == subtestSize, "push + peek + size");
		}
		catch (StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't be");
		}
		
		
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.makeEmpty();
		displayResults(s.isEmpty(), "makeEmpty + isEmpty - stack with multiple elements");
		
		
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.makeEmpty();
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		displayResults(!s.isEmpty(), "makeEmpty + push + isEmpty - stack with multiple elements");
		displayResults(s.size() == subtestSize, "makeEmpty + push + size - stack with multiple elements");
		
		
		s = new StackArrayBased();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		s.makeEmpty();
		for (int i = 0; i < subtestSize; i++) {
			s.push((char)(i+'0'));
		}
		
		try {
			displayResults(s.peek() == (char)((subtestSize - 1) + '0'), "makeEmpty + push + peek - stack with multiple elements");
			s.pop();
			displayResults(s.peek() == (char)((subtestSize - 2) + '0'), "makeEmpty + push + pop + peek - stack with multiple elements");
		}
		catch (StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't be");
		}
		
		try {
			Stack k = new StackArrayBased();
			k.pop(); //pop from empty stack
			displayResults(false, "exception thrown when it should not be"); //should not reach here
		}
		catch (StackEmptyException see) {
			displayResults(true, "exception thrown when it should be"); //should reach here
		}

		try {
			Stack k = new StackArrayBased();
			k.push('a');
			k.pop();
			displayResults(true, "exception not thrown when it shouldn't");
		}
		catch(StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		try {
			Stack k = new StackArrayBased();
			k.peek();
			displayResults(false, "exception not thrown when it should");
		}
		catch(StackEmptyException see) {
			displayResults(true, "exception thrown when it should");
		}

		try {
			Stack k = new StackArrayBased();
			k.push('s');
			k.peek();
			displayResults(true, "exception not thrown when it shouldn't");
		}
		catch(StackEmptyException see) {
			displayResults(false, "exception thrown when it shouldn't");
		}
		
		System.out.println("testBasicStack: end");
		System.out.println();
	}

	/*
	 * Purpose: reverses str following this algorithm
	 *  - pushes each character in str onto a new StackArrayBased,
	 *  - creates a new empty result String
	 *  - pops each character off the Stack adding it to the result String
	 *  - returns the result String
	 * Parameters: String str - the String to reverse
	 * Returns: String - the reversed result String
	 */
	public static String reverseString(String str) {
		String result = "";
		Stack stk = new StackArrayBased();
		for(int i = 0; i < str.length(); i++) {
			stk.push(str.charAt(i));
		}

		try {
			while (!stk.isEmpty()) {
				result +=stk.pop();
			}
		}
		catch(StackEmptyException see) {
		//continue & return the result (empty string)
		}	

		return result;
	}

	/*
	 * Purpose: determines whether every '(' bracket
	 *          in str is matched with a ')'
	 * Parameters: String str - the String check
	 * Returns: boolean - true if brackets are matched, false otherwise
	 */
	public static boolean doBracketsMatch(String str) {
		Stack stk = new StackArrayBased();
		char c = ' ';
		char popped = ' ';
		try {
			for(int i=0; i<str.length(); i++) {
				c = str.charAt(i);
				if (c == '(') {
					stk.push(c);
				} else if (c == ')') {
					if (stk.isEmpty()) {
						return false;
					} else {
						popped = stk.pop();
					}
				}
			}
		}

		catch(StackEmptyException see) {
			return false; //since there are no brackets, they cannot match
		}

		return true;
	}

	public static void testStackUseFunctions() {
		System.out.println("testStackUseFunctions: start");
		System.out.println("Testing reverseString");
		String resultString;
		String expected;
		
		resultString = reverseString("");
		expected = "";
		displayResults(resultString.equals(expected), "reverse empty String");
		
		resultString = reverseString("abc");
		expected = "cba";
		displayResults(resultString.equals(expected), "reverse \"abc\"");
		
		System.out.println("Testing doBracketsMatch");
		boolean matched;
		matched = doBracketsMatch("");
		displayResults(matched, "doBracketsMatch empty String");
		
		matched = doBracketsMatch("(abc)");
		displayResults(matched, "doBracketsMatch \"(abc)\"");
		
		matched = doBracketsMatch("(a(bc))");
		displayResults(matched, "doBracketsMatch \"(a(bc))\"");
		
		matched = doBracketsMatch("(lm(def)))");
		displayResults(!matched, "doBracketsMatch \"(lm(def)))\"");
	 
		matched = doBracketsMatch("k(lmn)ab)");
		displayResults(!matched, "doBracketsMatch \"k(lmn)ab)\"");
		
		System.out.println("testStackUseFunctions: end");
		System.out.println();
	}


	public static void testQueue() {
		System.out.println("testBasicQueue: start");
		
		Queue<Integer> q;
		int subtestSize;
		boolean subtestResult;
		
		q = new QueueRefBased<Integer>();
		displayResults(q.isEmpty(), "isEmpty on empty queue");
		displayResults(q.size() == 0, "size on empty queue");
		
		q = new QueueRefBased<Integer>();
		q.enqueue(10);
		displayResults(!q.isEmpty(), "isEmpty - queue with one element");
		displayResults(q.size() == 1, "size - queue with one element");

		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		displayResults(!q.isEmpty(), "isEmpty - queue with multiple elements");
		displayResults(q.size() == subtestSize, "size - queue with multiple elements");
		
		subtestResult = true;
		try {
			for (int i = 0; i < subtestSize; i++) {
				int ii = q.dequeue();
				subtestResult = subtestResult && (ii == i);
			}
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		displayResults(subtestResult, "dequeue - queue with multiple elements");
		displayResults(q.isEmpty(), "isEmpty - after dequeue");
		displayResults(q.size() == 0, "size - after dequeue");



		q = new QueueRefBased<Integer>();
		q.enqueue(10);
		try {
			q.peek();
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		displayResults( !q.isEmpty(), "enqueue/dequeue + isEmpty - queue with one elements");
		displayResults(q.size() == 1, "enqueue/dequeue + size - queue with one elements");



		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		displayResults(!q.isEmpty(), "enqueue + isEmpty");
		displayResults(q.size() == subtestSize, "enqueue + size");
		subtestResult = true;
		try {
			for (int i = 0; i<subtestSize; i++) {
				int ii = q.peek();
				subtestResult = subtestResult && (ii == 0);
			}
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		displayResults(subtestResult, "enqueue + peek");
		displayResults(!q.isEmpty(), "enqueue + peek + isEmpty");
		displayResults(q.size() == subtestSize, "enqueue + peek + size");

		
		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		q.makeEmpty();
		displayResults( q.isEmpty(), "makeEmpty + isEmpty - queue with multiple elements");
		
		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		q.makeEmpty();
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		displayResults(!q.isEmpty(), "makeEmpty + enqueue + isEmpty - queue with multiple elements");
		displayResults(q.size() == subtestSize, "makeEmpty + enqueue + size - queue with multiple elements");
		

		q = new QueueRefBased<Integer>();
		subtestSize = 10;
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}
		q.makeEmpty();
		for (int i = 0; i < subtestSize; i++) {
			q.enqueue(i);
		}

		try {
			displayResults(q.peek() == 0, "makeEmpty + enqueue + peek - queue with multiple elements");
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		try {
			q.dequeue();
		}
		catch(QueueEmptyException qee) {
			displayResults(true, "exception thrown when it should");
		}

		try {
			displayResults(q.peek() == 1, "makeEmpty + enqueue + dequeue + peek - queue with multiple elements");
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}


		try {
			q = new QueueRefBased<Integer>();
			q.dequeue();          // do something that you know will throw an exception        
			displayResults(false, "exception thrown when it should not be"); // we should not get here - test passes
		} 
		catch (QueueEmptyException qee) {
			displayResults(true, "exception thrown when it should be"); //should get here
		}

		try {
			q = new QueueRefBased<Integer>();
			q.enqueue(1);
			q.peek();
			displayResults(true, "exception not thrown when it shouldn't");
		}
		catch(QueueEmptyException qee) {
			displayResults(false, "exception thrown when it shouldn't");
		}

		try {
			q = new QueueRefBased<Integer>();
			q.peek();
			displayResults(false, "exception not thrown when it should");
		}
		catch(QueueEmptyException qee) {
			displayResults(true, "exception thrown when it should");
		}
			
			System.out.println("testing Queue: end");
			System.out.println();
			
		}

	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}    
}
