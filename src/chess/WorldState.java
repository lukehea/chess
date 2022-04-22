package chess; 

public class WorldState {
	
	private String[][] boardState;
	private char player;
	private String action;
	private double netScore;
	private double originalScore;

	/**
	 * constructor for world states
	 * @param board - the board for the state
	 * @param player - the player when the state occurred
	 * @param action - the action that lead to the state
	 * @param score - the positive/negative score that the action created
	 */
	public WorldState(String[][] board, char player, String action, double score) {
				
		//constructs all values for a new world state
		this.boardState = board;
		this.player = player;
		this.action = action;
		this.netScore = score;
		this.originalScore = score;

	}

	/**
	 * sets the board of a world state
	 * @param board - the new board for the state
	 */
	public void setBoard(String[][] board) {

		this.boardState = board;

	}

	/**
	 * @return the board for a world state
	 */
	public String[][] getBoard() {

		return this.boardState;

	}

	/**
	 * sets a new player value for a world state
	 * @param player - the new player ID
	 */
	public void setPlayer(char player) {

		this.player = player;

	}

	/**
	 * @return the player char ID for a world state
	 */
	public char getPlayer() {

		return this.player;

	}

	/**
	 * sets the action string for a world state
	 * @param action - the string representing the new action
	 */
	public void setAction(String action) {

		this.action = action;

	}

	/**
	 * @return the action string for the world state
	 */
	public String getAction() {

		return this.action;

	}

	/**
	 * sets a new net score for a world state (a combination score from the original score of a state and all states after)
	 * @param score - the new net score
	 */
	public void setNetScore(double score) {

		this.netScore = score;

	}

	/**
	 * @return the current net score of a world state
	 */
	public double getNetScore() {

		return this.netScore;

	}

	/**
	 * sets a new original score for a world state (the score of a state without the effect of later states)
	 * @param score - the new original score
	 */
	public void setOriginalScore(double score) {

		this.originalScore = score;

	}

	/**
	 * @return the current original score of a world state
	 */
	public double getOriginalScore() {

		return this.originalScore;

	}

	/**
	 * compares a world state to an array of prior world states
	 * @param current - the active world state to compare
	 * @param allStates - an array of all prior world states
	 * @return the average expected value of the world state
	 */
	public double compareAllStates(WorldState[] allStates) {

		//initializes doubles for the sum of all compared values and the total number of compared values
		double netValue = 0;
		double totalStates = 0;

		//for all states in the array, runs them through an individual state comparison with the current state
		for (int i = 0;i<allStates.length;i++) {

			//if the comparison of the two states returns anything but 0, update netValue and totalStates
			if (helper_compareStates(allStates[i])!=0) {

				netValue+=helper_compareStates(allStates[i]);
				totalStates++;

			}

		}

		//returns the netValue divided by the totalStates
		return (netValue/totalStates);

	}

	/**
	 * compares two world states and returns an expected value for the first world state based off the second world state
	 * @param A - the current world state being compared
	 * @param B - the old world state being compared against
	 * @return the expected value of state A
	 */
	private double helper_compareStates(WorldState B) {

		//sets the commonality factor, a value used to determine how higher commonality prioritized
		double commonalityFactor = 20;

		//if the player for the two states doesn't match, return 0
		if (this.getPlayer()!=B.getPlayer()) 
			return 0;

		//if the commonality of the boards is less than 10, return 0
		if (helper_boardCommonality(this.getBoard(), B.getBoard())<10)
			return 0;

		//if the commonality of the two actions is less than 2, return 0
		if (helper_actionCommonality(this.getAction().toCharArray(), B.getAction().toCharArray())<2) 
			return 0;

		//returns the expected value using a function on the net score of the b state and the board/action commonality
		return B.getNetScore()*((Math.pow(commonalityFactor, helper_boardCommonality(this.getBoard(), B.getBoard())/64)*(Math.pow(commonalityFactor, helper_actionCommonality(this.getAction().toCharArray(), B.getAction().toCharArray())/9)))/(Math.pow(commonalityFactor, 2)));

	}

	/**
	 * determines the commonality of two game boards, represented by 2d string arrays
	 * @param A - the first board to compare
	 * @param B - the second board to compare
	 * @return the number of spaces where the two boards are the same
	 */
	private double helper_boardCommonality(String[][] A, String[][] B) {

		//initializes the commonality of the two boards as 0
		double commonality = 0;

		//for all rows in the boards, checks all spaces
		for (int i = 0;i<A.length;i++) {

			//for each space of each row, check if the two values are equal
			for (int j = 0;j<A[i].length;i++) {

				//if the two values are equal, increment the commonality
				if (A[i][j].equals(B[i][j]))
					commonality++;

			}

		}

		//returns the final sum of commonality
		return commonality;

	}

	/**
	 * determines the commonality of two actions, represented by char arrays
	 * @param A - the first action to compare
	 * @param B - the second action to compare
	 * @return the number of ways in which the two actions are the same
	 */
	private double helper_actionCommonality(char[] A, char[] B) {

		//initializes the commonality of the two actions as 0
		double commonality = 0;

		//compares the first three indices of the two actions, which are always in the same format
		for (int i = 0;i<3;i++) {

			//if the two actions are the same at i, increment commonality
			if (A[i]==B[i])
				commonality++;

		}

		//determines which of 3 states the two actions are in, either: A involved taking piece, B involved taking piece or neither involved taking piece
		if (A[3]=='x') {

			//if A contains x, start from i = 5, and compare A at i to B at two before i
			for (int i = 5;i<A.length;i++) {

				//if the two actions at i and i - 2 are equal, increment commonality
				if (A[i]==B[i-2])
					commonality++;	

			}

		}else if (B[3]=='x') {

			//if A contains x, start from i = 5, and compare A at two before i to B at i
			for (int i = 5;i<B.length;i++) {

				//if the two actions at i and i - 2 are equal, increment commonality
				if (A[i-2]==B[i])
					commonality++;	

			}

		}else {
			
			//if neither contains x, start from i = 3 and compare A at i to B at i
			for (int i = 3;i<A.length;i++) {

				//if A at i and B at i are equal, increment commonality
				if (A[i]==B[i])
					commonality++;	

			}
			
		}

		//return the sum of all the commonality
		return commonality;

	}

}