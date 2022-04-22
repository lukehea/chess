/**
 * Course: ICS4U
 * Teacher: Mrs. McCaffery
 * Date: November 29, 2021
 * Description: This class file (MDArray.java) completes the arrays tasks, since it hosts a variety of
 * 				basic methods to interact with/use arrays.
 */
package array;

import array.Array;
import java.util.*;

/** 
 * This class, MDArray.java contains a variety of methods to manipulate and operate on multi-dimensional arrays. Methods have been overloaded
 * where possible for working with 2D and 3D arrays of integers, doubles, and strings. 
 * @author Q2 ICS4U Class
 * @since December 2021
 */
public class MDArray 
{	
	/**
	 * Pass a value through a function defined when calling through a parameter.
	 * Since updateVal is implemented for different types, it needs to be created
	 * as a generic type Object. Because of this, the user must manually cast
	 * the return in their lambda function.
	 */
	private interface UpdateFunction
	{
		Object updateVal(Object val);
	}

	/**
	 * Check if two double arrays contain all the same values but do not point to the same memory address
	 * @param arr1   The first array to check
	 * @param arr2   The second array to check
	 * @return true if they have the same elements, false if they do not contain the same elements <i>or</i> point to the same memory address
	 */
	public static boolean checkIfCopy(double[][] arr1, double[][] arr2)
	{
		// Return false if they point to the same memory address
		if (checkIfIdentical(arr1, arr2)) return false;

		// Iterate through the rows and compare each element - if they're not the same, return false
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++) if (arr1[j] != arr2[j]) return false;

		// If it makes it to here, they're a copy so return true
		return true;
	}

	/**
	 * Check if two integer arrays contain all the same values but do not point to the same memory address
	 * @param arr1   The first array to check
	 * @param arr2   The second array to check
	 * @return true if they have the same elements, false if they do not contain the same elements <i>or</i> point to the same memory address
	 */
	public static boolean checkIfCopy(int[][] arr1, int[][] arr2)
	{
		// Return false if they point to the same memory address
		if (checkIfIdentical(arr1, arr2)) return false;

		// Iterate through the rows and compare each element - if they're not the same, return false
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++) if (arr1[j] != arr2[j]) return false;

		// If it makes it to here, they're a copy so return true
		return true;
	}

	/**
	 * Check if two string arrays contain all the same values but do not point to the same memory address
	 * @param arr1   The first array to check
	 * @param arr2   The second array to check
	 * @return true if they have the same elements, false if they do not contain the same elements <i>or</i> point to the same memory address
	 */
	public static boolean checkIfCopy(String[][] arr1, String[][] arr2)
	{
		// Return false if they point to the same memory address
		if (checkIfIdentical(arr1, arr2)) return false;

		// Iterate through the rows and compare each element - if they're not the same, return false
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++) if (!arr1[j].equals(arr2[j])) return false;

		// If it makes it to here, they're a copy so return true
		return true;
	}

	/**
	 * Check if two char arrays contain all the same values but do not point to the same memory address
	 * @param arr1   The first array to check
	 * @param arr2   The second array to check
	 * @return true if they have the same elements, false if they do not contain the same elements <i>or</i> point to the same memory address
	 */
	public static boolean checkIfCopy(char[][] arr1, char[][] arr2)
	{
		// Return false if they point to the same memory address
		if (checkIfIdentical(arr1, arr2)) return false;

		// Iterate through the rows and compare each element - if they're not the same, return false
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++) if (arr1[j] != arr2[j]) return false;

		// If it makes it to here, they're a copy so return true
		return true;
	}

	/**
	 * Check if two double arrays point to the same memory address
	 * @param a   The first array to check
	 * @param b   The second array to check
	 * @return true if they point to the same memory address
	 */
	public static boolean checkIfIdentical(double[][] a, double[][] b)
	{
		return a.equals(b);
	}

	/**
	 * Check if two integer arrays point to the same memory address
	 * @param a   The first array to check
	 * @param b   The second array to check
	 * @return true if they point to the same memory address
	 */
	public static boolean checkIfIdentical(int[][] a, int[][] b)
	{
		return a.equals(b);
	}

	/**
	 * Check if two string arrays point to the same memory address
	 * @param a   The first array to check
	 * @param b   The second array to check
	 * @return true if they point to the same memory address
	 */
	public static boolean checkIfIdentical(String[][] a, String[][] b)
	{
		return a.equals(b);
	}

	/**
	 * Check if two char arrays point to the same memory address
	 * @param a   The first array to check
	 * @param b   The second array to check
	 * @return true if they point to the same memory address
	 */
	public static boolean checkIfIdentical(char[][] a, char[][] b)
	{
		return a.equals(b);
	}

	/**
	 * Make a copy of an integer array without pointing to the same memory address
	 * @param arr   2D multidimentional integer array to copy
	 * @return An identical copy of the array passed in
	 */
	public static int[][] copyArray(int[][] arr)
	{
		// Create a new string array that will be returned to the user
		int[][] returnArray = new int[arr.length][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Make a copy of a double array without pointing to the same memory address
	 * @param arr   2D multidimentional double array to copy
	 * @return An identical copy of the array passed in
	 */
	public static double[][] copyArray(double[][] arr)
	{
		// Create a new string array that will be returned to the user
		double[][] returnArray = new double[arr.length][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Make a copy of an char array without pointing to the same memory address
	 * @param arr   2D multidimentional char array to copy
	 * @return An identical copy of the array passed in
	 */
	public static char[][] copyArray(char[][] arr)
	{
		// Create a new string array that will be returned to the user
		char[][] returnArray = new char[arr.length][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Make a copy of a string array without pointing to the same memory address
	 * @param arr   2D multidimentional string array to copy
	 * @return An identical copy of the array passed in
	 */
	public static String[][] copyArray(String[][] arr)
	{
		// Create a new string array that will be returned to the user
		String[][] returnArray = new String[arr.length][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

  /**
	 * Make a copy of a 3d integer array without pointing to the same memory address
	 * @param arr - 3D multidimentional integer array to copy
	 * @return An identical copy of the array passed in
	 */
	public static int[][][] copyCube(int[][][] arr)
	{
		// Create a new string array that will be returned to the user
		int[][][] returnArray = new int[arr.length][][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = copyArray(arr[i]);
		}

		return returnArray;
	}
	
	/**
	 * Make a copy of a 3d double array without pointing to the same memory address
	 * @param arr - 3D multidimentional integer array to copy
	 * @return An identical copy of the array passed in
	 */
	public static String[][][] copyCube(String[][][] arr)
	{
		// Create a new string array that will be returned to the user
		String[][][] returnArray = new String[arr.length][][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Make a copy of a 3d double array without pointing to the same memory address
	 * @param arr - 3D multidimentional integer array to copy
	 * @return An identical copy of the array passed in
	 */
	public static double[][][] copyCube(double[][][] arr)
	{
		// Create a new string array that will be returned to the user
		double[][][] returnArray = new double[arr.length][][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = copyArray(arr[i]);
		}

		return returnArray;
	}
	
	/**
	 * Make a copy of a 3D char array without pointing to the same memory address
	 * @param arr - 2D multidimentional integer array to copy
	 * @return An identical copy of the array passed in
	 */
	public static char[][][] copyCube(char[][][] arr)
	{
		// Create a new string array that will be returned to the user
		char[][][] returnArray = new char[arr.length][][];

		// Iterate through each row and add the column
		for(int i = 0; i < returnArray.length; i++)
		{
			// Copy the array over
			returnArray[i] = copyArray(arr[i]);
		}

		return returnArray;
	}
  
		/**
	 * counts the number of times a specified element appears in a 2d array
	 * @param array - the array to count from
	 * @param element - the element to count
	 * @return the number of times the element appears in the array
	 */
	public static int countElements (int [][] array, int element) {

		//initialize the count as 0
		int eleCount = 0;

		//start an outer for loop to run through each array in the 2d array
		for (int j = 0;j<array.length;j++) {

			//start an inner for loop to search elements of the inner arrays
			for (int i = 0;i<array[j].length;i++) {

				//if the element of the array at [j][i] is the target element
				if (array[j][i]==element) {

					//increment the element count
					eleCount++;

				}//end if

			}//end inner for

		}//end outer for

		//return the element count
		return eleCount;

	}//end countElements
	
	/**
	 * counts the number of times a specified element appears in a 2d double array
	 * @param array - the array to count from
	 * @param element - the element to count
	 * @return the number of times the element appears in the array
	 */
	public static int countElements (double [][] array, double element) {

		//initialize the count as 0
		int eleCount = 0;

		//start an outer for loop to run through each array in the 2d array
		for (int j = 0;j<array.length;j++) {

			//start an inner for loop to search elements of the inner arrays
			for (int i = 0;i<array[j].length;i++) {

				//if the element of the array at [j][i] is the target element
				if (array[j][i]==element) {

					//increment the element count
					eleCount++;

				}//end if

			}//end inner for

		}//end outer for

		//return the element count
		return eleCount;

	}//end countElements

	/**
	 * counts the number of times a specified element appears in a 2d string array
	 * @param array - the array to count from
	 * @param element - the element to count
	 * @return the number of times the element appears in the array
	 */
	public static int countElements (String [][] array, String element) {

		//initialize the count as 0
		int eleCount = 0;

		//start an outer for loop to run through each array in the 2d array
		for (int j = 0;j<array.length;j++) {

			//start an inner for loop to search elements of the inner arrays
			for (int i = 0;i<array[j].length;i++) {

				//if the element of the array at [j][i] is the target element
				if (array[j][i].equals(element)) {

					//increment the element count
					eleCount++;

				}//end if

			}//end inner for

		}//end outer for

		//return the element count
		return eleCount;

	}//end countElements
	
	/**
	 * counts the number of times a specified element appears in a 2d char array
	 * @param array - the array to count from
	 * @param element - the element to count
	 * @return the number of is3s the element appears in the array
	 */
	public static int countElements (char [][] array, char element) {

		//initialize the count as 0
		int eleCount = 0;

		//start an outer for loop to run through each array in the 2d array
		for (int j = 0;j<array.length;j++) {

			//start an inner for loop to search elements of the inner arrays
			for (int i = 0;i<array[j].length;i++) {

				//if the element of the array at [j][i] is the target element
				if (array[j][i]==(element)) {

					//increment the element count
					eleCount++;

				}//end if

			}//end inner for

		}//end outer for

		//return the element count
		return eleCount;

	}//end countElements
  
	/**
	 * Creates an empty String, MD Array of the amount of rows and columns indicated
	 * @param row    an integer of the amount of rows of the created array
	 * @param col    an integer of the amount of columns of the created array
	 * @return array    empty MD array
	 */
	
	public static String [][] createEmptyString(int row, int col) 
	{
		//creates a new String, MD array of the number of rows and columns indicated & returns it
		String[][]array = new String [row][col];
		return array;
	
	}//ends createEmptyString

	/**
	 * Creates an empty int, MD Array of the amount of rows and columns indicated
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    empty MD array
	 */
	
	public static int [][] createEmptyInt(int row, int col) 
	{
		//creates a new int, MD array of the number of rows and columns indicated & returns it
		int[][]array = new int [row][col];
		return array;
	
	}//ends createEmptyInt

	/**
	 * Creates an empty double, MD Array of the amount of rows and columns indicated
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    empty MD array
	 */
	
	public static double [][] createEmptyDouble(int row, int col) 
	{
		//creates a new double, MD array of the number of rows and columns indicated & returns it
		double[][]array = new double [row][col];
		return array;
	
	}//ends createEmptyDouble

	/** Creates an int, MD Array of the amount of rows and columns indicated with randomly generated integers between the minimum & maximum
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @param min     an integer representing the minimum value of the randomly generated integers
	 * @param max     an integer representing the maximum value of the randomly generated integers
	 * @return array    random MD array
	 */
	
	public static int [][] createRandomInt(int row, int col, int min, int max) 
	{
		//creates a new MD array of the amount of rows and columns indicated
		int[][] array = new int [row][col];
	
		//nested for loop to populate the MD array with randomly generated integers between the minimum & maximum
		for (int i = 0; i < row; i++) 
		{
			for(int j = 0; j < col; j++) 
			{
				array[i][j] = (int) (Math.random()*(max-min+1)) + min;		
	
			}//ends inner for
		}//ends outer for
	
		//returns the array
		return array;
	
	}//ends createRandomInt

	/**
	 * Creates an double, MD Array of the amount of rows and columns indicated  size indicated with randomly generated integers between the minimum & maximimum
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @param min     a double representing the minimum value of the randomly generated doubles
	 * @param max     a double representing the maximum value of the randomly generated doubles
	 * @return array    random MD array
	 */
	
	public static double [][] createRandomDouble(int row, int col, double min, double max) 
	{
		//creates a new MD array of the amount of rows and columns indicated
		double[][]array = new double [row][col];
	
		//initializes the formatter & changes the doubles to only 2 decimal places
		Formatter formatter = new Formatter();
		formatter.format("%.2f", max);
		formatter.format("%.2f", min);
	
		//nested for loop to populate the MD array with randomly generated integers between the minimum & maximimum
		for (int i = 0; i < row; i++) {
			for(int j =0; j < col; j++) {
	
				array[i][j] = (double)(Math.random()*(max-min+1)) + min;	

			}//ends inner for
		}//ends outer for
	
		//returns MD array
		return array;
	
	}//ends createRandomDouble

	/** Creates an user defined String, MD Array of the amount of rows and columns indicated. This MD array populates by row (one row at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static String [][] createUserDefinedStringbyRow(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		String[][] array = new String[row][col];
	
		//asks the user to enter elements by row
		System.out.println("Enter the array elements by row: "); 
	
		//loop to generate the array elements using user input
		for (int i = 0;i < row; i++) 
		{
			for(int j =0; j < col; j++) 
			{
				array [i][j] = myInput.nextLine();
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	} //ends createUserDefinedStringbyRow

	/** Creates an user defined String, MD Array of the amount of rows and columns indicated. This MD array populates by column (one column at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static String [][] createUserDefinedStringbyColumn(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		String[][] array = new String[row][col];
	
		//asks the user to enter elements by column
		System.out.println("Enter the array elements by column: "); 
	
		//loop to generate the array elements using user input
		for (int j = 0;j < col; j++) 
		{
			for(int i =0; i < row; j++) 
			{
				array [i][j] = myInput.nextLine();
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	} //ends createUSerDefinedStringbyColumn

	/** Creates an user defined int, MD Array of the amount of rows and columns indicated. This MD array populates by column (one column at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static int [][] createUserDefinedIntbyColumn(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		int[][] array = new int [row][col];
	
		//asks the user to enter array elements by row
		System.out.println("Enter the array elements by column: "); 
	
		//loop to generate the elements in an MD array
		for (int j = 0; j < col; j++) 
		{
			for(int i = 0; i < row; j++) 
			{
				array [i][j] = myInput.nextInt();
				array[i][j]++;
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	}//ends createUserDefinedIntbyColumn

	/** Creates an user defined int, MD Array of the amount of rows and columns indicated. This MD array populates by row (one row at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static int [][] createUserDefinedIntbyRow(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		int[][] array = new int [row][col];
	
		//asks the user to enter array elements by row
		System.out.println("Enter the array elements by row: "); 
	
		//loop to generate the elements in an MD array
		for (int i = 0; i < row; i++) 
		{
			for(int j = 0; j < col; j++) 
			{
				array [i][j] = myInput.nextInt();
				array[i][j]++;
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	}//ends createUserDefinedIntbyRow

	/** Creates a user defined  double, MD Array of the amount of rows and columns indicated. This MD array populates by column (one column at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static double [][] createUserDefinedDoublebyColumn(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		double[][]array = new double [row][col];
	
		//asks the user to enter array elements by column
		System.out.println("Enter the array elements by column: "); 
	
		//nested loop to generate double values
		for (int j = 0;j < col; j++) 
		{
			for(int i =0; i < row; i++) 
			{
				array [i][j] = myInput.nextDouble();
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	}//ends createUserDefinedDoublebyColumn

	/** Creates a user defined  double, MD Array of the amount of rows and columns indicated. This MD array populates by row (one row at at time)
	 * @param row     an integer of the amount of rows of the created array
	 * @param col     an integer of the amount of columns of the created array
	 * @return array    user defined MD array
	 */
	
	public static double [][] createUserDefinedDoublebyRow(int row, int col) 
	{
		//initializes Scanner & creates a new MD array
		Scanner myInput = new Scanner(System.in);
		double[][]array = new double [row][col];
	
		//asks the user to enter array elements by row
		System.out.println("Enter the array elements by row: "); 
	
		//nested loop to generate double values
		for (int i = 0;i < row; i++) 
		{
			for(int j =0; j < col; j++) 
			{
				array [i][j] = myInput.nextDouble();
	
			}//ends inner loop
		}//ends outer loop
	
		//returns array
		return array;
	
	}//ends createUserDefinedDoublebyRow

	/**
	 * Remove a column from a 2D integer array
	 * @param arr   The array to remove the column from
	 * @param index   The index of the column
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static int[][] deleteColumn(int[][] arr, int index) throws NullPointerException
	{
		int[][] returnArray = new int[arr.length][];

		// Iterate through the rows
		for (int i = 0; i < arr.length; i++)
		{
			boolean indexOk = true;
			if (arr[i].length <= index) indexOk = false;

			// If the index is in bounds, delete it, if it's not just copy the row over
			if (indexOk)
				returnArray[i] = Array.deleteElement(arr[i], index);
			else
				returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Remove a column from a 2D double array
	 * @param arr   The array to remove the column from
	 * @param index   The index of the column
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static double[][] deleteColumn(double[][] arr, int index) throws NullPointerException
	{
		double[][] returnArray = new double[arr.length][];

		// Iterate through the rows
		for (int i = 0; i < arr.length; i++)
		{
			boolean indexOk = true;
			if (arr[i].length <= index) indexOk = false;

			// If the index is in bounds, delete it, if it's not just copy the row over
			if (indexOk)
				returnArray[i] = Array.deleteElement(arr[i], index);
			else
				returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}

	/**
	 * Remove a column from a 2D string array
	 * @param arr   The array to remove the column from
	 * @param index   The index of the column
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static String[][] deleteColumn(String[][] arr, int index) throws NullPointerException
	{
		String[][] returnArray = new String[arr.length][];

		// Iterate through the rows
		for (int i = 0; i < arr.length; i++)
		{
			boolean indexOk = true;
			if (arr[i].length <= index) indexOk = false;

			// If the index is in bounds, delete it, if it's not just copy the row over
			if (indexOk)
				returnArray[i] = Array.deleteElement(arr[i], index);
			else
				returnArray[i] = Array.copyArray(arr[i]);
		}

		return returnArray;
	}
  
  /**
	 * Remove a cube from a 4D integer array
	 * @param arr - The array to remove the grid from
	 * @param index - The index of the grid
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static int[][][][] deleteCube(int[][][][] arr, int index) throws NullPointerException
	{
		int[][][][] returnArr = new int[arr.length - 1][][][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < returnArr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = copyCube(arr[i]);
			else
				returnArr[i-1] = copyCube(arr[i]);
		}

		return returnArr;
	}
  
	/**
	 * Remove a plane from a 3D integer array
	 * @param arr - The array to remove the grid from
	 * @param index - The index of the grid
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static int[][][] deletePlane(int[][][] arr, int index) throws NullPointerException
	{
		int[][][] returnArr = new int[arr.length - 1][][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = copyArray(arr[i]);
			else
				returnArr[i-1] = copyArray(arr[i]);
		}

		return returnArr;
	}

	/**
	 * Remove a plane from a 3D string array
	 * @param arr - The array to remove the grid from
	 * @param index - The index of the grid
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static String[][][] deletePlane(String[][][] arr, int index) throws NullPointerException
	{
		String[][][] returnArr = new String[arr.length - 1][][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = copyArray(arr[i]);
			else
				returnArr[i-1] = copyArray(arr[i]);
		}

		return returnArr;
	}
	
	/**
	 * Remove a plane from a 3D double array
	 * @param arr - The array to remove the grid from
	 * @param index - The index of the grid
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static double[][][] deletePlane(double[][][] arr, int index) throws NullPointerException
	{
		double[][][] returnArr = new double[arr.length - 1][][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = copyArray(arr[i]);
			else
				returnArr[i-1] = copyArray(arr[i]);
		}

		return returnArr;
	}
	
	/**
	 * Remove a plane from a 3D char array
	 * @param arr - The array to remove the grid from
	 * @param index - The index of the grid
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static char[][][] deletePlane(char[][][] arr, int index) throws NullPointerException
	{
		char[][][] returnArr = new char[arr.length - 1][][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = copyArray(arr[i]);
			else
				returnArr[i-1] = copyArray(arr[i]);
		}

		return returnArr;
	}
	
	/**
	 * Remove a row from a 2D integer array
	 * @param arr   The array to remove the row from
	 * @param index   The index of the row
	 * @return the new array
	 * @throws NullPointerExeption
	 */
	public static int[][] deleteRow(int[][] arr, int index) throws NullPointerException
	{
		int[][] returnArr = new int[arr.length - 1][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < returnArr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = Array.copyArray(arr[i]);
			else
				returnArr[i-1] = Array.copyArray(arr[i]);
		}

		return returnArr;
	}

	/**
	 * Remove a row from a 2D integer array
	 * @param arr   The array to remove the row from
	 * @param index   The index of the row
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static double[][] deleteRow(double[][] arr, int index) throws NullPointerException
	{
		double[][] returnArr = new double[arr.length - 1][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = Array.copyArray(arr[i]);
			else
				returnArr[i-1] = Array.copyArray(arr[i]);
		}

		return returnArr;
	}

	/**
	 * Remove a row from a 2D integer array
	 * @param arr   The array to remove the row from
	 * @param index   The index of the row
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static String[][] deleteRow(String[][] arr, int index) throws NullPointerException
	{
		String[][] returnArr = new String[arr.length - 1][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = Array.copyArray(arr[i]);
			else
				returnArr[i-1] = Array.copyArray(arr[i]);
		}

		return returnArr;
	}

	/**
	 * Remove a row from a 2D integer array
	 * @param arr   The array to remove the row from
	 * @param index   The index of the row
	 * @return the new array
	 * @throws NullPointerException
	 */
	public static char[][] deleteRow(char[][] arr, int index) throws NullPointerException
	{
		char[][] returnArr = new char[arr.length - 1][];
		boolean found = false;

		// Iterate through the elements and do not copy over the row at the index
		for (int i = 0; i < arr.length; i++)
		{
			// If we're at the index to remove, mark found as true and continue
			if (i == index) { found = true; continue; }

			// if we haven't found the row to remove yet, copy it over normally
			// if we have found it, copy the element over shifted to the left
			if (!found)
				returnArr[i] = Array.copyArray(arr[i]);
			else
				returnArr[i-1] = Array.copyArray(arr[i]);
		}

		return returnArr;
	}


	/**
	 *	Find the element given the position in the 2D array
	 *	@param array	2D array
	 *	@param row	the pow of the element
	 *	@param col	the column of the element
	 *	@return element		the value in that given row, col
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static double findElement(double[][] array, int row, int col )
	{
		// initializes and gets the element
		double element = 0;
		element = array[row-1][col-1];

		return element;
	} // end findElement

	/**
	 *	Find all of the positions of the element in the 2D array given the element
	 *	@param array - 2D array
	 *	@param element - given value
	 *	@return location[][] - locations of all occurrences of the element returned on each row
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static int[][] findElement(int[][] array, int element)
	{
		// initializes the location integer array	
		int count = 0;
		int location[][] = new int[count][2];

		// loops through the programs to see where the element locates
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				// if element is found
				if(array[row][col] == element)
				{
					// increments count
					count++;

					// creates a new array of new size count
					int newLocation[][] = new int[count][2];

					// copy the original array
					for(int i = 0; i<location.length; i++)
					{
						for(int j = 0; j<location[i].length; j++)
						{
							newLocation[i][j] = location[i][j];
						}
					}

					// add the new locations
					newLocation[count-1][0] = row;
					newLocation[count-1][1] = col;

					// assigns new array to the original one
					location = newLocation;
				}
			} // end for
		} // end for
		return location;
	} // end findElement

	/**
	 *  Find all of the positions of the element in the 2D array given the element
	 *  @param array    2D array
	 *  @param element  given value
	 *  @return location[][]    locations of all occurrences of the element returned on each row
	 *  @throws java.lang.NullPointerException if the given array is null
	 *  @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static int[][] findElement(String[][] array, String element)
	{
		// initializes the location integer array   
		int count = 0;
		int location[][] = new int[count][2];

		// loops through the programs to see where the element locates
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				// if element is found
				if(array[row][col].equals(element))
				{
					// increments count
					count++;

					// creates a new array of new size count
					int newLocation[][] = new int[count][2];

					// copy the original array
					for(int i = 0; i<location.length; i++)
					{
						for(int j = 0; j<location[i].length; j++)
						{
							newLocation[i][j] = location[i][j];
						}
					}

					// add the new locations
					newLocation[count-1][0] = row;
					newLocation[count-1][1] = col;

					// assigns new array to the original one
					location = newLocation;
				}
			} // end for
		} // end for
		return location;
	} // end findElement


	public static int[][] findElement(char[][] array, char element) {
		// initializes the location integer array   
				int count = 0;
				int location[][] = new int[count][2];

				// loops through the programs to see where the element locates
				for (int row = 0; row < array.length; row ++)
				{
					for (int col = 0; col < array[row].length; col++)
					{
						// if element is found
						if(array[row][col]==(element))
						{
							// increments count
							count++;

							// creates a new array of new size count
							int newLocation[][] = new int[count][2];

							// copy the original array
							for(int i = 0; i<location.length; i++)
							{
								for(int j = 0; j<location[i].length; j++)
								{
									newLocation[i][j] = location[i][j];
								}
							}

							// add the new locations
							newLocation[count-1][0] = row;
							newLocation[count-1][1] = col;

							// assigns new array to the original one
							location = newLocation;
						}
					} // end for
				} // end for
				return location;
	}

	/**
	 *  Find all of the positions of the element in the 2D array given the element
	 *  @param array    2D array
	 *  @param element  given value
	 *  @return location[][]    locations of all occurrences of the element returned on each row
	 *  @throws java.lang.NullPointerException if the given array is null
	 *  @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static int[][] findElement(double[][] array, double element)
	{
		// initializes the location integer array   
		int count = 0;
		int location[][] = new int[count][2];

		// loops through the programs to see where the element locates
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				// if element is found
				if(array[row][col] == (element))
				{
					// increments count
					count++;

					// creates a new array of new size count
					int newLocation[][] = new int[count][2];

					// copy the original array
					for(int i = 0; i<location.length; i++)
					{
						for(int j = 0; j<location[i].length; j++)
						{
							newLocation[i][j] = location[i][j];
						}
					}

					// add the new locations
					newLocation[count-1][0] = row;
					newLocation[count-1][1] = col;

					// assigns new array to the original one
					location = newLocation;
				}
			} // end for
		} // end for
		return location;
	} // end findElement

	/**
	 *	Find the element given the position in the 2D array
	 *	@param array	2D array
	 *	@param row	the pow of the element
	 *	@param col	the column of the element
	 *	@return element		the value in that given row, col
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static int findElement(int[][] array, int row, int col )
	{
		// initializes and gets the element
		int element = 0;
		element = array[row-1][col-1];

		return element;
	} // end findElement

	/**
	 *	Find the element given the position in the 2D array
	 *	@param array	2D array
	 *	@param row	the pow of the element
	 *	@param col	the column of the element
	 *	@return element		the value in that given row, col
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static String findElement(String[][] array, int row, int col )
	{
		// initializes and gets the element
		String element = "";
		element = array[row-1][col-1];

		return element;
	} // end findElement

	/**
	 *	Find the max element in a 2D array
	 *	@param array	2D array
	 *	@return max		the maximum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static int findMax(int[][] array)
	{
		// initializes the max
		int max = array[0][0];

		// loops through the programs to see what is the max in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col] > max)
				{
					max = array[row][col];
				}
			} // end for
		} // end for
		return max;
	} // end findMax

	/**
	 *	Find the max element in a 2D array
	 *	@param array	2D array
	 *	@return max		the maximum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static String findMax(String[][] array)
	{
		// initializes the max
		String max = array[0][0];

		// loops through the programs to see what is the max in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col].compareTo(max) > 0)
				{
					max = array[row][col];
				}
			} // end for
		} // end for
		return max;
	} // end findMax

	/**
	 *	Find the max element in a 2D array
	 *	@param array	2D array
	 *	@return max		the maximum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static double findMax(double[][] array)
	{
		// initializes the max
		double max = array[0][0];

		// loops through the programs to see what is the max in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col] > max)
				{
					max = array[row][col];
				}
			} // end for
		} // end for
		return max;
	} // end findMax

	/**
	 *	Find the min element in a 2D array
	 *	@param array	2D array
	 *	@return min		the minimum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static int findMin(int[][] array)
	{
		// initializes the min
		int min = array[0][0];

		// loops through the programs to see what is the min in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col] < min)
				{
					min = array[row][col];
				}
			} // end for
		} // end for
		return min;
	} // end findMin

	/**
	 *	Find the min element in a 2D array
	 *	@param array	2D array
	 *	@return min		the minimum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static String findMin(String[][] array)
	{
		// initializes the min
		String min = array[0][0];

		// loops through the programs to see what is the min in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col].compareTo(min) < 0)
				{
					min = array[row][col];
				}
			} // end for
		} // end for
		return min;
	} // end findMin

	/**
	 *	Find the min element in a 2D array
	 *	@param array	2D array
	 *	@return min		the minimum value in the array
	 *	@throws java.lang.NullPointerException if the given array is null
	 *	@throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static double findMin(double[][] array)
	{
		// initializes the min
		double min = array[0][0];

		// loops through the programs to see what is the min in the array
		for (int row = 0; row < array.length; row ++)
		{
			for (int col = 0; col < array[row].length; col++)
			{
				if(array[row][col] < min)
				{
					min = array[row][col];
				}
			} // end for
		} // end for
		return min;
	} // end findMin
	
  /**
	 * finds all appearances of a specified sequence in an array
	 * @param array - the array to search for sequences
	 * @param sequenceIncrement - the amount the sequence increments by
	 * @param startingPoint - the first value in the sequence
	 * @param numOfElements - the length of the sequence
	 * @param vertical - can the sequence be vertical
	 * @param horizontal - can the sequence be horizontal
	 * @param diagonalD - can the sequence be diagonal down (ie. top left to bottom right)
	 * @param diagaonlU - can the sequence be diagonal up (ie. bottom left to top right)
	 * @param reverse - can the sequence be reversed (ie. right to left, bottom to top, bottom right to top left, top right to bottom left) 
	 * @return 4d array with components [# of the sequence starting position] [# of the sequence from a starting position] [position in the sequence] [(x,y) coords of that point]
	 */
	public static int [][][][] findSequence (int [][] array, int sequenceIncrement, int startingPoint, int numOfElements, boolean vertical, boolean horizontal, boolean diagonalD, boolean diagonalU, boolean reverse){

		//initialize 4d sequences array, array for all the points making up the sequence, and defines first sequence point as the starting point
		int [][][][] sequences;	
		int [] sequencePoints = new int [numOfElements];
		sequencePoints[0] = startingPoint; 

		//places the 4 direction booleans into an array
		boolean[] directions = {vertical, horizontal, diagonalD, diagonalU, reverse};

		//for the number of elements - 1
		for (int j = 1;j<numOfElements;j++) {

			//the sequence point at j is the prior point + the increment
			sequencePoints[j] = sequencePoints[j-1] + sequenceIncrement;

		}//end for

		//creates 2d array coords, the (x,y) coords of every starting point on the grid, using findElements
		int coords[][] = findElement(array, startingPoint);

		//creates 3d array for the coords connecting to the starting points
		int[][][] subCoords = new int [coords.length][1][2];

		//for all starting points in the array
		for (int x = 0;x<coords.length;x++) {

			//search the space around the starting point for the second sequence position
			subCoords[x] = searchSurround(coords[x], array, directions, sequencePoints[1], false);

			if (subCoords[x].length==0) {//if there are no points connecting to a start point
					
					int[] zero = {0,0};//initializes a connecting point at 0,0
					
					subCoords[x]=insertRow(subCoords[x], zero, 0);//adds that 0,0 point as a connecting point

			}//ends if

		}//end inner for

		int [] lengths = new int [coords.length];//initializes array for # of branches from start points

		for (int x = 0;x<subCoords.length;x++) {//for all subCoord values

			lengths[x] = subCoords[x].length;//the element of lengths is the length of the subCoord element

		}

		sequences = new int [coords.length][][][];//reinitialize sequences as ragged array with first length equal to coords.length

		for (int x = 0;x<coords.length;x++) {//for all coord values

			sequences[x] = new int[lengths[x]][numOfElements][2];//sequences at x is a 3d array of lengths element by number of elements by 2

		}

		for (int x = 0;x<coords.length;x++) {//for all values in the coords array

			//inserts the starting point coords onto the x plane of the array, forming the base
			sequences[x][0][0] = coords[x];

		}

		//for every value in the coords array
		for (int x = 0;x<coords.length;x++) {

			//for all values in the sub coordinates
			for (int i = 0;i<subCoords[x].length;i++) {
				//insert the subCoords at the related start point, at the current i value on the correct sequence point 
				sequences[x][i][1] = subCoords[x][i];

			}//end second inner for

		}//end for

		for (int x = 0;x<sequences.length;x++) {//for all starting points in the set
			for (int z = 2;z<numOfElements;z++) {//for all sequences points after the second
				for (int i=0;i<sequences[x].length;i++) {//for each branch from the starting point

					boolean[] direction = {false, false, false, false, false};//initialize available directions for next point

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[3] = true;//sequence is diagonal up

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]-1) {//else if up but not right

						direction[0] = true;//sequence is vertical

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[2] = true;//sequence is diagonal down

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//else if right but not down

						direction[1] = true;//sequence is horizontal

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is up left

						direction[2] = true;//sequence is diagonal down
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]+1) {//else if up but not right

						direction[0] = true;//sequence is vertical
						direction[4] = true;//sequence is reverse

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is down left

						direction[2] = true;//sequence is diagonal up
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is left but not down

						direction[1] = true;//sequence is horizontal
						direction[4] = true;//sequence is reverse

					}

					int[][] subCoordsB = searchSurround(sequences[x][i][z-1], array, direction, sequencePoints[z], true);//find all legal moves from the second position onwards

					for (int j = 0;j<subCoordsB.length;j++) {//for all secondary subCoords
						sequences[x][i][z] = subCoordsB[j];//set the next point in the sequence to subCoordsB at j
					}

				}
			}
		}

		//for all starting points
		for (int x=0;x<sequences.length;x++) {

			//for all i values
			for (int i=0;i<sequences[x].length;i++) {

				if (sequences[x].length>1&&i<sequences[x].length-1) {//if a starting point has multiple branches and the i value is 1 before the final value

					sequences[x][i+1][0] = Array.copyArray(sequences[x][i][0]);//the next branchs starting point is equal to the prior branches starting point

				}

				if (array[sequences[x][i][numOfElements-1][0]][sequences[x][i][numOfElements-1][1]]!=sequencePoints[numOfElements-1]) {//if the final element in a sequence is not the correct final element for that sequence

					for (int z = 0;z<numOfElements;z++) {//for all points in that branch
						sequences[x][i] = deleteRow(sequences[x][i], z);//remove that point
					}
				}
			}//end inner for
		}//end outer for

		//return the sequences array
		return sequences;

	}//end findSequences

	/**
	 * searches the 8 points around a specific coordinate for a certain value, in indicated directions
	 * @param coords - the coordinates to search around
	 * @param array - the grid to search on
	 * @param directions - the allowed and disallowed directions
	 * @param target - the element to search for
	 * @param is3 - is it searching for the 3rd or higher element in the sequence
	 * @return the (x,y) coordinates of all target values around the coordinates given
	 */
	private static int [][] searchSurround (int[] coords, int[][] array, boolean[] directions, int target, boolean is3){

		int[][] subCoords = new int [0][0];//initializes sub coordinate array as a point

		int position = 0;//sets the position of the coordinate as the 0th sequences from the starting coords

		if (directions[0]) {//if vertical sequences are allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]] == target) {//if the value below the starting point is the target

						int[] coordsB = {coords[0]+1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]] == target) {//if the value above the coords is the target

						int[] coordsB = {coords[0]-1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}

		}

		if (directions[1]) {//if horizontal sequence is allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]][coords[1]+1] == target) {//if the value one right of the coords is the target

						int[] coordsB = {coords[0],coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse sequences are allowed

				try {
					if (array[coords[0]][coords[1]-1] == target) {//if value one left of coords is target

						int[] coordsB = {coords[0],coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
			if (directions[3]) {//if diagonalU is allowed

				try {
					if (array[coords[0]-1][coords[1]+1] == target) {//if value one up one right of coords is target

						int[] coordsB = {coords[0]-1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]-1] == target) {//if value one up one left of coords is target

						int[] coordsB = {coords[0]-1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position;

					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (directions[2]) {//if diagonalD is allowed
			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]+1] == target) {//if value one down one right of coords is target

						int[] coordsB = {coords[0]+1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed
				try {
					if (array[coords[0]+1][coords[1]-1] == target) {//if value one down one left of coords is target

						int[] coordsB = {coords[0]+1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return subCoords;//return sub coordinates array

	}//end searchSurround

	/**
	 * finds all appearances of a specified sequence in an array
	 * @param array - the array to search for sequences
	 * @param sequenceIncrement - the amount the sequence increments by
	 * @param startingPoint - the first value in the sequence
	 * @param numOfElements - the length of the sequence
	 * @param vertical - can the sequence be vertical
	 * @param horizontal - can the sequence be horizontal
	 * @param diagonalD - can the sequence be diagonal down (ie. top left to bottom right)
	 * @param diagaonlU - can the sequence be diagonal up (ie. bottom left to top right)
	 * @param reverse - can the sequence be reversed (ie. right to left, bottom to top, bottom right to top left, top right to bottom left) 
	 * @return 4d array with components [# of the sequence starting position] [# of the sequence from a starting position] [position in the sequence] [(x,y) coords of that point]
	 */
	public static int [][][][] findSequence (double [][] array, double sequenceIncrement, double startingPoint, int numOfElements, boolean vertical, boolean horizontal, boolean diagonalD, boolean diagonalU, boolean reverse){

		//initialize 4d sequences array, array for all the points making up the sequence, and defines first sequence point as the starting point
		int [][][][] sequences;	
		double [] sequencePoints = new double[numOfElements];
		sequencePoints[0] = startingPoint; 

		//places the 4 direction booleans into an array
		boolean[] directions = {vertical, horizontal, diagonalD, diagonalU, reverse};

		//for the number of elements - 1
		for (int j = 1;j<numOfElements;j++) {

			//the sequence point at j is the prior point + the increment
			sequencePoints[j] = sequencePoints[j-1] + sequenceIncrement;

		}//end for

		//creates 2d array coords, the (x,y) coords of every starting point on the grid, using findElements
		int coords[][] = findElement(array, startingPoint);

		//creates 3d array for the coords connecting to the starting points
		int[][][] subCoords = new int [coords.length][1][2];

		//for all starting points in the array
		for (int x = 0;x<coords.length;x++) {

			//search the space around the starting point for the second sequence position
			subCoords[x] = searchSurround(coords[x], array, directions, sequencePoints[1], false);

			if (subCoords[x].length==0) {//if there are no points connecting to a start point
					
					int[] zero = {0,0};//initializes a connecting point at 0,0
					
					subCoords[x]=insertRow(subCoords[x], zero, 0);//adds that 0,0 point as a connecting point

			}//ends if

		}//end inner for

		int [] lengths = new int [coords.length];//initializes array for # of branches from start points

		for (int x = 0;x<subCoords.length;x++) {//for all subCoord values

			lengths[x] = subCoords[x].length;//the element of lengths is the length of the subCoord element

		}

		sequences = new int[coords.length][][][];//reinitialize sequences as ragged array with first length equal to coords.length

		for (int x = 0;x<coords.length;x++) {//for all coord values

			sequences[x] = new int[lengths[x]][numOfElements][2];//sequences at x is a 3d array of lengths element by number of elements by 2

		}

		for (int x = 0;x<coords.length;x++) {//for all values in the coords array

			//inserts the starting point coords onto the x plane of the array, forming the base
			sequences[x][0][0] = coords[x];

		}

		//for every value in the coords array
		for (int x = 0;x<coords.length;x++) {

			//for all values in the sub coordinates
			for (int i = 0;i<subCoords[x].length;i++) {
				//insert the subCoords at the related start point, at the current i value on the correct sequence point 
				sequences[x][i][1] = subCoords[x][i];

			}//end second inner for

		}//end for

		for (int x = 0;x<sequences.length;x++) {//for all starting points in the set
			for (int z = 2;z<numOfElements;z++) {//for all sequences points after the second
				for (int i=0;i<sequences[x].length;i++) {//for each branch from the starting point

					boolean[] direction = {false, false, false, false, false};//initialize available directions for next point

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[3] = true;//sequence is diagonal up

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]-1) {//else if up but not right

						direction[0] = true;//sequence is vertical

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[2] = true;//sequence is diagonal down

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//else if right but not down

						direction[1] = true;//sequence is horizontal

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is up left

						direction[2] = true;//sequence is diagonal down
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]+1) {//else if up but not right

						direction[0] = true;//sequence is vertical
						direction[4] = true;//sequence is reverse

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is down left

						direction[2] = true;//sequence is diagonal up
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is left but not down

						direction[1] = true;//sequence is horizontal
						direction[4] = true;//sequence is reverse

					}

					int[][] subCoordsB = searchSurround(sequences[x][i][z-1], array, direction, sequencePoints[z], true);//find all legal moves from the second position onwards

					for (int j = 0;j<subCoordsB.length;j++) {//for all secondary subCoords
						sequences[x][i][z] = subCoordsB[j];//set the next point in the sequence to subCoordsB at j
					}

				}
			}
		}

		//for all starting points
		for (int x=0;x<sequences.length;x++) {

			//for all i values
			for (int i=0;i<sequences[x].length;i++) {

				if (sequences[x].length>1&&i<sequences[x].length-1) {//if a starting point has multiple branches and the i value is 1 before the final value

					sequences[x][i+1][0] = Array.copyArray(sequences[x][i][0]);//the next branchs starting point is equal to the prior branches starting point

				}

				if (array[sequences[x][i][numOfElements-1][0]][sequences[x][i][numOfElements-1][1]]!=sequencePoints[numOfElements-1]) {//if the final element in a sequence is not the correct final element for that sequence

					for (int z = 0;z<numOfElements;z++) {//for all points in that branch
						sequences[x][i] = deleteRow(sequences[x][i], z);//remove that point
					}
				}
			}//end inner for
		}//end outer for

		//return the sequences array
		return sequences;

	}//end findSequences

	/**
	 * searches the 8 points around a specific coordinate for a certain value, in indicated directions
	 * @param coords - the coordinates to search around
	 * @param array - the grid to search on
	 * @param directions - the allowed and disallowed directions
	 * @param target - the element to search for
	 * @param is3 - is it searching for the 3rd or higher element in the sequence
	 * @return the (x,y) coordinates of all target values around the coordinates given
	 */
	private static int [][] searchSurround (int[] coords, double[][] array, boolean[] directions, double target, boolean is3){

		int[][] subCoords = new int [0][0];//initializes sub coordinate array as a point

		int position = 0;//sets the position of the coordinate as the 0th sequences from the starting coords

		if (directions[0]) {//if vertical sequences are allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]] == target) {//if the value below the starting point is the target

						int[] coordsB = {coords[0]+1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]] == target) {//if the value above the coords is the target

						int[] coordsB = {coords[0]-1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}

		}

		if (directions[1]) {//if horizontal sequence is allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]][coords[1]+1] == target) {//if the value one right of the coords is the target

						int[] coordsB = {coords[0],coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse sequences are allowed

				try {
					if (array[coords[0]][coords[1]-1] == target) {//if value one left of coords is target

						int[] coordsB = {coords[0],coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
			if (directions[3]) {//if diagonalU is allowed

				try {
					if (array[coords[0]-1][coords[1]+1] == target) {//if value one up one right of coords is target

						int[] coordsB = {coords[0]-1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]-1] == target) {//if value one up one left of coords is target

						int[] coordsB = {coords[0]-1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position;

					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (directions[2]) {//if diagonalD is allowed
			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]+1] == target) {//if value one down one right of coords is target

						int[] coordsB = {coords[0]+1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed
				try {
					if (array[coords[0]+1][coords[1]-1] == target) {//if value one down one left of coords is target

						int[] coordsB = {coords[0]+1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return subCoords;//return sub coordinates array

	}//end subCoords
	
	/**
	 * finds all appearances of a specified sequence in an array
	 * @param array - the array to search for sequences
	 * @param sequencePoints - the sequence of characters to search for
	 * @param vertical - can the sequence be vertical
	 * @param horizontal - can the sequence be horizontal
	 * @param diagonalD - can the sequence be diagonal down (ie. top left to bottom right)
	 * @param diagaonlU - can the sequence be diagonal up (ie. bottom left to top right)
	 * @param reverse - can the sequence be reversed (ie. right to left, bottom to top, bottom right to top left, top right to bottom left) 
	 * @return 4d array with components [# of the sequence starting position] [# of the sequence from a starting position] [position in the sequence] [(x,y) coords of that point]
	 */
	public static int [][][][] findSequence (char [][] array, char[]sequencePoints, boolean vertical, boolean horizontal, boolean diagonalD, boolean diagonalU, boolean reverse){

		//initialize 4d sequences array, array for all the points making up the sequence, and defines first sequence point as the starting point
		int [][][][] sequences;	

		//places the 4 direction booleans into an array
		boolean[] directions = {vertical, horizontal, diagonalD, diagonalU, reverse};

		//creates 2d array coords, the (x,y) coords of every starting point on the grid, using findElements
		int coords[][] = findElement(array, sequencePoints[0]);

		//creates 3d array for the coords connecting to the starting points
		int[][][] subCoords = new int [coords.length][1][2];

		//for all starting points in the array
		for (int x = 0;x<coords.length;x++) {

			//search the space around the starting point for the second sequence position
			subCoords[x] = searchSurround(coords[x], array, directions, sequencePoints[1], false);

			if (subCoords[x].length==0) {//if there are no points connecting to a start point
					
					int[] zero = {0,0};//initializes a connecting point at 0,0
					
					subCoords[x]=insertRow(subCoords[x], zero, 0);//adds that 0,0 point as a connecting point

			}//ends if

		}//end inner for

		int [] lengths = new int [coords.length];//initializes array for # of branches from start points

		for (int x = 0;x<subCoords.length;x++) {//for all subCoord values

			lengths[x] = subCoords[x].length;//the element of lengths is the length of the subCoord element

		}

		sequences = new int [coords.length][][][];//reinitialize sequences as ragged array with first length equal to coords.length

		for (int x = 0;x<coords.length;x++) {//for all coord values

			sequences[x] = new int[lengths[x]][sequencePoints.length][2];//sequences at x is a 3d array of lengths element by number of elements by 2

		}

		for (int x = 0;x<coords.length;x++) {//for all values in the coords array

			//inserts the starting point coords onto the x plane of the array, forming the base
			sequences[x][0][0] = coords[x];

		}

		//for every value in the coords array
		for (int x = 0;x<coords.length;x++) {

			//for all values in the sub coordinates
			for (int i = 0;i<subCoords[x].length;i++) {
				//insert the subCoords at the related start point, at the current i value on the correct sequence point 
				sequences[x][i][1] = subCoords[x][i];

			}//end second inner for

		}//end for

		for (int x = 0;x<sequences.length;x++) {//for all starting points in the set
			for (int z = 2;z<sequencePoints.length;z++) {//for all sequences points after the second
				for (int i=0;i<sequences[x].length;i++) {//for each branch from the starting point

					boolean[] direction = {false, false, false, false, false};//initialize available directions for next point

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[3] = true;//sequence is diagonal up

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]-1) {//else if up but not right

						direction[0] = true;//sequence is vertical

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[2] = true;//sequence is diagonal down

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//else if right but not down

						direction[1] = true;//sequence is horizontal

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is up left

						direction[2] = true;//sequence is diagonal down
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]+1) {//else if up but not right

						direction[0] = true;//sequence is vertical
						direction[4] = true;//sequence is reverse

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is down left

						direction[2] = true;//sequence is diagonal up
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is left but not down

						direction[1] = true;//sequence is horizontal
						direction[4] = true;//sequence is reverse

					}

					int[][] subCoordsB = searchSurround(sequences[x][i][z-1], array, direction, sequencePoints[z], true);//find all legal moves from the second position onwards

					for (int j = 0;j<subCoordsB.length;j++) {//for all secondary subCoords
						sequences[x][i][z] = subCoordsB[j];//set the next point in the sequence to subCoordsB at j
					}

				}
			}
		}

		//for all starting points
		for (int x=0;x<sequences.length;x++) {

			//for all i values
			for (int i=0;i<sequences[x].length;i++) {

				if (sequences[x].length>1&&i<sequences[x].length-1) {//if a starting point has multiple branches and the i value is 1 before the final value

					sequences[x][i+1][0] = Array.copyArray(sequences[x][i][0]);//the next branchs starting point is equal to the prior branches starting point

				}

				if (array[sequences[x][i][sequencePoints.length-1][0]][sequences[x][i][sequencePoints.length-1][1]]!=sequencePoints[sequencePoints.length-1]) {//if the final element in a sequence is not the correct final element for that sequence

					for (int z = 0;z<sequencePoints.length;z++) {//for all points in that branch
						sequences[x][i] = deleteRow(sequences[x][i], z);//remove that point
					}
				}
			}//end inner for
		}//end outer for

		//return the sequences array
		return sequences;

	}//end findSequences

	/**
	 * searches the 8 points around a specific coordinate for a certain value, in indicated directions
	 * @param coords - the coordinates to search around
	 * @param array - the grid to search on
	 * @param directions - the allowed and disallowed directions
	 * @param target - the element to search for
	 * @param is3 - is it searching for the 3rd or higher element in the sequence
	 * @return the (x,y) coordinates of all target values around the coordinates given
	 */
	private static int [][] searchSurround (int[] coords, char[][] array, boolean[] directions, char target, boolean is3){

		int[][] subCoords = new int [0][0];//initializes sub coordinate array as a point

		int position = 0;//sets the position of the coordinate as the 0th sequences from the starting coords

		if (directions[0]) {//if vertical sequences are allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]] == target) {//if the value below the starting point is the target

						int[] coordsB = {coords[0]+1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]] == target) {//if the value above the coords is the target

						int[] coordsB = {coords[0]-1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}

		}

		if (directions[1]) {//if horizontal sequence is allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]][coords[1]+1] == target) {//if the value one right of the coords is the target

						int[] coordsB = {coords[0],coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse sequences are allowed

				try {
					if (array[coords[0]][coords[1]-1] == target) {//if value one left of coords is target

						int[] coordsB = {coords[0],coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
			if (directions[3]) {//if diagonalU is allowed

				try {
					if (array[coords[0]-1][coords[1]+1] == target) {//if value one up one right of coords is target

						int[] coordsB = {coords[0]-1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]-1] == target) {//if value one up one left of coords is target

						int[] coordsB = {coords[0]-1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position;

					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (directions[2]) {//if diagonalD is allowed
			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]+1] == target) {//if value one down one right of coords is target

						int[] coordsB = {coords[0]+1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed
				try {
					if (array[coords[0]+1][coords[1]-1] == target) {//if value one down one left of coords is target

						int[] coordsB = {coords[0]+1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return subCoords;//return sub coordinates array

	}//end subCoords
	
	/**
	 * finds all appearances of a specified sequence in an array
	 * @param array - the array to search for sequences
	 * @param sequencePoints - the sequence of strings to search for
	 * @param vertical - can the sequence be vertical
	 * @param horizontal - can the sequence be horizontal
	 * @param diagonalD - can the sequence be diagonal down (ie. top left to bottom right)
	 * @param diagaonlU - can the sequence be diagonal up (ie. bottom left to top right)
	 * @param reverse - can the sequence be reversed (ie. right to left, bottom to top, bottom right to top left, top right to bottom left) 
	 * @return 4d array with components [# of the sequence starting position] [# of the sequence from a starting position] [position in the sequence] [(x,y) coords of that point]
	 */
	public static int [][][][] findSequence (String [][] array, String[]sequencePoints, boolean vertical, boolean horizontal, boolean diagonalD, boolean diagonalU, boolean reverse){

		//initialize 4d sequences array, array for all the points making up the sequence, and defines first sequence point as the starting point
		int [][][][] sequences;	

		//places the 4 direction booleans into an array
		boolean[] directions = {vertical, horizontal, diagonalD, diagonalU, reverse};

		//creates 2d array coords, the (x,y) coords of every starting point on the grid, using findElements
		int coords[][] = findElement(array, sequencePoints[0]);

		//creates 3d array for the coords connecting to the starting points
		int[][][] subCoords = new int [coords.length][1][2];

		//for all starting points in the array
		for (int x = 0;x<coords.length;x++) {

			//search the space around the starting point for the second sequence position
			subCoords[x] = searchSurround(coords[x], array, directions, sequencePoints[1], false);

			if (subCoords[x].length==0) {//if there are no points connecting to a start point
					
					int[] zero = {0,0};//initializes a connecting point at 0,0
					
					subCoords[x]=insertRow(subCoords[x], zero, 0);//adds that 0,0 point as a connecting point

			}//ends if

		}//end inner for

		int [] lengths = new int [coords.length];//initializes array for # of branches from start points

		for (int x = 0;x<subCoords.length;x++) {//for all subCoord values

			lengths[x] = subCoords[x].length;//the element of lengths is the length of the subCoord element

		}

		sequences = new int [coords.length][][][];//reinitialize sequences as ragged array with first length equal to coords.length

		for (int x = 0;x<coords.length;x++) {//for all coord values

			sequences[x] = new int[lengths[x]][sequencePoints.length][2];//sequences at x is a 3d array of lengths element by number of elements by 2

		}

		for (int x = 0;x<coords.length;x++) {//for all values in the coords array

			//inserts the starting point coords onto the x plane of the array, forming the base
			sequences[x][0][0] = coords[x];

		}

		//for every value in the coords array
		for (int x = 0;x<coords.length;x++) {

			//for all values in the sub coordinates
			for (int i = 0;i<subCoords[x].length;i++) {
				//insert the subCoords at the related start point, at the current i value on the correct sequence point 
				sequences[x][i][1] = subCoords[x][i];

			}//end second inner for

		}//end for

		for (int x = 0;x<sequences.length;x++) {//for all starting points in the set
			for (int z = 2;z<sequencePoints.length;z++) {//for all sequences points after the second
				for (int i=0;i<sequences[x].length;i++) {//for each branch from the starting point

					boolean[] direction = {false, false, false, false, false};//initialize available directions for next point

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[3] = true;//sequence is diagonal up

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]-1) {//else if up but not right

						direction[0] = true;//sequence is vertical

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//if z = 1 is one up one right of start

						direction[2] = true;//sequence is diagonal down

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]+1) {//else if right but not down

						direction[1] = true;//sequence is horizontal

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]-1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is up left

						direction[2] = true;//sequence is diagonal down
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][0]==sequences[x][0][0][0]+1) {//else if up but not right

						direction[0] = true;//sequence is vertical
						direction[4] = true;//sequence is reverse

					}

					if (sequences[x][i][1][0]==sequences[x][0][0][0]+1&&sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is down left

						direction[2] = true;//sequence is diagonal up
						direction[4] = true;//sequence is reverse

					}else if(sequences[x][i][1][1]==sequences[x][0][0][1]-1) {//if sequence is left but not down

						direction[1] = true;//sequence is horizontal
						direction[4] = true;//sequence is reverse

					}

					int[][] subCoordsB = searchSurround(sequences[x][i][z-1], array, direction, sequencePoints[z], true);//find all legal moves from the second position onwards

					for (int j = 0;j<subCoordsB.length;j++) {//for all secondary subCoords
						sequences[x][i][z] = subCoordsB[j];//set the next point in the sequence to subCoordsB at j
					}

				}
			}
		}

		//for all starting points
		for (int x=0;x<sequences.length;x++) {

			//for all i values
			for (int i=0;i<sequences[x].length;i++) {

				if (sequences[x].length>1&&i<sequences[x].length-1) {//if a starting point has multiple branches and the i value is 1 before the final value

					sequences[x][i+1][0] = Array.copyArray(sequences[x][i][0]);//the next branchs starting point is equal to the prior branches starting point

				}

				if (!array[sequences[x][i][sequencePoints.length-1][0]][sequences[x][i][sequencePoints.length-1][1]].equals(sequencePoints[sequencePoints.length-1])) {//if the final element in a sequence is not the correct final element for that sequence

					for (int z = 0;z<sequencePoints.length;z++) {//for all points in that branch
						sequences[x][i] = deleteRow(sequences[x][i], z);//remove that point
					}
				}
			}//end inner for
		}//end outer for

		//return the sequences array
		return sequences;

	}//end findSequences

	/**
	 * searches the 8 points around a specific coordinate for a certain value, in indicated directions
	 * @param coords - the coordinates to search around
	 * @param array - the grid to search on
	 * @param directions - the allowed and disallowed directions
	 * @param target - the element to search for
	 * @param is3 - is it searching for the 3rd or higher element in the sequence
	 * @return the (x,y) coordinates of all target values around the coordinates given
	 */
	private static int [][] searchSurround (int[] coords, String[][] array, boolean[] directions, String target, boolean is3){

		int[][] subCoords = new int [0][0];//initializes sub coordinate array as a point

		int position = 0;//sets the position of the coordinate as the 0th sequences from the starting coords

		if (directions[0]) {//if vertical sequences are allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]].equals(target)) {//if the value below the starting point is the target

						int[] coordsB = {coords[0]+1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]].equals(target)) {//if the value above the coords is the target

						int[] coordsB = {coords[0]-1,coords[1]};//set the coords for that point
						subCoords = insertRow(subCoords, coordsB, position);//insert the coordinates into the subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}

		}

		if (directions[1]) {//if horizontal sequence is allowed

			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]][coords[1]+1].equals(target)) {//if the value one right of the coords is the target

						int[] coordsB = {coords[0],coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse sequences are allowed

				try {
					if (array[coords[0]][coords[1]-1].equals(target)) {//if value one left of coords is target

						int[] coordsB = {coords[0],coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
			if (directions[3]) {//if diagonalU is allowed

				try {
					if (array[coords[0]-1][coords[1]+1].equals(target)) {//if value one up one right of coords is target

						int[] coordsB = {coords[0]-1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed

				try {
					if (array[coords[0]-1][coords[1]-1].equals(target)) {//if value one up one left of coords is target

						int[] coordsB = {coords[0]-1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position;

					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		if (directions[2]) {//if diagonalD is allowed
			if (!is3||!directions[4]) {//if is3 is false or reverse is disallowed
				try {
					if (array[coords[0]+1][coords[1]+1].equals(target)) {//if value one down one right of coords is target

						int[] coordsB = {coords[0]+1,coords[1]+1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
			if (directions[4]) {//if reverse is allowed
				try {
					if (array[coords[0]+1][coords[1]-1].equals(target)) {//if value one down one left of coords is target

						int[] coordsB = {coords[0]+1,coords[1]-1};//set coords into array
						subCoords = insertRow(subCoords, coordsB, position);//insert new coordinates into subCoords array at position
						position++;//increment position

					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return subCoords;//return sub coordinates array

	}//end subCoords
  
  /**
	 * inserts a column into a 2d int array
	 * @param array - the array to insert into
	 * @param column - the column to insert
	 * @param position - the column to insert at
	 * @return new array with inserted columns
	 */
	public static int[][] insertColumn(int[][] array, int[] column, int position){

		int[][] newArray = new int [column.length][array[0].length+1];//creates newArray with same height but greater width

		for (int j=0;j<array.length;j++) {//for each row in the original array

			for (int i = 0;i<position;i++) {//for all elements in that row prior to insert point

				newArray[j][i]=array[j][i];//newArray at j i equals old array at j i

			}

			newArray[j][position]=column[j];//newArray at j and position equals the insert column at j

			for (int i = position + 1;i<newArray[j].length;i++) {//for all elements in row after insert point

				newArray[j][i]=array[j][i-1];//newArray at j i equals old array at j, one i value prior

			}

		}

		return newArray;//returns newArray

	}//end insertColumn

	/**
	 * inserts a column into a string 2d array
	 * @param array - the array to insert into
	 * @param column - the column to insert
	 * @param position - the column to insert at
	 * @return new array with inserted columns
	 */
	public static String[][] insertColumn(String[][] array, String[] column, int position){

		String[][] newArray = new String[column.length][array[0].length+1];//creates newArray with same height but greater width

		for (int j=0;j<array.length;j++) {//for each row in the original array

			for (int i = 0;i<position;i++) {//for all elements in that row prior to insert point

				newArray[j][i]=array[j][i];//newArray at j i equals old array at j i

			}

			newArray[j][position]=column[j];//newArray at j and position equals the insert column at j

			for (int i = position + 1;i<newArray[j].length;i++) {//for all elements in row after insert point

				newArray[j][i]=array[j][i-1];//newArray at j i equals old array at j, one i value prior

			}

		}

		return newArray;//returns newArray

	}//end insertColumn
	
	/**
	 * inserts a column into a double 2d array
	 * @param array - the array to insert into
	 * @param column - the column to insert
	 * @param position - the column to insert at
	 * @return new array with inserted columns
	 */
	public static double[][] insertColumn(double[][] array, double[] column, int position){

		double[][] newArray = new double[column.length][array[0].length+1];//creates newArray with same height but greater width

		for (int j=0;j<array.length;j++) {//for each row in the original array

			for (int i = 0;i<position;i++) {//for all elements in that row prior to insert point

				newArray[j][i]=array[j][i];//newArray at j i equals old array at j i

			}

			newArray[j][position]=column[j];//newArray at j and position equals the insert column at j

			for (int i = position + 1;i<newArray[j].length;i++) {//for all elements in row after insert point

				newArray[j][i]=array[j][i-1];//newArray at j i equals old array at j, one i value prior

			}

		}

		return newArray;//returns newArray

	}//end insertColumn
	
	/**
	 * inserts a column into a char 2d array
	 * @param array - the array to insert into
	 * @param column - the column to insert
	 * @param position - the column to insert at
	 * @return new array with inserted columns
	 */
	public static char[][] insertColumn(char[][] array, char[] column, int position){

		char[][] newArray = new char[column.length][array[0].length+1];//creates newArray with same height but greater width

		for (int j=0;j<array.length;j++) {//for each row in the original array

			for (int i = 0;i<position;i++) {//for all elements in that row prior to insert point

				newArray[j][i]=array[j][i];//newArray at j i equals old array at j i

			}

			newArray[j][position]=column[j];//newArray at j and position equals the insert column at j

			for (int i = position + 1;i<newArray[j].length;i++) {//for all elements in row after insert point

				newArray[j][i]=array[j][i-1];//newArray at j i equals old array at j, one i value prior

			}

		}

		return newArray;//returns newArray

	}//end insertColumn
  
	/**
	 * inserts a row into a 2d string array at a specified index
	 * @param array - the array to insert into
	 * @param row - the row to be inserted
	 * @param position - the position to insert at
	 * @return the 2d array with inserted row
	 */
	public static String[][][] insertPlane(String[][][] array, String[][] plane, int position){

		String[][][] newArray = new String[array.length+1][plane.length][];//creates new 2d array with same width but greater height

		for (int j = 0;j<position;j++) {//for all elements prior to insert point

			newArray[j]=MDArray.copyArray(array[j]);//newArray at j copies old array at j

		}

		newArray[position]=plane;//newArray at position is the new row

		for (int j = position + 1;j<newArray.length;j++) {//for all elements after insert point

			newArray[j]=MDArray.copyArray(array[j-1]);//newArray at j copies old array at one before j

		}

		return newArray;//return newArray

	}//end insertRow
	
  /**
	 * inserts a row into a 2d int array at a specified index
	 * @param array - the array to insert into
	 * @param row - the row to be inserted
	 * @param position - the position to insert at
	 * @return the 2d array with inserted row
	 */
	public static int[][] insertRow(int[][] array, int[] row, int position){

		int[][] newArray = new int [array.length+1][row.length];//creates new 2d array with same width but greater height

		for (int j = 0;j<position;j++) {//for all elements prior to insert point

			newArray[j]=Array.copyArray(array[j]);//newArray at j copies old array at j

		}

		newArray[position]=row;//newArray at position is the new row

		for (int j = position + 1;j<newArray.length;j++) {//for all elements after insert point

			newArray[j]=Array.copyArray(array[j-1]);//newArray at j copies old array at one before j

		}

		return newArray;//return newArray

	}//end insertRow

	/**
	 * inserts a row into a 2d string array at a specified index
	 * @param array - the array to insert into
	 * @param row - the row to be inserted
	 * @param position - the position to insert at
	 * @return the 2d array with inserted row
	 */
	public static String[][] insertRow(String[][] array, String[] row, int position){

		String[][] newArray = new String[array.length+1][row.length];//creates new 2d array with same width but greater height

		for (int j = 0;j<position;j++) {//for all elements prior to insert point

			newArray[j]=Array.copyArray(array[j]);//newArray at j copies old array at j

		}

		newArray[position]=row;//newArray at position is the new row

		for (int j = position + 1;j<newArray.length;j++) {//for all elements after insert point

			newArray[j]=Array.copyArray(array[j-1]);//newArray at j copies old array at one before j

		}

		return newArray;//return newArray

	}//end insertRow
	
	/**
	 * inserts a row into a 2d double array at a specified index
	 * @param array - the array to insert into
	 * @param row - the row to be inserted
	 * @param position - the position to insert at
	 * @return the 2d array with inserted row
	 */
	public static double[][] insertRow(double[][] array, double[] row, int position){

		double[][] newArray = new double[array.length+1][row.length];//creates new 2d array with same width but greater height

		for (int j = 0;j<position;j++) {//for all elements prior to insert point

			newArray[j]=Array.copyArray(array[j]);//newArray at j copies old array at j

		}

		newArray[position]=row;//newArray at position is the new row

		for (int j = position + 1;j<newArray.length;j++) {//for all elements after insert point

			newArray[j]=Array.copyArray(array[j-1]);//newArray at j copies old array at one before j

		}

		return newArray;//return newArray

	}//end insertRow
	
	
	/**
	 * inserts a row into a 2d char array at a specified index
	 * @param array - the array to insert into
	 * @param row - the row to be inserted
	 * @param position - the position to insert at
	 * @return the 2d array with inserted row
	 */
	public static char[][] insertRow(char[][] array, char[] row, int position){

		char[][] newArray = new char[array.length+1][row.length];//creates new 2d array with same width but greater height

		for (int j = 0;j<position;j++) {//for all elements prior to insert point

			newArray[j]=Array.copyArray(array[j]);//newArray at j copies old array at j

		}

		newArray[position]=row;//newArray at position is the new row

		for (int j = position + 1;j<newArray.length;j++) {//for all elements after insert point

			newArray[j]=Array.copyArray(array[j-1]);//newArray at j copies old array at one before j

		}

		return newArray;//return newArray

	}//end insertRow
  
	/**
	 * Returns the length and row of the longest element in a column in a 2d integer array.
	 * @param array   2d array that contains the column find the longest element.
	 * @param column    index of the column to find the longest element in.
	 * @return length of the longest element.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid column index is entered.
	 */
	public static int longestElementColumn(int[][] array, int column) {
		
		//declare an array to store the max length and the row
		int max = 0;
		
		//iterate through the column of the array, while only accessing values if they exist
		for(int i = 0; i < array.length; i++) {
			if(column < array[i].length) {
				
				//convert element to string and find length
				int length = Integer.toString(array[i][column]).length();
				
				//if the length is greater than the max, store this as new max
				if(length > max) {
					max = length;
				}//end if
			}//end if
		}//end loop
		
		return max;
	}//end longestElementColumn method

	/**
	 * Returns the length and row of the longest element in a column in a 2d double array.
	 * @param array   2d array that contains the column find the longest element.
	 * @param column    index of the column to find the longest element in.
	 * @return length of the longest element.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid column index is entered.
	 */
	public static int longestElementColumn(double[][] array, int column) {
		
		//declare an array to store the max length and the row
		int max = 0;
		
		//iterate through the column of the array, while only accessing values if they exist
		for(int i = 0; i < array.length; i++) {
			if(column < array[i].length) {
				
				//convert element to string and find length
				int length = Double.toString(array[i][column]).length();
				
				//if the length is greater than the max, store this as new max
				if(length > max) {
					max = length;
				}//end if
			}//end if
		}//end loop
		
		return max;
	}//end longestElementColumn method

	/**
	 * Returns the length and row of the longest element in a column in a 2d String array.
	 * @param array   2d array that contains the column find the longest element.
	 * @param column    index of the column to find the longest element in.
	 * @return length of the longest element.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid column index is entered.
	 */
	public static int longestElementColumn(String[][] array, int column) {
		
		//declare an array to store the max length and the row
		int max = 0;
		
		//iterate through the column of the array, while only accessing values if they exist
		for(int i = 0; i < array.length; i++) {
			if(column < array[i].length) {
				
				//convert element to string and find length
				int length = array[i][column].length();
				
				//if the length is greater than the max, store this as new max
				if(length > max) {
					max = length;
				}//end if
			}//end if
		}//end loop
		
		return max;
	}//end longestElementColumn method

	/**
	 * Returns the length and column of the longest element in a row in a 2d integer array.
	 * @param array   2d array that contains the row find the longest element.
	 * @param row    index of the row to find the longest element in.
	 * @return 2 element array in which the first element is the length of the longest element and the second is the column in which the longest element is.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid row is entered.
	 */
	public static int[] longestElementRow(int[][] array, int row) {
		
		//declare an array to store the max length and the column
		int[] outputArr = {0,0};
		
		//iterate through row while converting all values to strings; if the length of the string is longer than the current max
		//set the max to be a its length and the column to be its column
		for(int i = 0; i < array[row].length; i++) {
			int length = Integer.toString(array[row][i]).length();
			if(length > outputArr[0]) {
				outputArr[0] = length;
				outputArr[1] = i;
			}//end if
		}//end for
		
		return outputArr;
	}//end longestElementRow method
	
	/**
	 * Returns the length and column of the longest element in a row in a 2d double array.
	 * @param array   2d array that contains the row find the longest element.
	 * @param row    index of the row to find the longest element in.
	 * @return 2 element array in which the first element is the length of the longest element and the second is the column in which the longest element is.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid row is entered.
	 */
	public static int[] longestElementRow(double[][] array, int row) {
		
		//declare an array to store the max length and the column
		int[] outputArr = {0,0};
		
		//iterate through row while converting all values to strings; if the length of the string is longer than the current max
		//set the max to be a its length and the column to be its column
		for(int i = 0; i < array[row].length; i++) {
			int length = Double.toString(array[row][i]).length();
			if(length > outputArr[0]) {
				outputArr[0] = length;
				outputArr[1] = i;
			}//end if
		}//end for
		
		return outputArr;
	}//end longestElementRow method
	
	/**
	 * Returns the length and column of the longest element in a row in a 2d String array.
	 * @param array   2d array that contains the row find the longest element.
	 * @param row    index of the row to find the longest element in.
	 * @return 2 element array in which the first element is the length of the longest element and the second is the column in which the longest element is.
	 * @throws NullPointerException if array entered is null.
	 * @throws ArrayIndexOutOfBoundsException if an invalid row is entered.
	 */
	public static int[] longestElementRow(String[][] array, int row) {
		
		//declare an array to store the max length and the column
		int[] outputArr = {0,0};
		
		//iterate through row; if the length of the string is longer than the current max
		//set the max to be a its length and the column to be its column
		for(int i = 0; i < array[row].length; i++) {
			int length = array[row][i].length();
			if(length > outputArr[0]) {
				outputArr[0] = length;
				outputArr[1] = i;
			}//end if
		}//end for
		
		return outputArr;
	}//end longestElementRow method
	
	/**
	 * Prints a 2D, double md array to the console. Default is to print the array in a table with each row on a new line and each element separated by a space. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 */
	public static void print(double[][] array) 
	{
		//prints the md array with a space between each element
		print(array, " ");
		
	}//ends print - 2D arrays

	/**
	 * Prints a 2D, integer md array to the console. Default is to print the array in a table with each row on a new line and each element separated by a space. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 */
	public static void print(int[][] array) 
	{
		//prints the md array with a space between each element
		print(array, " ");
		
	}//ends print - 2D arrays
	
	/**
	 * Prints a 2D, String md array to the console. Default is to print the array in a table with each row on a new line and each element separated by a space. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 */
	public static void print(String[][] array) 
	{
		//prints the md array with a space between each element
		print(array, " ");
		
	}//ends print - 2D arrays

	/**
	 * Prints a 2D, double md array to the console. Prints the array in a table with each row on a new line and each element separated by a specified delimiter. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 * @param delimiter   the String separator between multiple elements in a single row
	 */
	public static void print(double[][] array, String delimiter) 
	{
		//prints the md array with a space between each element
		for(int row = 0; row < array.length; row ++)
		{
			//prints first value in the row then the rest of the row with the delimiter between elements
			System.out.print(array [row][0]);
			for(int column = 1; column<array[row].length; column++)
			{
				System.out.print (delimiter + array [row][column] );
			}
			System.out.println(); //prints each row on a new line
		}
	}//ends print - 2D array method with delimiter

	/**
	 * Prints a 2D, integer md array to the console. Prints the array in a table with each row on a new line and each element separated by a specified delimiter. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 * @param delimiter   the String separator between multiple elements in a single row
	 */
	public static void print(int[][] array, String delimiter) 
	{
		//prints the md array with a space between each element
		for(int row = 0; row < array.length; row ++)
		{
			//prints first value in the row then the rest of the row with the delimiter between elements
			System.out.print(array [row][0]);
			for(int column = 1; column<array[row].length; column++)
			{
				System.out.print (delimiter + array [row][column] );
			}
			System.out.println(); //prints each row on a new line
		}
	}//ends print - 2D array method with delimiter

	/**
	 * Prints a 2D, integer md array to the console. Prints the array in a table with each row on a new line and each element separated by a specified delimiter. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 * @param delimiter   the String separator between multiple elements in a single row
	 */
	public static void print(boolean[][] array, String delimiter) 
	{
		//prints the md array with a space between each element
		for(int row = 0; row < array.length; row ++)
		{
			//prints first value in the row then the rest of the row with the delimiter between elements
			System.out.print(array [row][0]);
			for(int column = 1; column<array[row].length; column++)
			{
				System.out.print (delimiter + array [row][column] );
			}
			System.out.println(); //prints each row on a new line
		}
	}//ends print - 2D array method with delimiter

	/**
	 * Prints a 2D, String md array to the console. Prints the array in a table with each row on a new line and each element separated by a specified delimiter. Works for ragged 2D arrays as well.
	 * @param array   2D multidimentional array to be printed
	 * @param delimiter   the String separator between multiple elements in a single row
	 */
	public static void print(String[][] array, String delimiter) 
	{
		//prints the md array with a space between each element
		for(int row = 0; row < array.length; row ++)
		{
			//prints first value in the row then the rest of the row with the delimiter between elements
			System.out.print(array [row][0]);
			for(int column = 1; column<array[row].length; column++)
			{
				System.out.print (delimiter + array [row][column] );
			}
			System.out.println(); //prints each row on a new line
		}
	}//ends print - 2D array method with delimiter
  
    /** Prints a row in a 2D,int md array to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printIndicatedColumn(int[][] array, int col) 
	{
		//prints the md array of the column indicated
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array [0][col]);

		}//ends for

	}//ends printIndicatedColumn

	/** Prints a row in a 2D, String md array to the console.
	 * @param array 2D multidimentional array to be printed
	 */
	public static void printIndicatedColumn(String[][] array, int col) 
	{
		//prints the md array of the column indicated
		for(int i = 0; i< array.length; i++)
		{
			System.out.print(array [0][col]);

		}//ends for

	}//ends printIndicatedColumn

	/** Prints a column in a 2D, double md array to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printIndicatedColumn(double[][] array, int col) 
	{
		//prints the md array of the column indicated
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array [0][col]);

		}//ends for

	}//ends printIndicatedColumn

	/** Prints a row in a 2D, int md array to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printIndicatedRow(int [][] array, int row) 
	{
		//prints the md array of the row indicated
		for(int i = 0; i < array.length; i ++)
		{
			System.out.print(array [row][0] + " ");

		}//ends for

	}//ends printIndicatedRow

	/** Prints a row in a 2D, String md array to the console.
	 * @param array 2D multi-dimentional array to be printed
	 */

	public static void printIndicatedRow(String [][] array, int row) 
	{
		//prints the md array of the row indicated
		for(int i = 0; i < array.length; i ++)
		{
			System.out.print(array[row][0]);

		}//ends for

	}//ends printIndicatedRow

	/** Prints a row in a 2D, double md array to the console.
	 * @param array 2D multidimentional array to be printed
	 */
	public static void printIndicatedRow(double [][] array, int row) 
	{
		//prints the md array of the row indicated
		for(int i = 0; i < array.length; i ++)
		{
			System.out.print(array [row][0]);

		}//ends for

	}//ends printIndicatedRow
	
  /** Prints a 2D, int md array in major order by column to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printMajorOrderbyColumn(int[][] array) 
	{
		//nested loop to loop through the columns to print them
		for(int j = 0; j < array[j].length; j++)
		{
			for(int i = 0; i < array.length; i++)
			{
				System.out.print(array [i][j] + " ");

			}//ends inner for

		}//ends outer for

	}//ends printMajorOrderbyColumn

	/** Prints a 2D, String md array in major order by column to the console..
	 * @param array 2D multidimentional array to be printed
	 */
	public static void printMajorOrderbyColumn(String[][] array) 
	{
		//nested loop to loop through the columns to print them
		for(int j = 0; j < array.length; j++)
		{
			for(int i = 0; i < array[j].length; i++)
			{
				System.out.print(array [i][j] + " ");

			}//ends inner for
      
		}//ends outer for

	}//ends printMajorOrderbyColumn

	/**Prints a 2D, double md array in major order by column to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printMajorOrderbyColumn(double[][] array) 
	{
		//nested loop to loop through the columns to print them
		for(int j = 0; j < array.length; j++)
		{
			for(int i = 0; i < array[j].length; i++)
			{
				System.out.print(array [i][j] + " ");

			}//ends inner for
      
		}//ends outer for

	}//ends printMajorOrderbyColumm
  
	/** 
	 * Prints a 2D, int md array in major order in  to the console.
	 * @param array 2D multidimentional array to be printed
	 */

	public static void printMajorOrderbyRow(int [][] array) 
	{
		//nested loop to loop through the rows to print them
		for(int i = 0; i < array.length; i ++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				System.out.print(array [i][j] + " ");
        
			}//ends inner for

		}//ends outer for

	}//ends printMajorOrderbyRow

	/** Prints a 2D, String md array in major order to the console.
	 * @param array 2D multi-dimentional array to be printed
	 */

	public static void printMajorOrderbyRow(String [][] array) 
	{
		//nested loop to loop through the rows to print them
		for(int i = 0; i < array.length; i ++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				System.out.print(array [i][j] + " ");
        
			}//ends inner for

		}//ends outer for

	}//ends printMajorOrderbyRow

	/** Prints a 2D, double md array in major order to the console.
	 * @param array 2D multidimentional array to be printed
	 */
	public static void printMajorOrderbyRow(double [][] array ) 
	{
		//nested loop to loop through the rows
		for(int i = 0; i < array.length; i ++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				System.out.print(array [i][j] + " ");
        
			}//ends inner for

		}//ends outer for

	}//ends printMajorOrderbyRow
  
	/**
	 * Prints a 2d integer array with spacers for the top, middle, bottom, right, center, and left of elements.
	 * @param array   2d array to be printed with spacers.
	 * @param top   the top spacer.
	 * @param middle   the middle spacer (between elements vertically).
	 * @param bottom   the bottom spacer.
	 * @param left   the left spacer.
	 * @param center   the center spacer (between elements horizontally).
	 * @param right   the right spacer.
	 * @param centerpoint   the symbol that goes between the middle and center spacers
	 * @throws NullPointerException if null array is passed
	 * @throws ArrayIndexOutOfBoundsException if a completely empty array is passed (fine if there is at least one empty row in the array)
	 */
	public static void printWithSpacers(int[][] array, String top, String middle, String bottom, String left, String center, String right, String centerpoint) {
		
		//if there is a top spacer, print the top spacers for the array
		if(!top.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the top spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(top, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
			System.out.println();
		}//end if
		
		//iterate through the rest of the rows in the array to print them
		for(int i = 0; i < array.length; i++) {
			
			//first print the left spacer
			System.out.print(left);
			
			//print all of the elements of the row with padding on both sides (to match the length of the longest string)
			//with the center spacer in between
			for(int j = 0; j < array[i].length; j++) {
				padder(array[i][j], longestElementColumn(array, j));
				if(j < array[i].length-1) System.out.print(center);
			}//end for
			
			//print the right spacer
			System.out.println(right);
			
			//if not the last row and if the middle spacer exists, print the middle spacer; add a space that is the length of
			//the left space and print all the middle spacers for each column with the centerpoint in between
			if(!middle.equals("") && i < array.length-1) {
				printMultiple(left.length());
				for(int j = 0; j < array[i].length; j++) {
					printMultiple(middle, longestElementColumn(array, j));
					if(j < array[i].length-1) padder(centerpoint, center.length());
				}//end for
				System.out.println();
			}//end if
		}//end for
		
		//if there are bottom spacers, print the bottom spacers for the array
		if(!bottom.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the bottom spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(bottom, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
		}//end if
	}//end printWithSpacer method
	
	/**
	 * Pads an int with spaces on both sides to make it a certain length string and prints that. Just prints the given value if the padding length is
	 * less than or equal to the length of the given value.
	 * @param num   number to pad and then print.
	 * @param length   the length of the string of the number after padding.
	 */
	private static void padder(int num, int length) {
		
		//turn num to a string
		String strNum = Integer.toString(num);
		
		//find the number of spaces to add in total (round down)
		int spaceNum = length-strNum.length();
		
		//if even number of spaces, then print half on both sides; otherwise, print the lower half (rounding down) on the
		//left and the upper half (rounding up) on the right
		printMultiple(spaceNum/2);
		System.out.print(num);
		printMultiple(spaceNum/2 + spaceNum%2);
	}//end padder method

	/**
	 * Prints a 2d double array with spacers for the top, middle, bottom, right, center, and left of elements.
	 * @param array   2d array to be printed with spacers.
	 * @param top   the top spacer.
	 * @param middle   the middle spacer (between elements vertically).
	 * @param bottom   the bottom spacer.
	 * @param left   the left spacer.
	 * @param center   the center spacer (between elements horizontally).
	 * @param right   the right spacer.
	 * @param centerpoint   the symbol that goes between the middle and center spacers
	 * @throws NullPointerException if null array is passed
	 * @throws ArrayIndexOutOfBoundsException if a completely empty array is passed (fine if there is at least one empty row in the array)
	 */
	public static void printWithSpacers(double[][] array, String top, String middle, String bottom, String left, String center, String right, String centerpoint) {
		
		//if there is a top spacer, print the top spacers for the array
		if(!top.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the top spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(top, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
			System.out.println();
		}//end if
		
		//iterate through the rest of the rows in the array to print them
		for(int i = 0; i < array.length; i++) {
			
			//first print the left spacer
			System.out.print(left);
			
			//print all of the elements of the row with padding on both sides (to match the length of the longest string)
			//with the center spacer in between
			for(int j = 0; j < array[i].length; j++) {
				padder(array[i][j], longestElementColumn(array, j));
				if(j < array[i].length-1) System.out.print(center);
			}//end for
			
			//print the right spacer
			System.out.println(right);
			
			//if not the last row and if the middle spacer exists, print the middle spacer; add a space that is the length of
			//the left space and print all the middle spacers for each column with the centerpoint in between
			if(!middle.equals("") && i < array.length-1) {
				printMultiple(left.length());
				for(int j = 0; j < array[i].length; j++) {
					printMultiple(middle, longestElementColumn(array, j));
					if(j < array[i].length-1) padder(centerpoint, center.length());
				}//end for
				System.out.println();
			}//end if
		}//end for
		
		//if there are bottom spacers, print the bottom spacers for the array
		if(!bottom.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the bottom spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(bottom, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
		}//end if
	}//end printWithSpacer method
	
	/**
	 * Pads a double with spaces on both sides to make it a certain length string and prints that. Just prints the given value if the padding length is
	 * less than or equal to the length of the given value.
	 * @param num   number to pad and then print.
	 * @param length   the length of the string of the number after padding.
	 */
	private static void padder(double num, int length) {
		
		//turn num to a string
		String strNum = Double.toString(num);
		
		//find the number of spaces to add in total (round down)
		int spaceNum = length-strNum.length();
		
		//if even number of spaces, then print half on both sides; otherwise, print the lower half (rounding down) on the
		//left and the upper half (rounding up) on the right
		printMultiple(spaceNum/2);
		System.out.print(num);
		printMultiple(spaceNum/2 + spaceNum%2);
	}//end padder method

	/**
	 * Prints a 2d string array with spacers for the top, middle, bottom, right, center, and left of elements.
	 * @param array   2d array to be printed with spacers.
	 * @param top   the top spacer.
	 * @param middle   the middle spacer (between elements vertically).
	 * @param bottom   the bottom spacer.
	 * @param left   the left spacer.
	 * @param center   the center spacer (between elements horizontally).
	 * @param right   the right spacer.
	 * @param centerpoint   the symbol that goes between the middle and center spacers
	 * @throws NullPointerException if null array is passed
	 * @throws ArrayIndexOutOfBoundsException if a completely empty array is passed (fine if there is at least one empty row in the array)
	 */
	public static void printWithSpacers(String[][] array, String top, String middle, String bottom, String left, String center, String right, String centerpoint) {
		
		//if there is a top spacer, print the top spacers for the array
		if(!top.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the top spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(top, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
			System.out.println();
		}//end if
		
		//iterate through the rest of the rows in the array to print them
		for(int i = 0; i < array.length; i++) {
			
			//first print the left spacer
			System.out.print(left);
			
			//print all of the elements of the row with padding on both sides (to match the length of the longest string)
			//with the center spacer in between
			for(int j = 0; j < array[i].length; j++) {
				padder(array[i][j], longestElementColumn(array, j));
				if(j < array[i].length-1) System.out.print(center);
			}//end for
			
			//print the right spacer
			System.out.println(right);
			
			//if not the last row and if the middle spacer exists, print the middle spacer; add a space that is the length of
			//the left space and print all the middle spacers for each column with the centerpoint in between
			if(!middle.equals("") && i < array.length-1) {
				printMultiple(left.length());
				for(int j = 0; j < array[i].length; j++) {
					printMultiple(middle, longestElementColumn(array, j));
					if(j < array[i].length-1) padder(centerpoint, center.length());
				}//end for
				System.out.println();
			}//end if
		}//end for
		
		//if there are bottom spacers, print the bottom spacers for the array
		if(!bottom.equals("")) {
			
			//first print a space the length of the left spacer
			printMultiple(left.length());
			
			//print the bottom spacer for each column to match the length of the longest element in the column
			//with a space in between that is the same length as the center spacer
			for(int i = 0; i < array[0].length; i++) {
				printMultiple(bottom, longestElementColumn(array, i));
				if(i < array[0].length-1) printMultiple(center.length());
			}//end for
		}//end if
	}//end printWithSpacer method
	
	/**
	 * Pads a string with spaces on both sides to make it a certain length string and prints that. Just prints the given string if the padding length is
	 * less than or equal to the length of the given string.
	 * @param text   string to pad and then print.
	 * @param length   the length of the string of the text after padding.
	 */
	private static void padder(String text, int length) {
		
		//find the number of spaces to add in total (round down)
		int spaceNum = length-text.length();
		
		//if even number of spaces, then print half on both sides; otherwise, print the lower half (rounding down) on the
		//left and the upper half (rounding up) on the right
		printMultiple(spaceNum/2);
		System.out.print(text);
		printMultiple(spaceNum/2 + spaceNum%2);
	}//end padder method

	/**
	 * Prints any given string a specified number of times. Prints nothing if the specified length is less than or equal to 0.
	 * @param text   the text you want to print multiple times
	 * @param length  the amount of times you want to print the text
	 */
	private static void printMultiple(String text, int length) {
		for(int i = 0; i < length; i++) System.out.print(text);
	}//end printSpaces method
	
	/**
	 * Prints the space character a specified number of times. Prints nothing if the specified length is less than or equal to 0.
	 * @param length  the amount of times you want to print the text
	 */
	private static void printMultiple(int length) {
		for(int i = 0; i < length; i++) System.out.print(" ");
	}//end printSpaces method
	
	/**
	 * Reverses elements in a specified column of an integer 2d array. Throws an array index out of bounds exception if a 
	 * ragged array with an incomplete column (column where an element of a row might not exist) is asked to be reversed.
	 * @param array   2d array to have a column reversed.
	 * @param column    index of the column to be reversed.
	 * @throws NullPointerException if a null array is passed.
	 * @throws ArrayIndexOutOfBoundsException if an incomplete column in a ragged array is asked to be reversed.
	 */
	public static void reverseColumn(int[][] array, int column) {
		
		//iterate through half the array from the top and the bottom
		for(int i = 0; i < array.length/2; i++) {
			swapElement(array, i, column, array.length-1-i, column);
		}
	}//end reverseColumn method
	
	/**
	 * Reverses elements in a specified column of an double 2d array. Throws an array index out of bounds exception if a 
	 * ragged array with an incomplete column (column where an element of a row might not exist) is asked to be reversed.
	 * @param array   2d array to have a column reversed.
	 * @param column    index of the column to be reversed.
	 * @throws NullPointerException if a null array is passed.
	 * @throws ArrayIndexOutOfBoundsException if an incomplete column in a ragged array is asked to be reversed.
	 */
	public static void reverseColumn(double[][] array, int column) {
		
		//iterate through half the array from the top and the bottom and swap elements from top and bottom, moving inward
		for(int i = 0; i < array.length/2; i++) {
			swapElement(array, i, column, array.length-1-i, column);
		}
	}//end reverseColumn method
	
	/**
	 * Reverses elements in a specified column of an String 2d array. Throws an array index out of bounds exception if a 
	 * ragged array with an incomplete column (column where an element of a row might not exist) is asked to be reversed.
	 * @param array   2d array to have a column reversed.
	 * @param column    index of the column to be reversed.
	 * @throws NullPointerException if a null array is passed.
	 * @throws ArrayIndexOutOfBoundsException if an incomplete column in a ragged array is asked to be reversed.
	 */
	public static void reverseColumn(String[][] array, int column) {
		
		//iterate through half the array from the top and the bottom and swap elements from top and bottom, moving inward
		for(int i = 0; i < array.length/2; i++) {
			swapElement(array, i, column, array.length-1-i, column);
		}
	}//end reverseColumn method
	
  /**
	 * sums the elements of an indicated section of a 2d array
	 * @param array - the array to sum from
	 * @param direction - int for direction to sum (0 for full array, 1 for horizontal, 2 for vertical, 3 for up diagonal, 4 for down diagonal)
	 * @param position - the position to start from (along one axis)
	 * @return the sum of the desired section
	 */
	public static int sum (int[][] array, int direction, int position) {

		int sum = 0;//initialize sum as 0

		switch (direction) {//switch for different directions to sum

		case 0: for (int j=0;j<array.length;j++) {//for all elements vertical

			for (int i=0;i<array[j].length;i++) {//for all elements horizontal

				sum+=array[j][i];//add element to sum

			}

		} break;//break switch
		case 1: for (int j=0;j<array.length;j++) {//for all elements horizontally

			sum+=array[position][j];//add element one right to sum

		} break;//break switch
		case 2: for (int j=0;j<array.length;j++) {//for all elements vertically

			sum+=array[j][position];//add element one down to sum

		} break;//break switch
		case 3: for (int j=0;j<array.length;j++) {//for all values in diagonal

			try {
				sum+=array[position-j][0+j];//add value one down and one right to sm
			}catch (ArrayIndexOutOfBoundsException e) {//catch array out of bounds
				break;
			}//try adding next diagonal element, if no element exists break and return sum

		}break;//break switch
		case 4: for (int j=0;j<array.length;j++) {//for all elements along the line

			try {
				sum+=array[position+j][0+j];//add value one up and one right to sum
			}catch (ArrayIndexOutOfBoundsException e) { //catch array out of bounds
				break;
			}//try adding next diagonal element, if no element exists break and return sum
		}break;//break switch
		default: sum=-1; break;//default case set sum to 0
		}

		//returns sum
		return sum;

	}//ends sum

	/**
	 * sums the elements of an indicated section of a 2d double array
	 * @param array - the array to sum from
	 * @param direction - int for direction to sum (0 for full array, 1 for horizontal, 2 for vertical, 3 for up diagonal, 4 for down diagonal)
	 * @param position - the position to start from (along one axis)
	 * @return the sum of the desired section
	 */
	public static double sum (double[][] array, int direction, int position) {

		double sum = 0;//initialize sum as 0

		switch (direction) {//switch for different directions to sum

		case 0: for (int j=0;j<array.length;j++) {//for all elements vertical

			for (int i=0;i<array[j].length;i++) {//for all elements horizontal

				sum+=array[j][i];//add element to sum

			}

		} break;//break switch
		case 1: for (int j=0;j<array.length;j++) {//for all elements horizontally

			sum+=array[position][j];//add element one right to sum

		} break;//break switch
		case 2: for (int j=0;j<array.length;j++) {//for all elements vertically

			sum+=array[j][position];//add element one down to sum

		} break;//break switch
		case 3: for (int j=0;j<array.length;j++) {//for all values in diagonal

			try {
				sum+=array[position-j][0+j];//add value one down and one right to sm
			}catch (ArrayIndexOutOfBoundsException e) {//catch array out of bounds
				break;
			}//try adding next diagonal element, if no element exists break and return sum

		}break;//break switch
		case 4: for (int j=0;j<array.length;j++) {//for all elements along the line

			try {
				sum+=array[position+j][0+j];//add value one up and one right to sum
			}catch (ArrayIndexOutOfBoundsException e) { //catch array out of bounds
				break;
			}//try adding next diagonal element, if no element exists break and return sum
		}break;//break switch
		default: sum=-1; break;//default case set sum to 0
		}

		//returns sum
		return sum;

	}//ends sum
  
	/**
	 * swap all elements between the two given columns
	 * @param array   2D multidimentional array
	 * @param col1	the first given column
	 * @param col2	the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapCol(int [][] arr, int col1, int col2)
	{
		// decrements the given columns numbers to match the indexes
		col1--;
		col2--;

		// swap all the elements between the two given columns
		for (int row = 0, temp = 0; row < arr.length; row++)
		{
			temp = arr[row][col1];
			arr[row][col1] = arr[row][col2];
			arr[row][col2] = temp;
		} // end for
	}// end swapCol


	/**
	 * swap all elements between the two given columns
	 * @param array   2D multidimentional array
	 * @param col1  the first given column
	 * @param col2  the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapCol(String [][] arr, int col1, int col2)
	{
		// decrements the given columns numbers to match the indexes
		col1--;
		col2--;

		// swap all the elements between the two given columns
		for (int row = 0; row < arr.length; row++)
		{
			String temp = "";
			temp = arr[row][col1];
			arr[row][col1] = arr[row][col2];
			arr[row][col2] = temp;
		} // end for
	}// end swapCol

	/**
	 * swap all elements between the two given columns
	 * @param array   2D multidimentional array
	 * @param col1  the first given column
	 * @param col2  the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapCol(double [][] arr, int col1, int col2)
	{
		// decrements the given columns numbers to match the indexes
		col1--;
		col2--;

		// swap all the elements between the two given columns
		for (int row = 0; row < arr.length; row++)
		{
			double temp = 0;
			temp = arr[row][col1];
			arr[row][col1] = arr[row][col2];
			arr[row][col2] = temp;
		} // end for
	}// end swapCol

	/**
	 * swap all elements between the two given rows
	 * @param array   2D multidimentional array
	 * @param row1	the first given row
	 * @param row2	the second given row
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the rows are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapRow(int [][] arr, int row1, int row2)
	{
		// decrements the given columns numbers to match the indexes
		row1--;
		row2--;
		// swap all the elements between the two given rows
		for (int col = 0, temp = 0; col < arr[0].length; col++)
		{
			temp = arr[row1][col];
			arr[row1][col] = arr[row2][col];
			arr[row2][col] = temp;
		} // end for		}
	} // end swapRow

	/**
	 * swap all elements between the two given rows
	 * @param array   2D multidimentional array
	 * @param row1  the first given row
	 * @param row2  the second given row
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the rows are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapRow(String [][] arr, int row1, int row2)
	{
		// decrements the given columns numbers to match the indexes
		row1--;
		row2--;
		// swap all the elements between the two given rows
		for (int col = 0; col < arr[0].length; col++)
		{
			String temp = "";
			temp = arr[row1][col];
			arr[row1][col] = arr[row2][col];
			arr[row2][col] = temp;
		} // end for        }
	} // end swapRow

	/**
	 * swap all elements between the two given rows
	 * @param array   2D multidimentional array
	 * @param row1  the first given row
	 * @param row2  the second given row
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the rows are out of bounds
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the array is jagged
	 */
	public static void swapRow(double [][] arr, int row1, int row2)
	{
		// decrements the given columns numbers to match the indexes
		row1--;
		row2--;
		// swap all the elements between the two given rows
		for (int col = 0; col < arr[0].length; col++)
		{
			double temp = 0;
			temp = arr[row1][col];
			arr[row1][col] = arr[row2][col];
			arr[row2][col] = temp;
		} // end for        }
} // end swapRow

	/**
	 * swap 2 elements given the position of them
	 * @param array   2D multidimentional array
	 * @param row1  the first given row
	 * @param row2  the second given row
	 * @param col1  the first given column
	 * @param col2  the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static void swapElement(int [][] arr, int row1, int col1, int row2, int col2)
	{
		// swapping two elements given the positions of them
		int temp = arr[row1][col1];
		arr[row1][col1] = arr[row2][col2];
		arr[row2][col2] = temp;
	} // end swapElement

	/**
	 * swap 2 elements given the position of them
	 * @param array   2D multidimentional array
	 * @param row1  the first given row
	 * @param row2  the second given row
	 * @param col1  the first given column
	 * @param col2  the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static void swapElement(String [][] arr, int row1, int col1, int row2, int col2)
	{
		// swapping two elements given the positions of them
		String temp = arr[row1][col1];
		arr[row1][col1] = arr[row2][col2];
		arr[row2][col2] = temp;
	} // end swapElement

	/**
	 * swap 2 elements given the position of them
	 * @param array   2D multidimentional array
	 * @param row1  the first given row
	 * @param row2  the second given row
	 * @param col1  the first given column
	 * @param col2  the second given column
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the columns/rows are out of bounds
	 */
	public static void swapElement(double [][] arr, int row1, int col1, int row2, int col2)
	{
		// swapping two elements given the positions of them
		double temp = arr[row1][col1];
		arr[row1][col1] = arr[row2][col2];
		arr[row2][col2] = temp;
	} // end swapElement

	/**
	 * transpose the originnal array and return a new transposed one (doesn't work for ragged array)
	 * @param array   2D multidimentional array
	 * @return transposedArr 	transposed version of the orignial 2D array
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty

	 */
	public static int[][] transposedArr(int [][] arr)
	{

		// initializes the transposed array
		int transposedArr[][] = new int[arr[0].length][arr.length];

		// transpose the array
		for (int row = 0; row < arr.length; row++)
		{
			for (int col = 0; col < arr[0].length; col++)
			{
				transposedArr[col][row] = arr[row][col];
			}
		}

		return transposedArr;
	} // end transposedArr

	/**
	 * transpose the originnal array and return a new transposed one (doesn't work for ragged array)
	 * @param array   2D multidimentional array
	 * @return transpoeedArr 	transposed version of the orignial 2D array
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static String[][] transposedArr(String [][] arr)
	{

		// initializes the transposed array
		String transposedArr[][] = new String[arr[0].length][arr.length];

		// transpose the array
		for (int row = 0; row < arr.length; row++)
		{
			for (int col = 0; col < arr[0].length; col++)
			{
				transposedArr[col][row] = arr[row][col];
			} // end for
		} // end for
		return transposedArr;
	} // end transposedArr

	/**
	 * transpose the originnal array and return a new transposed one (doesn't work for ragged array)
	 * @param array   2D multidimentional array
	 * @return transpoeedArr 	transposed version of the orignial 2D array
	 * @throws java.lang.NullPointerException if the given array is null
	 * @throws java.lang.ArrayIndexOutOfBoundsException if the given array is empty
	 */
	public static double[][] transposedArr(double [][] arr)
	{
		// initializes the transposed array
		double transposedArr[][] = new double[arr[0].length][arr.length];

		// transpose the array
		for (int row = 0; row < arr.length; row++)
		{
			for (int col = 0; col < arr[row].length; col++)
			{
				transposedArr[col][row] = arr[row][col];
			}  // end for
		} // end for
		return transposedArr;
	}// end transposedArr

	/**
	 * Apply a function to a column in a 2D array. The return must be manually casted to the type they want to return inside the lambda function.
	 * Example:<br><br>
	 * <code>
	 * 	int[][] myArray = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };<br>
	 * <br>
	 *	// This updates the array and adds 10 to each element in the row at index 1<br>
	 * 	int[][] updatedArray = updateRow(myArray, 1, (i) -> { return (int) i + 10; });<br>
	 * <br>
	 * 	// The updated array will be the same as the array on the right<br>
	 * 	assert checkIfCopy(updatedArray, { {1, 2, 3}, {14, 15, 16}, {7, 8, 9} });<br>
	 * </code>
	 * @param arr   The array to update
	 * @param index   The index of the column to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static int[][] updateColumn(int[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each row
		for (int i = 0; i < arr.length; i++)
		{
			// Try to update the value in the column at the index - if it doesn't exist, go on to the next row
			try
			{
				if (i < index) continue;
				arr[i][i-index] = (int) fn.updateVal(arr[i][i-index]);
			}
			catch (ArrayIndexOutOfBoundsException e) { continue; }
		}

		return arr;
	}

	/**
	 * Apply a function to a column in a 2D array. The return must be manually casted to the type they want to return inside the lambda function.
	 * Example:<br><br>
	 * <code>
	 * 	double[][] myArray = { {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0} };<br>
	 * <br>
	 *	// This updates the array and adds 10 to each element in the row at index 1<br>
	 * 	double[][] updatedArray = updateRow(myArray, 2, (i) -> { return (double) i * Math.PI; });<br>
	 * <br>
	 * 	// The updated array will be the same as the array on the right<br>
	 * 	assert checkIfCopy(updatedArray, { {1, 2, 3}, {14, 15, 16}, {21.99093857, 25.1325012, 28.27406388} });<br>
	 * </code>
	 * @param arr   The array to update
	 * @param index   The index of the column to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static double[][] updateColumn(double[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each row
		for (int i = 0; i < arr.length; i++)
		{
			// Try to update the value in the column at the index - if it doesn't exist, go on to the next row
			try
			{
				if (i < index) continue;
				arr[i][i-index] = (double) fn.updateVal(arr[i][i-index]);
			}
			catch (ArrayIndexOutOfBoundsException e) { continue; }
		}

		return arr;
	}

	/**
	 * Apply a function to a column in a 2D array. The return must be manually casted to the type they want to return inside the lambda function.
	 * Example:<br><br>
	 * <code>
	 * 	boolean[][] myArray = { {true, true, false}, {false, true, false}, {true, false, true} };<br>
	 * <br>
	 *	// This updates the array and adds 10 to each element in the row at index 1<br>
	 * 	boolean[][] updatedArray = updateRow(myArray, 1, (i) -> { return (boolean) true; });<br>
	 * <br>
	 * 	// The updated array will be the same as the array on the right<br>
	 * 	assert checkIfCopy(updatedArray, { {true, true, false}, {true, true, true}, {true, false, true} });<br>
	 * </code>
	 * @param arr   The array to update
	 * @param index   The index of the column to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static boolean[][] updateColumn(boolean[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each row
		for (int i = 0; i < arr.length; i++)
		{
			// Try to update the value in the column at the index - if it doesn't exist, go on to the next row
			try
			{
				if (i < index) continue;
				arr[i][i-index] = (boolean) fn.updateVal(arr[i][i-index]);
			}
			catch (ArrayIndexOutOfBoundsException e) { continue; }
		}

		return arr;
	}

	/**
	 * Apply a function to a column in a 2D array. The return must be manually casted to the type they want to return inside the lambda function.
	 * Example:<br><br>
	 * <code>
	 * 	String[][] myArray = { {"first word", "second word", "third word"}, {"fourth word", "fifth word", "sixth word"}, {"seventh word", "eighth word", "ninth word"} };<br>
	 * <br>
	 *	// This updates the array and adds 10 to each element in the row at index 1<br>
	 * 	String[][] updatedArray = updateRow(myArray, 1, (i) -> { return (String) i + "!"; });<br>
	 * <br>
	 * 	// The updated array will be the same as the array on the right<br>
	 * 	assert checkIfCopy(updatedArray, { {"first word", "second word", "third word"}, {"fourth word!", "fifth word!", "sixth word!"}, {"seventh word", "eighth word", "ninth word"} });<br>
	 * </code>
	 * @param arr   The array to update
	 * @param index   The index of the column to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static String[][] updateColumn(String[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each row
		for (int i = 0; i < arr.length; i++)
		{
			// Try to update the value in the column at the index - if it doesn't exist, go on to the next row
			try
			{
				if (i < index) continue;
				arr[i][i-index] = (String) fn.updateVal(arr[i][i-index]);
			}
			catch (ArrayIndexOutOfBoundsException e) { continue; }
		}

		return arr;
	}

	/**
	 * Apply a function to a column in a 2D array. The return must be manually casted to the type they want to return inside the lambda function.
	 * Example:<br><br>
	 * <code>
	 * 	char[][] myArray = { {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'} };<br>
	 * <br>
	 *	// This updates the array and adds 10 to each element in the row at index 1<br>
	 * 	char[][] updatedArray = updateRow(myArray, 1, (i) -> { return (char) i + 5; });<br>
	 * <br>
	 * 	// The updated array will be the same as the array on the right<br>
	 * 	assert checkIfCopy(updatedArray, { {'a', 'b', 'c'}, {'i', 'j', 'k'}, {'g', 'h', 'i'} });<br>
	 * </code>
	 * @param arr   The array to update
	 * @param index   The index of the column to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static char[][] updateColumn(char[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each row
		for (int i = 0; i < arr.length; i++)
		{
			// Try to update the value in the column at the index - if it doesn't exist, go on to the next row
			try
			{
				if (i < index) continue;
				arr[i][i-index] = (char) fn.updateVal(arr[i][i-index]);
			}
			catch (ArrayIndexOutOfBoundsException e) { continue; }
		}

		return arr;
	}



	/**
	 * Apply a function to a diagonal (down and to the right) in a 2D array. Always starts at column 0. The return must be manually casted to the type they want to return inside the lambda function.
	 * @param arr   The array to update
	 * @param index   The index of the row to start updating at
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static int[][] updateDiagonal(int[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through the row at index, pass each value to the function
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (int) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a diagonal (down and to the right) in a 2D array. Always starts at column 0. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to start updating at
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static double[][] updateDiagonal(double[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through the row at index, pass each value to the function
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (double) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a diagonal (down and to the right) in a 2D array. Always starts at column 0. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to start updating at
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static boolean[][] updateDiagonal(boolean[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through the row at index, pass each value to the function
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (boolean) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a diagonal (down and to the right) in a 2D array. Always starts at column 0. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to start updating at
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static String[][] updateDiagonal(String[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through the row at index, pass each value to the function
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (String) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a diagonal (down and to the right) in a 2D array. Always starts at column 0. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to start updating at
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static char[][] updateDiagonal(char[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through the row at index, pass each value to the function
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (char) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a row in a 2D array. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static int[][] updateRow(int[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each value in the row, update it
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (int) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a row in a 2D array. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static double[][] updateRow(double[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each value in the row, update it
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (double) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a row in a 2D array. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static boolean[][] updateRow(boolean[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each value in the row, update it
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (boolean) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a row in a 2D array. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static String[][] updateRow(String[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each value in the row, update it
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (String) fn.updateVal(arr[index][i]);

		return arr;
	}

	/**
	 * Apply a function to a row in a 2D array. The return must be manually casted to the type they want to return inside the lambda function. See updateRow for examples.
	 * @param arr   The array to update
	 * @param index   The index of the row to update
	 * @param fn	A lambda function that updates each value
	 * @return the updated array
	 * @throws NullPointerException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static char[][] updateRow(char[][] arr, int index, UpdateFunction fn) throws NullPointerException, ArrayIndexOutOfBoundsException
	{
		// Go through each value in the row, update it
		for (int i = 0; i < arr[index].length; i++)
			arr[index][i] = (char) fn.updateVal(arr[index][i]);

		return arr;
	}
	
} // end MDArray class