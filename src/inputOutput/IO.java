/*Name: Luke Headington
 *Course: ICS 4U
 *Teacher: Mrs. McCaffery
 *Date: Nov. 18, 2021
 *Description: contains methods for user input and system outputs
 */
package inputOutput;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IO {

	public static int txtSpeed = 25;
	public static Scanner myInput = new Scanner(System.in);

	public static int readString (String menu, String [] menuOptions)
	{

		//initializes a string for user input and an int for output
		String input;
		int output = 0;

		//creates an infinite while loop to run until it's broken
		while (true)
		{

			//prints inputed string
			IO.writeOnly(menu);

			//try catch for user input, expects an integer input, catches for errors, i.e non integer input
			try 
			{

				//sets input equal to user inputed integer
				input = myInput.nextLine();

				for (int i = 0; i < menuOptions.length; i++)
				{

					if (input.toUpperCase().contains(menuOptions[i]))
					{

						if (output > 0)
						{

							//if user input causes error, prints error message
							IO.writeOnly("Invalid Input");

							//runs read method again with same parameters
							output = IO.readString(menu, menuOptions);

						}else
						{

							output = i + 1;

						}

					}	

				}

				if (output == 0)
				{

					//if user input causes error, prints error message
					IO.writeOnly("Invalid Input");

					//runs read method again with same parameters
					output = IO.readString(menu, menuOptions);

				}

				break;

			} catch (Exception e)
			{



				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				//runs read method again with same parameters
				output = IO.readString(menu, menuOptions);

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return output;

	}//end read

	/* Method Name: readInt
	 * Description: takes integer user inputs and runs error checks
	 * Parameters: String menu (for output) and int menucount (the number of options for that input)
	 * Returns: int input
	 */
	public static int read (String menu, int menuCount)
	{

		//initializes an int for user input
		int input = 0;

		//creates an infinite while loop to run until it's broken
		while (true)
		{

			//prints inputed string
			IO.writeOnly(menu);

			//try catch for user input, expects an integer input, catches for errors, i.e non integer input
			try 
			{

				//sets input equal to user inputed integer
				input = myInput.nextInt();

				//if input is less than 1 or greater than the defined maximum input value, prints error message, else breaks infinite loop
				if (input < 1 || input > menuCount)
				{

					//prints error message and reprints menu string
					IO.writeOnly("Invalid Input");

				}else 
				{

					//breaks infinite loop
					break;

				}

			} catch (Exception e)
			{

				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				myInput.nextLine();				

				//runs read method again with same parameters
				input = IO.read(menu, menuCount);

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return input;

	}//end read


	/* Method Name: writeOnly
	 * Description: prints inputed string character by character with delays between character
	 * Parameters: String write (the string to print)
	 * Returns: void
	 */
	public static void writeOnly (String write)
	{

		//convert inputed string to char array
		char [] print = write.toCharArray();

		//for each element of the array, run code
		for (int i = 0; i < print.length; i++)
		{

			//print character at index i
			System.out.print(print[i]);

			//delay for 0.0txtSpeed seconds before printing next character
			try {

				TimeUnit.MILLISECONDS.sleep(txtSpeed);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}//end print for loop

		//when all characters have been printed, go to next line
		System.out.print("\n");

	}//end writeOnly

	/* Method Name: writeOnlyAlter
	 * Description: prints inputed string character by character with delays between character
	 * Parameters: String write (the string to print) and int speed, the text speed
	 * Returns: void
	 */
	public static void writeOnlyAlter (String write, int speed)
	{

		//convert inputed string to char array
		char [] print = write.toCharArray();

		//for each element of the array, run code
		for (int i = 0; i <= print.length - 1; i++)
		{

			//print character at index i
			System.out.print(print[i]);

			//delay for alterable seconds before printing next character
			try {

				TimeUnit.MILLISECONDS.sleep(speed);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}//end print for loop

		//when all characters have been printed, go to next line
		System.out.print("\n");
	}//end writeOnly

	/* Method Name: writeOnlyNL
	 * Description: prints inputed string character by character with delays between character without creating a new line
	 * Parameters: String write (the string to print)
	 * Returns: void
	 */
	public static void writeOnlyNL (String write)
	{

		//convert inputed string to char array
		char [] print = write.toCharArray();

		//for each element of the array, run code
		for (int i = 0; i <= print.length - 1; i++)
		{

			//print character at index i
			System.out.print(print[i]);

			//delay for txtSpeed seconds before printing next character
			try {

				TimeUnit.MILLISECONDS.sleep(txtSpeed);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}//end print for loop

	}//end writeOnly

	public static double pureReadDouble() {

		//initializes a int for user input
		double input;

		//creates an infinite while loop to run until a valid input
		while (true)
		{

			//try catch for user input, expects an integer input, catches for errors, i.e non integer input
			try 
			{

				//sets input equal to user inputed integer
				input = myInput.nextDouble();

				break;

			} catch (Exception e)
			{

				myInput.nextLine();

				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				//runs read method again with same parameters
				input = IO.pureReadDouble();

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return input;

	}

	public static String pureReadString() {

		//initializes a int for user input
		String input;

		//creates an infinite while loop to run until a valid input
		while (true)
		{

			//try catch for user input, expects a string input, catches for errors, i.e non string input
			try 
			{

				myInput = new Scanner(System.in).useDelimiter("\n");
				
				//sets input equal to user inputed integer
				input = myInput.next();

				break;

			} catch (Exception e)
			{

				myInput.nextLine();	

				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				//runs read method again with same parameters
				input = IO.pureReadString();

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return input;

	}

	public static int pureReadInt() {

		//initializes a int for user input
		int input;

		//creates an infinite while loop to run until a valid input
		while (true)
		{

			//try catch for user input, expects an integer input, catches for errors, i.e non integer input
			try 
			{
				
				//sets input equal to user inputed integer
				input = myInput.nextInt();

				break;

			} catch (Exception e)
			{

				myInput.nextLine();

				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				//runs read method again with same parameters
				input = IO.pureReadInt();

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return input;

	}

	public static char pureReadChar() {

		//initializes a int for user input
		char input;

		//creates an infinite while loop to run until a valid input
		while (true)
		{

			//try catch for user input, expects an integer input, catches for errors, i.e non integer input
			try 
			{

				//sets input equal to user inputed integer
				input = myInput.next().charAt(0);

				break;

			} catch (Exception e)
			{

				myInput.nextLine();

				//if user input causes error, prints error message
				IO.writeOnly("Invalid Input");

				//runs read method again with same parameters
				input = IO.pureReadChar();

				//break loop
				break;

			}//end try catch

		}//end infinite while loop

		//when user input is within parameters, return user input
		return input;

	}

}//end class
