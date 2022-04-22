/**
 * Name: Luke Headington
 * Course: ICS4U
 * Teacher: Mrs. McCaffery
 * Date: Nov. 16 2021
 * Description: Resuable class for array methods
 */
package array;

import java.util.Random;
import chess.WorldState;
import inputOutput.IO;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Array class
 * @author Luke Headington
 * @since November 2021
 */
public class Array 
{

	/**
	 * Creates an empty integer array of variable size
	 * @param size - size of the array
	 * @return empty array
	 */
	public static int [] createEmptyArray(int size) {

		//creates an empty array of given size
		int[] newArray=new int[size];

		//returns the new array
		return newArray;

	}//end createEmptyArray

	/**
	 * Creates an empty string array of variable size
	 * @param size - size of the array
	 * @return empty array
	 */
	public static String [] createEmptyStringArray(int size) {

		//creates an empty array of given size
		String [] newArray=new String [size];

		//returns the new array
		return newArray;

	}//end createEmptyStringArray

	/**
	 * Creates an empty double array of variable size
	 * @param size - size of the array
	 * @return empty array
	 */
	public static double [] createEmptyDoubleArray(int size) {

		//creates an empty array of given size
		double [] newArray=new double [size];

		//returns the new array
		return newArray;

	}//end createEmptyDoubleArray

	/**
	 * Creates a random integer array of variable size
	 * @param size - size of the array
	 * @param max - max value of the array
	 * @param min - min value of the array
	 * @return random array
	 */
	public static int [] createRandomArray(int size, int min, int max) {

		//creates an empty array of given size
		int[] newArray=new int[size];

		//initializes a new random
		Random random = new Random();

		//loop to fill random variables
		for (int j=0;j<size;j++) {

			//takes each index of the new array and fills it with a random element between max and min
			newArray[j]=random.nextInt(max + 1 - min) + min;

		} 

		//returns the new array
		return newArray;

	}//end createRandomIntArray

	/**
	 * creates an integer array of variable size with user determined elements
	 * @param size - the size of the empty array
	 * @return user defined array
	 */
	public static int [] createUserDefinedArray(int size) {

		//creates an empty array of size indicated
		int[] newArray=new int[size];

		//loop to fill array
		for (int j=0;j<size;j++) {

			//for every index of the array, let the user input an int to fill it
			newArray[j]=IO.pureReadInt();


		}

		//return new array
		return newArray;

	}//end createUserDefinedArray

	/**
	 * creates a string array of variable size with user determined elements
	 * @param size - the size of the empty array
	 * @return user defined array
	 */
	public static String [] createUserDefinedStringArray(int size) {

		//creates an empty array of size indicated
		String [] newArray=new String[size];

		//loop to fill array
		for (int j=0;j<size;j++) {

			//for every index of the array, let the user input a string to fill it
			newArray[j]=IO.pureReadString();

		}

		//return new array
		return newArray;

	}//end createUserDefinedStringArray

	/**
	 * creates a double array of variable size with user determined elements
	 * @param size - the size of the empty array
	 * @return user defined array
	 */
	public static double [] createUserDefinedDoubleArray(int size) {

		//creates an empty array of size indicated
		double [] newArray=new double [size];

		//loop to fill array
		for (int j=0;j<size;j++) {

			//for every index of the array, let the user input a string to fill it
			newArray[j]=IO.pureReadDouble();

		}

		//return new array
		return newArray;

	}//end createUserDefinedDoubleArray

	/**
	 * prints the contents of an integer array per line
	 * @param array - the array to print
	 * @return void
	 */
	public static void print(int [] array) {

		//loop to print values
		for (int j:array) {

			//for every index in the area, print the element and a space
			System.out.print(j +" ");

		}

	}//end print

	/**
	 * prints the contents of a string array per line
	 * @param array - the array to print
	 * @return void
	 */
	public static void print(String [] array) {

		//loop to print values
		for (String j:array) {

			//for every index in the area, print the element and a space
			System.out.print(j +" ");

		}

	}//end print

	/**
	 * prints the contents of a double array per line
	 * @param array - the array to print
	 * @return void
	 */
	public static void print(double [] array) {

		//loop to print values
		for (double j:array) {

			//for every index in the area, print the element and a space
			System.out.print(j +" ");

		}

	}//end print

	/**
	 * finds the index of the largest value in an int array
	 * @param array - the array to search
	 * @return index of the largest element
	 */
	public static int findMax(int [] array) {

		//initialize the max as array index 0, and its index as zero
		int max = array[0];
		int position = 0;

		//loop to search all indices
		for (int j=0;j<array.length;j++) {

			//if element at index j is larger than current max, update max and position
			if (array[j]>max) {

				//update max to array at index j, and position to j
				max = array[j];
				position = j;

			}

		}

		//return max value index
		return position;

	}//end findMax

	/**
	 * finds the index of the smallest value in a String array
	 * @param array - the array to search
	 * @return index of the smallest element
	 */
	public static int findMin(String [] array) {

		int[] min = new int[0];
		int[] subMin = new int[0];
		int checkPosition = 1;
		int minPosition = 1;
		min = Array.insertElement(min, 0, 0);
		
		for (int j=1;j<array.length;j++) {

			if (array[j].toCharArray()[0]>array[min[0]].toCharArray()[0]) {
				min = new int[0];
				min = Array.insertElement(min, j, 0);
			}else if (array[j].toCharArray()[0]==array[min[0]].toCharArray()[0]) {
				min = Array.insertElement(min, j, minPosition);
				minPosition++;
			}

		}
					
		while(min.length>1) {
			
			subMin = Array.insertElement(subMin, min[0], 0);
			minPosition = 1;
			
			for (int j = 0;j<min.length;j++) {
				
				if (array[min[j]].toCharArray()[checkPosition]<array[min[0]].toCharArray()[checkPosition]) {
					min = new int[0];
					min = Array.insertElement(min, j, 0);
				}else if (array[min[j]].toCharArray()[checkPosition]==array[min[0]].toCharArray()[checkPosition]) {
					min = Array.insertElement(min, j, minPosition);
					minPosition++;
				}
				
			}
			
			min = Array.copyArray(subMin);
			checkPosition++;
			
		}
	
		//return max value index
		return min[0];

	}//end findMin

	/**
	 * finds the index of the smallest value in an int array
	 * @param array - the array to search
	 * @return index of the smallest element
	 */
	public static int findMin(int [] array) {

		//initialize the min as array index 0, and its position as 0
		int min = array[0];
		int position = 0;

		//loop to check all indices
		for (int j=0;j<array.length;j++) {

			//if array at index j is smaller than current min, update min and position
			if (array[j]<min) {

				//set min to array at j, and position to j
				min = array[j];
				position = j;

			}

		}

		//return position
		return position;

	}//end findMin	

	/**
	 * finds the index of the largest value in a String array
	 * @param array - the array to search
	 * @return index of the largest element
	 */
	public static int findMax(String [] array) {

		int[] max = new int[0];
		int[] subMax = new int[0];
		int checkPosition = 1;
		int maxPosition = 1;
		max = Array.insertElement(max, 0, 0);
		
		for (int j=1;j<array.length;j++) {

			if (array[j].toCharArray()[0]>array[max[0]].toCharArray()[0]) {
				max = new int[0];
				max = Array.insertElement(max, j, 0);
			}else if (array[j].toCharArray()[0]==array[max[0]].toCharArray()[0]) {
				max = Array.insertElement(max, j, maxPosition);
				maxPosition++;
			}

		}
					
		while(max.length>1) {
			
			subMax = Array.insertElement(subMax, max[0], 0);
			maxPosition = 1;
			
			for (int j = 0;j<max.length;j++) {
				
				if (array[max[j]].toCharArray()[checkPosition]>array[max[0]].toCharArray()[checkPosition]) {
					max = new int[0];
					max = Array.insertElement(max, j, 0);
				}else if (array[max[j]].toCharArray()[checkPosition]==array[max[0]].toCharArray()[checkPosition]) {
					max = Array.insertElement(max, j, maxPosition);
					maxPosition++;
				}
				
			}
			
			max = Array.copyArray(subMax);
			checkPosition++;
			
		}
	
		//return max value index
		return max[0];

	}//end findMax

	/**
	 * finds the index of the largest value in a double array
	 * @param array - the array to search
	 * @return index of the smallest element
	 */
	public static int findMax(double [] array) {

		//initialize the max as array index 0, and its index as zero
		double max = array[0];
		int position = 0;

		//loop to search all indices
		for (int j=0;j<array.length;j++) {

			//if element at index j is larger than current max, update max and position
			if (array[j]>max) {

				//update max to array at index j, and position to j
				max = array[j];
				position = j;

			}

		}

		//return max value index
		return position;

	}//end findMax

	/**
	 * finds the index of the smallest value in a double array
	 * @param array - the array to search
	 * @return index of the smallest element
	 */
	public static int findMin(double [] array) {

		//initialize the min as array index 0, and its position as 0
		double min = array[0];
		int position = 0;

		//loop to check all indices
		for (int j=0;j<array.length;j++) {

			//if array at index j is smaller than current min, update min and position
			if (array[j]<min) {

				//set min to array at j, and position to j
				min = array[j];
				position = j;

			}

		}

		//return position
		return position;

	}//end findMin

	/**
	 * swaps the elements of two indices in an int array
	 * @param array - the array to alter
	 * @param position1 - the first index to change
	 * @param position2 - the second index to change
	 * @return void
	 */
	public static void swapElements (int [] array, int position1, int position2) {

		array [position1] += array [position2];
		array [position2] = array [position1] - array[position2];
		array [position1] = array[position1] - array[position2];

	}//end swapElements

	/**
	 * swaps the elements of two indices in a string array
	 * @param array - the array to alter
	 * @param position1 - the first index to change
	 * @param position2 - the second index to change
	 * @return void
	 */
	public static void swapElements (String [] array, int position1, int position2) {

		//store values of array at position 1 and 2 into new ints
		String p1=array [position1];
		String p2=array [position2];

		//set array at position 1 to value at position 2, and array at position 2 to value formerly at position 1
		array [position1] = p2;
		array [position2] = p1;

	}//end swapElements

	/**
	 * swaps the elements of two indices in a double array
	 * @param array - the array to alter
	 * @param position1 - the first index to change
	 * @param position2 - the second index to change
	 * @return void
	 */
	public static void swapElements (double [] array, int position1, int position2) {

		array [position1] += array [position2];
		array [position2] = array [position1] - array[position2];
		array [position1] = array[position1] - array[position2];

	}//end swapElements

	/**
	 * finds the index of the first appearance of a given element in an int array, otherwise returns -1
	 * @param array - the array to search
	 * @param value - the element to search for
	 * @return the index of the desired element
	 */
	public static int findElement (int value, int [] array) {

		//initialize position as -1, default if element cannot be found
		int position = -1;

		//array to check all indices
		for (int j=0;j<array.length;j++) {

			//if array at j is equal to the desired element record and stop, otherwise continue loop
			if (array[j]==value) {

				//if array j is equal to value, set position to j and break for loop
				position = j;
				break;

			}

		}

		//return position
		return position;

	}//end findElement

	/**
	 * finds the index of the first appearance of a given element in a char array, otherwise returns -1
	 * @param array - the array to search
	 * @param value - the element to search for
	 * @return the index of the desired element
	 */
	public static int findElement (char value, char [] array) {

		//initialize position as -1, default if element cannot be found
		int position = -1;

		//array to check all indices
		for (int j=0;j<array.length;j++) {

			//if array at j is equal to the desired element record and stop, otherwise continue loop
			if (array[j]==value) {

				//if array j is equal to value, set position to j and break for loop
				position = j;
				break;

			}

		}

		//return position
		return position;

	}//end findElement

	/**
	 * finds the index of the first appearance of a given element in a string array, otherwise returns -1
	 * @param array - the array to search
	 * @param value - the element to search for
	 * @return the index of the desired element
	 */
	public static int findElement (String element, String [] array) {

		//initialize position as -1, default if element cannot be found
		int position = -1;

		//array to check all indices
		for (int j=0;j<array.length;j++) {

			if (array[j]!=null) {
				//if array at j is equal to the desired element record and stop, otherwise continue loop
				if (array[j].toUpperCase().equals(element.toUpperCase())) {

					//if array j is equal to value, set position to j and break for loop
					position = j;
					break;

				}

			}

		}	

		//return position
		return position;

	}//end findElement

	/**
	 * finds the index of the first appearance of a given element in a double array, otherwise returns -1
	 * @param array - the array to search
	 * @param value - the element to search for
	 * @return the index of the desired element
	 */
	public static int findElement (double element, double [] array) {

		//initialize position as -1, default if element cannot be found
		int position = -1;

		//array to check all indices
		for (int j=0;j<array.length;j++) {

			//if array at j is equal to the desired element record and stop, otherwise continue loop
			if (array[j]==element) {

				//if array j is equal to value, set position to j and break for loop
				position = j;
				break;

			}

		}

		//return position
		return position;

	}//end findElement

	/**
	 * finds the index of the first appearance of a given element in a 2d string array, otherwise returns -1
	 * @param array - the array to search
	 * @param element - the element to search for
	 * @return a two digit integer representing both indices, ie position = 32 means position = [3][2]
	 */
	public static int findElement (String element, String [] [] array) {

		//initialize position as -1, default if element cannot be found
		int position = -1;

		//array to check all indices
		for (int j=0;j<array.length;j++) {

			for (int i=0;i<array[j].length;i++) {

				//if array at j is equal to the desired element record and stop, otherwise continue loop
				if (array[j][i].equalsIgnoreCase(element)) {

					//if array j i is equal to value, set position to j*10 + i and break for loop
					position = j*10+i;
					break;

				}

			}

		}

		//return position
		return position;

	}//end findElement

	/**
	 * counts the number of times an element appears in an int array
	 * @param array - the array to be searched
	 * @param value - the element to search for
	 * @return the number of appearances of the desired element
	 */
	public static int countElements(int value, int [] array) {

		//initialize element count at 0
		int numOfElements = 0;

		//loop to check all indices
		for (int j:array) {

			//if array at j is desired element, increment element count, otherwise continue loop
			if (j==value) {

				numOfElements++;

			}

		}

		//return final element count
		return numOfElements;

	}//end countElements

	/**
	 * counts the number of times a case sensitive element appears in a string array
	 * @param array - the array to be searched
	 * @param value - the element to search for
	 * @return the number of appearances of the desired element
	 */
	public static int countElements(String value, String [] array) {

		//initialize element count at 0
		int numOfElements = 0;

		//loop to check all indices
		for (String j:array) {

			//if array at j is desired element, increment element count, otherwise continue loop
			if (j.equals(value)) {

				//increment element count
				numOfElements++;

			}

		}

		//return final element count
		return numOfElements;

	}//end countElements

	/**
	 * counts the number of times an element appears in a double array
	 * @param array - the array to be searched
	 * @param value - the element to search for
	 * @return the number of appearances of the desired element
	 */
	public static int countElements(double value, double [] array) {

		//initialize element count at 0
		int numOfElements = 0;

		//loop to check all indices
		for (double j:array) {

			//if array at j is desired element, increment element count, otherwise continue loop
			if (j==value) {

				//increment element count
				numOfElements++;

			}

		}

		//return final element count
		return numOfElements;

	}//end countElements

	/**
	 * copies the values of an int array into a new array, in a different position
	 * @param originalArray - the array to be copied
	 * @return the copy array
	 */
	public static int [] copyArray(int [] originalArray) {

		//initialize copied array as empty array of length = length of original array
		int [] newArray = new int[originalArray.length];

		//loop to set all elements of new array to elements of old array
		for (int j=0;j<originalArray.length;j++) {

			//set element at index j of newArray to element at index j of originalArray
			newArray[j] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end copyArray

	/**
	 * copies the values of an int array into a new array, in a different position
	 * @param originalArray - the array to be copied
	 * @return the copy array
	 */
	public static char [] copyArray(char [] originalArray) {

		//initialize copied array as empty array of length = length of original array
		char [] newArray = new char[originalArray.length];

		//loop to set all elements of new array to elements of old array
		for (int j=0;j<originalArray.length;j++) {

			//set element at index j of newArray to element at index j of originalArray
			newArray[j] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end copyArray

	/**
	 * copies the values of a string array into a new array, in a different position
	 * @param originalArray - the array to be copied
	 * @return the copy array
	 */
	public static String [] copyArray(String [] originalArray) {

		//initialize copied array as empty array of length = length of original array
		String [] newArray = new String[originalArray.length];

		//loop to set all elements of new array to elements of old array
		for (int j=0;j<originalArray.length;j++) {

			//set element at index j of newArray to element at index j of originalArray
			newArray[j] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end copyArray

	/**
	 * copies the values of a double array into a new array, in a different position
	 * @param originalArray - the array to be copied
	 * @return the copy array
	 */
	public static double [] copyArray(double [] originalArray) {

		//initialize copied array as empty array of length = length of original array
		double [] newArray = new double[originalArray.length];

		//loop to set all elements of new array to elements of old array
		for (int j=0;j<originalArray.length;j++) {

			//set element at index j of newArray to element at index j of originalArray
			newArray[j] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end copyArray

	/**
	 * checks if a given int array is a copy, but not identical to, another array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are copies
	 */
	public static boolean checkIfCopy(int [] ... arrays) {

		//initialize boolean for copy check as default true
		boolean isCopy = true;

		//if the arrays are identical or their sizes are different, return false
		if (Array.checkIfIdentical(arrays[0], arrays[1])==true||arrays[0].length!=arrays[1].length) {

			//sets boolean to false
			isCopy = false;

		}else {

			//loop to compare each element at each index
			for (int j=0;j<arrays[0].length;j++) {

				//if array1 at index j is not equal to array2 at index j, update isCopy and break loop, otherwise continue
				if (arrays[0][j]!=arrays[1][j]) {

					//set isCopy to false, break loop
					isCopy = false;
					break;

				}

			}
		}

		//return boolean
		return isCopy;

	}//end checkIfCopy

	/**
	 * checks if a given string array is a copy, but not identical to, another array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are copies
	 * @throws NullPointerException when a null array is sent as an argument
	 */
	public static boolean checkIfCopy(String [] ... arrays) {

		//initialize boolean for copy check as default true
		boolean isCopy = true;

		//if the arrays are identical or their sizes are different, return false
		if (Array.checkIfIdentical(arrays[0], arrays[1])==true||arrays[0].length!=arrays[1].length) {

			//sets boolean to false
			isCopy = false;

		}else {

			//loop to compare each element at each index
			for (int j=0;j<arrays[0].length;j++) {

				//if array1 at index j is not equal to array2 at index j, update isCopy and break loop, otherwise continue
				if (arrays[0][j]!=arrays[1][j]) {

					//set isCopy to false, break loop
					isCopy = false;
					break;

				}

			}
		}

		//return boolean
		return isCopy;

	}//end checkIfCopy

	/**
	 * checks if a given double array is a copy, but not identical to, another array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are copies
	 */
	public static boolean checkIfCopy(double [] ... arrays) {

		//initialize boolean for copy check as default true
		boolean isCopy = true;

		//if the arrays are identical or their sizes are different, return false
		if (Array.checkIfIdentical(arrays[0], arrays[1])==true||arrays[0].length!=arrays[1].length) {

			//sets boolean to false
			isCopy = false;

		}else {

			//loop to compare each element at each index
			for (int j=0;j<arrays[0].length;j++) {

				//if array1 at index j is not equal to array2 at index j, update isCopy and break loop, otherwise continue
				if (arrays[0][j]!=arrays[1][j]) {

					//set isCopy to false, break loop
					isCopy = false;
					break;

				}

			}
		}

		//return boolean
		return isCopy;

	}//end checkIfCopy

	/**
	 * determines if 2 int arrays are the same array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are identical
	 */
	public static boolean checkIfIdentical(int [] ... arrays) {

		//initialize boolean identical as default false
		boolean identical = false;

		//if the two arrays have the same memory position, set boolean to true
		if (arrays[0]==arrays[1]) {

			//set identical to true
			identical = true;

		}

		//return identical
		return identical;

	}//end checkIfIdentical

	/**
	 * determines if 2 string arrays are the same array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are identical
	 */
	public static boolean checkIfIdentical(String [] ... arrays) {

		//initialize boolean identical as default false
		boolean identical = false;

		//if the two arrays have the same memory position, set boolean to true
		if (arrays[0]==arrays[1]) {

			//set identical to true
			identical = true;

		}

		//return identical
		return identical;

	}//end checkIfIdentical

	/**
	 * determines if 2 double arrays are the same array
	 * @param arrays - the arrays to check
	 * @return whether or not the arrays are identical
	 */
	public static boolean checkIfIdentical(double [] ... arrays) {

		//initialize boolean identical as default false
		boolean identical = false;

		//if the two arrays have the same memory position, set boolean to true
		if (arrays[0]==arrays[1]) {

			//set identical to true
			identical = true;

		}

		//return identical
		return identical;

	}//end checkIfIdentical

	/**
	 * replaces an element of an array at a given index
	 * @param array - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to replace
	 * @return void
	 */
	public static void replaceElement(int [] array, int value, int position) {

		//set array at position to value
		array [position] = value;

	}//end replaceElement

	/**
	 * replaces an element of a string array at a given index
	 * @param String [] array - the array to be altered
	 * @param String value - the element to add 
	 * @param int position - the index to replace
	 * @return void
	 */
	public static void replaceElement(String [] array, String element, int position) {

		//set array at position to value
		array [position] = element;

	}//end replaceElement

	/**
	 * replaces an element of an array at a given index
	 * @param array - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to replace
	 * @return void
	 */
	public static void replaceElement(double [] array, double element, int position) {

		//set array at position to value
		array [position] = element;

	}//end replaceElement

	/**
	 * replaces all of a specified element in an array with a new element
	 * @param array - the array to be altered
	 * @param newValue - the element to add 
	 * @param originalValue - the element to replace
	 * @return void
	 */
	public static void replaceElements(int [] array, int originalValue, int newValue) {

		//loop to replace all desired elements
		for (int j=0;j<array.length;j++) {

			//if element at index j is replaced value, set index j to new value, otherwise continue
			if(array[j] == originalValue) {

				//set array at index j to new value
				array[j] = newValue;

			}

		}

	}//end replaceElements

	/**
	 * replaces all of a specified element in an array with a new element
	 * @param array - the array to be altered
	 * @param newValue - the element to add 
	 * @param originalValue - the element to replace
	 * @return void
	 */
	public static void replaceElements(String [] array, String originalValue, String newValue) {

		//loop to replace all desired elements
		for (int j=0;j<array.length;j++) {

			//if element at index j is replaced value, set index j to new value, otherwise continue
			if(array[j] == originalValue) {

				//set array at index j to new value
				array[j] = newValue;

			}

		}

	}//end replaceElements

	/** 
	 * replaces all of a specified element in an array with a new element
	 * @param array - the array to be altered
	 * @param newValue - the element to add 
	 * @param originalValue - the element to replace
	 * @return void
	 */
	public static void replaceElements(double [] array, double originalValue, double newValue) {

		//loop to replace all desired elements
		for (int j=0;j<array.length;j++) {

			//if element at index j is replaced value, set index j to new value, otherwise continue
			if(array[j] == originalValue) {

				//set array at index j to new value
				array[j] = newValue;

			}

		}

	}//end replaceElements

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static int [] insertElement(int [] originalArray, int value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		int [] newArray = new int [originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static Rectangle [] insertElement(Rectangle [] originalArray, Rectangle value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		Rectangle [] newArray = new Rectangle [originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static Circle [] insertElement(Circle [] originalArray, Circle value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		Circle [] newArray = new Circle [originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static ImageView [] insertElement(ImageView [] originalArray, ImageView value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		ImageView [] newArray = new ImageView [originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static Text[] insertElement(Text[] originalArray, Text value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		Text[] newArray = new Text[originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement
	
	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static ToggleButton [] insertElement(ToggleButton [] originalArray, ToggleButton value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		ToggleButton [] newArray = new ToggleButton [originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement
	
	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param value - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static chess.WorldState[] insertElement(chess.WorldState[] originalArray, chess.WorldState value, int position) {

		//create new array 1 index larger than original array, set newArray at desired position to inserted value
		chess.WorldState[] newArray = new chess.WorldState[originalArray.length + 1];	
		newArray [position] = value;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param element - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static String [] insertElement(String [] originalArray, String element, int position) {

		//create new array 1 index larger than original array, set newArray at desired index to inserted value
		String [] newArray = new String [originalArray.length + 1];	
		newArray [position] = element;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param element - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static char [] insertElement(char [] originalArray, char element, int position) {

		//create new array 1 index larger than original array, set newArray at desired index to inserted value
		char [] newArray = new char [originalArray.length + 1];	
		newArray [position] = element;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * inserts an element into an array at a given index, shifting all other elements one index higher
	 * @param originalArray - the array to be altered
	 * @param element - the element to add 
	 * @param position - the index to insert at
	 * @return the array with element inserted
	 */
	public static double [] insertElement(double [] originalArray, double element, int position) {

		//create new array 1 index larger than original array, set newArray at desired index to inserted value
		double [] newArray = new double [originalArray.length + 1];	
		newArray [position] = element;

		//for all indices smaller than insert point, set equal to element at index of original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices past the insert point, replace them with the value at the original index one smaller
		for (int j=position;j<originalArray.length;j++) {

			//set new array at index 1 above j to original array at index j
			newArray[j + 1] = originalArray[j];	

		}

		//return the new array
		return newArray;

	}//end insertElement

	/**
	 * deletes an element of an array at a given index, shifting all other elements one index lower
	 * @param originalArray - the array to be altered 
	 * @param position - the index to delete at
	 * @return the array with element deleted
	 */
	public static Text[] deleteElement(Text[] originalArray, int position) {

		//creates new array one index smaller than original array
		Text[] newArray = new Text[originalArray.length - 1];	

		//for all indices before deletion point, set equal to same index in original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices after deletion point, set equal to 1 larger index in original array
		for (int j=position;j<newArray.length;j++) {

			//set new array at index j to original array at index 1 above j
			newArray[j] = originalArray[j + 1];	

		}

		//return the new array
		return newArray;	

	}//end deleteElement
	
	/**
	 * deletes an element of an array at a given index, shifting all other elements one index lower
	 * @param originalArray - the array to be altered 
	 * @param position - the index to delete at
	 * @return the array with element deleted
	 */
	public static int [] deleteElement(int [] originalArray, int position) {

		//creates new array one index smaller than original array
		int [] newArray = new int [originalArray.length - 1];	

		//for all indices before deletion point, set equal to same index in original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices after deletion point, set equal to 1 larger index in original array
		for (int j=position;j<newArray.length;j++) {

			//set new array at index j to original array at index 1 above j
			newArray[j] = originalArray[j + 1];	

		}

		//return the new array
		return newArray;	

	}//end deleteElement

	/**
	 * deletes an element of an array at a given index, shifting all other elements one index lower
	 * @param originalArray - the array to be altered 
	 * @param position - the index to delete at
	 * @return the array with element deleted
	 */
	public static char [] deleteElement(char [] originalArray, int position) {

		//creates new array one index smaller than original array
		char [] newArray = new char [originalArray.length - 1];	

		//for all indices before deletion point, set equal to same index in original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices after deletion point, set equal to 1 larger index in original array
		for (int j=position;j<newArray.length;j++) {

			//set new array at index j to original array at index 1 above j
			newArray[j] = originalArray[j + 1];	

		}

		//return the new array
		return newArray;	

	}//end deleteElement

	/**
	 * deletes an element of an array at a given index, shifting all other elements one index lower
	 * @param originalArray - the array to be altered 
	 * @param position - the index to delete at
	 * @return the array with element deleted
	 */
	public static String [] deleteElement(String [] originalArray, int position) {

		//creates new array one index smaller than original array
		String [] newArray = new String [originalArray.length - 1];	

		//for all indices before deletion point, set equal to same index in original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}
		if (position != originalArray.length - 1) {
			//for all indices after deletion point, set equal to 1 larger index in original array
			for (int j=position;j<newArray.length;j++) {

				//set new array at index j to original array at index 1 above j
				newArray[j] = originalArray[j + 1];	

			}
		}

		//return the new array
		return newArray;	

	}//end deleteElement

	/**
	 * deletes an element of an array at a given index, shifting all other elements one index lower
	 * @param originalArray - the array to be altered 
	 * @param position - the index to delete at
	 * @return the array with element deleted
	 */
	public static double [] deleteElement(double [] originalArray, int position) {

		//creates new array one index smaller than original array
		double [] newArray = new double [originalArray.length - 1];	

		//for all indices before deletion point, set equal to same index in original array
		for (int j = 0;j<position;j++) {

			//set new array at index j to original array at index j
			newArray[j] = originalArray[j];

		}

		//for all indices after deletion point, set equal to 1 larger index in original array
		for (int j=position;j<newArray.length;j++) {

			//set new array at index j to original array at index 1 above j
			newArray[j] = originalArray[j + 1];	

		}

		//return the new array
		return newArray;	

	}//end deleteElement

	/**
	 * randomizes the elements of an array, shifting them to new indices
	 * @param originalArray - the array to be randomized
	 * @return the randomized array
	 */
	public static String [] randomizeElements (String [] originalArray) {

		String [] newArray = new String [originalArray.length];
		Random rand = new Random();
		int r;

		for (int j = 0;j<newArray.length;j++) {

			r = rand.nextInt(originalArray.length);

			newArray [j] = originalArray [r];

			originalArray = deleteElement(originalArray, r);

		}

		return newArray;

	}

	/**
	 * reverses the elements in a string array
	 * @param originalArray - the array to be reversed
	 * @return the reversed array
	 */
	public static String [] reverse(String [] originalArray) {

		//creates new string array of identical length to originalArray
		String [] newArray = new String [originalArray.length];

		//for all elements of the original array, last to first, copy them into the newArray first to last
		for (int j=0;j<originalArray.length;j++) {

			newArray[j] = originalArray[(originalArray.length-1)-j];

		}

		//return the new array
		return newArray;

	}//end reverse()

	/**
	 * reverses the elements in an int array
	 * @param originalArray - the array to be reversed
	 * @return the reversed array
	 */
	public static int [] reverse(int [] originalArray) {

		//creates new string array of identical length to originalArray
		int [] newArray = new int [originalArray.length];

		//for all elements of the original array, last to first, copy them into the newArray first to last
		for (int j=0;j<originalArray.length;j++) {

			newArray[j] = originalArray[(originalArray.length-1)-j];

		}

		//return the new array
		return newArray;

	}//end reverse()

	/**
	 * sorts elements of an index in order of size, high to low
	 * @param originalArray - the array to be sorted
	 * @return the sorted array
	 */
	public static int [] sortHighToLow(int [] originalArray) {

		//create 2 copies of original array
		int [] newArray = Array.copyArray(originalArray);
		int [] sortArray = Array.copyArray(originalArray);

		//for all indices in the new array, replace them with the largest element currently in the sort array, then remove that value from the sort array
		for (int j = 0;j<originalArray.length;j++) {

			//replace the element at index j in the new array with the max value in the sort array
			Array.replaceElement(newArray, sortArray[Array.findMax(sortArray)], j);	

			//delete the max value in the sort array
			sortArray = Array.deleteElement(sortArray, Array.findMax(sortArray));

		}	

		//return the new array
		return newArray;

	}//end sortHighToLow

	/**
	 * sorts elements of an index in order of size, high to low
	 * @param originalArray - the array to be sorted
	 * @return the sorted array
	 */
	public static String [] sortHighToLow(String [] originalArray) {

		//create 2 copies of original array
		String [] newArray = new String[0];
		String [] sortArray = Array.copyArray(originalArray);

		//for all indices in the new array, replace them with the largest element currently in the sort array, then remove that value from the sort array
		for (int j = 0;j<originalArray.length;j++) {

			//replace the element at index j in the new array with the max value in the sort array
			newArray = Array.insertElement(newArray, sortArray[Array.findMax(sortArray)], j);	

			//delete the max value in the sort array
			sortArray = Array.deleteElement(sortArray, Array.findMax(sortArray));

		}	

		//return the new array
		return newArray;

	}//end sortHighToLow

	/** 
	 * sorts elements of an int array in order of size, low to high
	 * @param originalArray - the array to be sorted
	 * @return the sorted array
	 */
	public static int [] sortLowToHigh(int [] originalArray) {

		//create 2 copies of the original array
		int [] newArray = Array.copyArray(originalArray);
		int [] sortArray = Array.copyArray(originalArray);

		//for all indices in the new array, replace them with the smallest element currently in the sort array, then remove that value from the sort array
		for (int j = 0;j<originalArray.length;j++) {

			//replace index j of new array with current min from sort array
			Array.replaceElement(newArray, sortArray[Array.findMin(sortArray)], j);	

			//find and delete min from sort array
			sortArray = Array.deleteElement(sortArray, Array.findMin(sortArray));

		}	

		//return the new array
		return newArray;

	}//end sortLowToHigh

	/** 
	 * sorts elements of String array in order of size, low to high
	 * @param originalArray - the array to be sorted
	 * @return the sorted array
	 */
	public static String [] sortLowToHigh(String [] originalArray) {

		//create 2 copies of the original array
		String [] newArray = new String[originalArray.length];
		String [] sortArray = Array.copyArray(originalArray);

		//for all indices in the new array, replace them with the smallest element currently in the sort array, then remove that value from the sort array
		for (int j = 0;j<originalArray.length;j++) {

			//replace index j of new array with current min from sort array
			Array.replaceElement(newArray, sortArray[Array.findMin(sortArray)], j);	

			//find and delete min from sort array
			sortArray = Array.deleteElement(sortArray, Array.findMin(sortArray));

		}	

		//return the new array
		return newArray;

	}//end sortLowToHigh

} // end class Array
