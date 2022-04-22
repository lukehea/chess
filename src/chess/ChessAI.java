package chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.*;
import array.Array;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessAI {

	static WorldState[] states;

	public static void move(String[][] board, Pane background, Rectangle prePosition, Rectangle lastPrePosition, Stage arg0, ChessBoard boardObject) {

		//sets the board before the next turn
		Chess.cleanBoard(boardObject);

		//find all available moves, initialize x/y for start and end of move and find optimal move
		String[] moves = findMoves(background);
		int sX = 0;
		int sY = 0;
		int x = 0;
		int y = 0;
		char[] move = chooseMove(moves).toCharArray();

		//sets x/y for start and end depending on whether or not the move char array contains an x
		if (move[3]!='x') {

			sX = move[1] - '0';
			sY = move[2] - '0';
			y = move[3] - '0';
			x = move[4] - '0';

		}else  {

			sX = move[1] - '0';
			sY = move[2] - '0';
			y = move[5] - '0';
			x = move[6] - '0';

		}

		//moves selected to move start location and run end turn code
		Chess.selected.relocate(sX*100, sY*100);
		Chess.endTurn(background, arg0, x, y, prePosition, lastPrePosition, boardObject);

	}

	public static String[] findMoves(Pane background) {

		//all moves contains every move available to any piece owned by the player
		String[] allMoves = new String[0];

		//for all tiles on the board
		for (int i = 0;i<Chess.board.length;i++) {
			for (int j = 0;j<Chess.board[i].length;j++) {

				//if the piece belongs to a player
				if (Chess.board[i][j].toCharArray()[1]==Chess.player) {

					//moves selected to the piece location and gets a list of moves available to that piece
					Chess.selected.relocate(i*100,j*100);
					String[] moves = Chess.placeIndicators(Chess.selected, background);

					//adds all moves available to that piece to the list of moves available to the player
					for (int k = 0;k<moves.length;k++)
						allMoves = Array.insertElement(allMoves, moves[k], allMoves.length);

				}

			}
		}

		//return all available moves
		return allMoves;

	}

	public static String chooseMove(String[] moves) {

		//creates an array for the best known move, [0] is the move value, [1] is the move position in the moves array
		double[] bestMove = new double[2];

		//for all known moves
		for (int i = 0;i<moves.length;i++) {

			//creates a new WorldState using the current action and if the current action returns a higher score than the current best move, change the best move
			WorldState moveTest = new WorldState(Chess.board, Chess.player, moves[i], 0);
			if (moveTest.compareAllStates(states)>bestMove[0]) {
				bestMove[0] = moveTest.compareAllStates(states);
				bestMove[1] = i;
			}	

		}

		//return the best move found from the moves array
		return moves[(int) bestMove[1]];

	} 

	public static void saveStates() throws IOException {

		Gson gson = new Gson();
		PrintWriter print = new PrintWriter(new FileWriter("chessStates.json"));

		for (int i = 0;i<states.length;i++)
			print.println(gson.toJson(states[i]));

		print.close();

	}

	public static void readStates() throws IOException {

		BufferedReader read = new BufferedReader(new FileReader("chessStates.json"));
		Gson gsonParser = new Gson();
		
		String line = "";

		String gsonData = read.readLine();
		
		while(line!=null) {

			states = Array.insertElement(states, gsonParser.fromJson(gsonData, WorldState.class), states.length);
			
			gsonData = read.readLine();

		}
		
		read.close();

	}

	public static String generateNotations(int x, int y) {

		//creates a string for the action notation, determine the char array of the selected space and starts the notation with the name of the players piece, and its position
		String notation = "";
		char[] selectedSpace = Chess.board[(int)Chess.selected.getLayoutX()/100][(int)Chess.selected.getLayoutY()/100].toCharArray();
		notation+=String.valueOf(selectedSpace[0])+String.valueOf((int)Chess.selected.getLayoutX()/100)+String.valueOf((int)Chess.selected.getLayoutY()/100);

		//if the move ends on an opponent piece, add the name of the opponents piece
		if (Chess.board[x][y].toCharArray()[1]==Chess.opponent) 
			notation+="x" + Chess.board[x][y].toCharArray()[0];

		//add the location of the move endpoint
		notation+=String.valueOf(x)+String.valueOf(y);

		//if the move ends with check, add a '+'
		if (Chess.findKing(Chess.board, Chess.selected)) 
			notation+="+";

		//return the complete notation string
		return notation;

	}

}
