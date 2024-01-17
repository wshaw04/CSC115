
public class A4Tester {

	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main(String[] args) {
		testStackOperations();
		testStackIsGeneric();
		testStackedCorrectly();
		testInsertPlate();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testStackOperations() {
		System.out.println("Stack Operations Tests:");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		int result = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(2);
		result = testStack.top();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result==2, "top works after initial push");
		
		testStack.push(4);
		testStack.pop();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result == 2, "pop works");

		testStack.pop();
		displayResults(true == testStack.isEmpty(), "stack is empty");

		testStack.push(4);
		testStack.push(5);
		testStack.push(29);
		testStack.push(43);
		testStack.popAll();
		displayResults(testStack.isEmpty(), "stack is empty");

		System.out.println();
	}
	
	public static void testStackIsGeneric() {
		System.out.println("Stack Generics Tests:");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		A4Stack<Integer> s4 = new A4Stack<Integer>();
		
		int result1;
		String result2;
		double result3;
		Integer result4;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);

		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();		
		displayResults(result1==8, "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3==9.1, "Double Stack");		
		
		result1 = s1.top();
		result2 = s2.top();
		result3 = s3.top();
		result4 = s4.pop();
		
		displayResults(result1==3, "Integer Stack");
		displayResults(result2.equals("CSC"), "String Stack");
		displayResults(result3==5.5, "Double Stack");

		displayResults(result4 == null, "empty integer stack");
		
		System.out.println();
	}

	public static void testStackedCorrectly() {
		System.out.println("Testing stackedCorrectly");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s3 = new A4Stack<Plate>();
		A4Stack<Plate> s4 = new A4Stack<Plate>();

		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);
		
		s2.push(p1);
		s2.push(p4);

		s3.push(p5);
		s3.push(p3);
		s3.push(p3);
		s3.push(p1);

		s4.push(p2);
		s4.push(p2);


		
		boolean result = false;
		
		result = A4Exercises.stackedCorrectly(s1);
		displayResults(result, "s1 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s2);
		displayResults(!result, "s2 stacked correctly");
		
		result = A4Exercises.stackedCorrectly(s3);
		displayResults(!result, "s3 stacked correctly");

		result = A4Exercises.stackedCorrectly(s4);
		displayResults(result, "s4 stacked correctly");
		
		System.out.println();
	}

	public static void testInsertPlate() {
		System.out.println("Testing insertPlate");
		Plate p1 = new Plate(5);
		Plate p2 = new Plate(12);
		Plate p3 = new Plate(1);
		Plate p4 = new Plate(8);
		Plate p5 = new Plate(3);
		Plate p6 = new Plate(10);
		Plate p7 = new Plate(15);
		Plate p8 = new Plate(2);
		Plate p9 = new Plate(7);
		
		Plate insert = new Plate(6);
		Plate insert2 = new Plate(12);
		Plate insert3 = new Plate(5);
		
		A4Stack<Plate> s1 = new A4Stack<Plate>();
		A4Stack<Plate> s2 = new A4Stack<Plate>();
		A4Stack<Plate> s3 = new A4Stack<Plate>();
		A4Stack<Plate> s4 = new A4Stack<Plate>();
		A4Stack<Plate> s5 = new A4Stack<Plate>();
		
		s1.push(p2);
		s1.push(p4);
		s1.push(p1);
		s1.push(p5);
		s1.push(p3);

		s2.push(p5);
		s2.push(p2);
			
		s3.push(p2);
		s3.push(p4);
		s3.push(p1);
		s3.push(p5);
		s3.push(p3);	

		s4.push(p6);
		s4.push(p7);
		
		A4Exercises.insertPlate(s1, insert);
		displayResults(A4Exercises.stackedCorrectly(s1), "insert into empty stack");

		A4Exercises.insertPlate(s2, insert);
		displayResults(A4Exercises.stackedCorrectly(s2), "not stacked correctly");
		
		A4Exercises.insertPlate(s3, insert);
		displayResults(A4Exercises.stackedCorrectly(s3), "insert into correctly stacked stack");

		A4Exercises.insertPlate(s4, insert2);
		displayResults(A4Exercises.stackedCorrectly(s4), "insert into stack with one larger plate above");

		A4Exercises.insertPlate(s5, insert3);
		displayResults(A4Exercises.stackedCorrectly(s5), "insert into stack with one smaller plate below");

	}

	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}