
/*
 * A1Tester
 * A class to test the methods in Assignment 1
 */
public class A1Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main(String[] args) {

		// PART 1 - variables, methods, ifs, and loops

		/* I have correctly implemented the first two methods for you. 
		 * Read through the tests and look at the implementation
		 * in the A1Exercises.java file to get an idea of what is expected
		 * for the other parts of the assignment you will complete yourself
		 */
		testIsFactor();
		testCalcPower();

		testNumFactors();

		testIsPrime();

		testGreatestCommonDenominator();



		// PART 2 - arrays

		/* Some examples to demonstrate how to intialize and test arrays. 
		 * The printArrays method have been completed for you.
		 */
		printArrayExample();
		testSumArray();

		testContains();
		testCountMatches();

	}
	
	public static void testIsFactor() {
		boolean result = false;
		boolean expected = false;
		
		System.out.println("Testing isFactor(3,3)");
		result = A1Exercises.isFactor(3, 3);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing isFactor(3,2)");
		result = A1Exercises.isFactor(3, 2);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing isFactor(8,2)");
		result = A1Exercises.isFactor(8, 2);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing isFactor(42,5)");
		result = A1Exercises.isFactor(42, 5);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing isFactor(102,17)");
		result = A1Exercises.isFactor(102, 17);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}
	
	public static void testCalcPower() {
		int result = 0;
		int expected = 0;
		
		System.out.println("Testing calcPower(2,0)");
		result = A1Exercises.calcPower(2, 0);
		expected = 1;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing calcPower(2,3)");
		result = A1Exercises.calcPower(2, 3);
		expected = 2*2*2;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing calcPower(5,4)");
		result = A1Exercises.calcPower(5, 4);
		expected = 5*5*5*5;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing calcPower(13,2)");
		result = A1Exercises.calcPower(13, 2);
		expected = 13*13;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}
	
	public static void testNumFactors() {
		int result = 0;
		int expected = 0;
		
		System.out.println("Testing numFactors(1)");
		result = A1Exercises.numFactors(1);
		expected = 1;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing numFactors(6)");
		result = A1Exercises.numFactors(6);
		expected = 4; // There are 4 factors of 6: 1, 2, 3, and 6
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing numFactors(24)");
		result = A1Exercises.numFactors(24);
		expected = 8; // There are 8 factors of 24: 1,2,3,4,6,8,12,24
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing numFactors(51)");
		result = A1Exercises.numFactors(51);
		expected = 4; // There are 4 factors of 51: 1,3,17,51
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}
	
	public static void testIsPrime() {
		boolean result = false;
		boolean expected = false;

		System.out.println("Testing isPrime(2)");
		result = A1Exercises.isPrime(2);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing isPrime(6)");
		result = A1Exercises.isPrime(6);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing isPrime(11)");
		result = A1Exercises.isPrime(11);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing isPrime(15)");
		result = A1Exercises.isPrime(15);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing isPrime(1046527)");
		result = A1Exercises.isPrime(1046527);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing isPrime(1046529)");
		result = A1Exercises.isPrime(1046529);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

	}
	
	public static void testGreatestCommonDenominator() {
		int result = 0;
		int expected = 0;

		System.out.println("Testing greatestCommonDenominator(1, 1)");
		result = A1Exercises.greatestCommonDenominator(1, 1);
		expected = 1;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing greatestCommonDenominator(5, 100)");
		result = A1Exercises.greatestCommonDenominator(5, 100);
		expected = 5;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing greatestCommonDenominator(27, 10356)");
		result = A1Exercises.greatestCommonDenominator(27, 10356);
		expected = 3;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing greatestCommonDenominator(91, 13)");
		result = A1Exercises.greatestCommonDenominator(91, 13);
		expected = 13;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing greatestCommonDenominator(43, 9)");
		result = A1Exercises.greatestCommonDenominator(43, 9);
		expected = 1;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}
	
	public static void printArrayExample() {
		int[] array0 = {};
		int[] array1 = {8};
		int[] array2 = {2, 3, 2, 0};
		int[] array3 = {-1, 2, 4, 1, 3};

		System.out.println("Printing arrays example:");
		
		A1Exercises.printArray(array0);
		A1Exercises.printArray(array1);
		A1Exercises.printArray(array2);
		A1Exercises.printArray(array3);
	}
	
	public static void testSumArray() {
		int result = 0;
		int expected = 0;
		int[] array0 = {};
		int[] array1 = {8};
		int[] array2 = {2, 3, 2, 0};
		int[] array3 = {-1, 2, 4, 1, 3};

		System.out.println("Testing sumArray with an empty array");
		result = A1Exercises.sumArray(array0);
		expected = 0;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
		
		System.out.println("Testing sumArray with {8}");
		result = A1Exercises.sumArray(array1);
		expected = 8;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing sumArray with {2, 3, 2, 0}");		
		result = A1Exercises.sumArray(array2);
		expected = 2+3+2;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing sumArray with {-1, 2, 4, 1, 3}");
		result = A1Exercises.sumArray(array3);
		expected = -1+2+4+1+3;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}	
    
	public static void testContains() {
		boolean result = false;
		boolean expected = false;
		int[] arr0 = {};
		int[] arr1 = {2, 3, 2, 0};
		int[] arr2 = {-1, 2, 4, 1, 3};

		System.out.println("Testing contains with an empty array");
		result = A1Exercises.contains(arr0, 2);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr1, 2)");
		result = A1Exercises.contains(arr1, 2);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr1, 0)");
		result = A1Exercises.contains(arr1, 0);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr1, 4)");
		result = A1Exercises.contains(arr1, 4);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr2, 4)");
		result = A1Exercises.contains(arr2, 4);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr2, 3)");
		result = A1Exercises.contains(arr2, 3);
		expected = true;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing contains(arr2, 5)");
		result = A1Exercises.contains(arr2, 5);
		expected = false;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}
	
	public static void testCountMatches() {
		int result = 0;
		int expected = 0;
		int[] arr1 = {2, 3, 2, 0};
		int[] arr2 = {3, 6, 10, 3, 4, 8};
		int[] arr3 = {1, 1, 1, 1, 1, 1, 2};
		int[] arr4 = {4, 78, 23, 345};
		int[] arr5 = {95, -3, 456, 2};

		System.out.println("Testing countMatches(arr1, 1)");
		result = A1Exercises.countMatches(arr1, 1);
		expected = 0;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	
		System.out.println("Testing countMatches(arr2, 3)");
		result = A1Exercises.countMatches(arr2, 3);
		expected = 2;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing countMatches(arr3, 1)");
		result = A1Exercises.countMatches(arr3, 1);
		expected = 6;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);

		System.out.println("Testing countMatches(arr4, 10)");
		result = A1Exercises.countMatches(arr4, 10);
		expected = 0;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);


		System.out.println("Testing countMatches(arr5, -3)");
		result = A1Exercises.countMatches(arr5, -3);
		expected = 1;
		System.out.println("Expected: "+expected);
		System.out.println("Returned: "+result);
	}  
}
