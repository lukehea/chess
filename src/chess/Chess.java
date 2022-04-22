package chess;

import java.io.FileInputStream;
import java.io.IOException;
import array.Array;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import array.MDArray;

public class Chess extends Application{

	static String[][] board = {

			{"RBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "RWEE"},
			{"NBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "NWEE"},
			{"BBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "BWEE"},
			{"QBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "QWEE"},
			{"KBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "KWEE"},
			{"BBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "BWEE"},
			{"NBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "NWEE"},
			{"RBEE", "PBEE", "EEEE", "EEEE", "EEEE", "EEEE", "PWEE", "RWEE"}

	};

	static ImageView[] images = new ImageView[0];
	static char player = 'W';
	static char opponent = 'B';
	static Rectangle selected;
	static TextBox textSpace;
	static Group markers;

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {

		//on startup, gets all old states from text files
		ChessAI.readStates();

		//creates an 8 x 8 black/white gameboard and generate pane from board, creates a scene using the pane
		ChessBoard boardObject = new ChessBoard(9, 9, 900.0, 900.0, -100.0, -100.0, Color.WHITE, Color.BLACK);
		Pane background = boardObject.getBoardToDisplay();
		Scene scene = new Scene(background, 900, 900);

		//set stage height, width and scene. set stage to nonresizable and show
		arg0.setHeight(835);
		arg0.setWidth(1060);
		arg0.setScene(scene);
		arg0.setResizable(false);
		arg0.show();

		textSpace = new TextBox(Color.WHITE, 750, 200, 825, 25, Color.BLACK, background, 3.0);
		textSpace.showTBox();
		
		//creates three new yellow squares. they mark the tile with the currently selected piece, the tile where the last move started and the tile where the last move ended. they are placed in a group for moving to the back or front
		selected = new Rectangle (100, 100, Color.YELLOW);
		selected.setOpacity(.6);
		selected.relocate(-100, -100);
		Rectangle lastPreposition = new Rectangle (100, 100, Color.YELLOW);
		Rectangle preposition = new Rectangle (100, 100, Color.YELLOW);
		lastPreposition.setOpacity(.3);
		lastPreposition.relocate(-100, -100);
		preposition.setOpacity(.4);
		preposition.relocate(-100, -100);
		markers = new Group(selected, lastPreposition, preposition);

		//makes all markers visible
		background.getChildren().add(markers);

		for (int i = 0;i<8;i++) {

			for (int j = 0;j<8;j++) {

				//if the board position contains a piece, generate an image
				if (board[j][i].toCharArray()[1]!='E') {

					//outer switch to determine which players piece, followed by inner switch to determine the piece type. then draws imageView from file
					switch (board[j][i].toCharArray()[1]) {
					case 'B': 
						switch (board[j][i].toCharArray()[0]) {
						case 'P': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\PawnB.png"))), images.length); break;
						case 'R': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\RookB.png"))), images.length); break;
						case 'N': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\KnightB.png"))), images.length); break;
						case 'B': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\BishopB.png"))), images.length); break;
						case 'Q': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\QueenB.png"))), images.length); break;
						case 'K': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\KingB.png"))), images.length); break;
						} break;
					case 'W':
						switch (board[j][i].toCharArray()[0]) {
						case 'P': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\PawnW.png"))), images.length); break;
						case 'R': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\RookW.png"))), images.length); break;
						case 'N': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\KnightW.png"))), images.length); break;
						case 'B': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\BishopW.png"))), images.length); break;
						case 'Q': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\QueenW.png"))), images.length); break;
						case 'K': images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\KingW.png"))), images.length); break;
						} break;
					}//end switches

					//sets image height/width and moves image to relevant location
					images[images.length-1].setFitHeight(100); 
					images[images.length-1].setFitWidth(100); 
					images[images.length-1].relocate(j*100, i*100);

					//adds image to background, makes visible
					background.getChildren().add(images[images.length-1]);

				}//end if

			}//end inner for

		}//end outer for

		System.out.println(images.length);
		
		//adds 8 extra black queen images to the end of the array, which are used for queened white pawns
		for (int i = 0;i<8;i++) {

			images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\QueenB.png"))), images.length);
			images[images.length-1].setFitHeight(100); 
			images[images.length-1].setFitWidth(100); 
			images[images.length-1].relocate(-100, -100);
			background.getChildren().add(images[images.length-1]);

		}

		//adds 8 extra white queen images to the end of the array, which are used for queened black pawns
		for (int i = 0;i<8;i++) {

			images = Array.insertElement(images, new ImageView(new Image(new FileInputStream("C:\\Images\\chess\\QueenW.png"))), images.length);
			images[images.length-1].setFitHeight(100); 
			images[images.length-1].setFitWidth(100); 
			images[images.length-1].relocate(-100, -100);
			background.getChildren().add(images[images.length-1]);
			
			
		}
		
		//code runs when user clicks on the screen
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {

				//translates x/y coords of mouseclick into x/y coords for board array by dividing by tile side length
				int x = (int) Math.floor(e.getSceneX()/100);
				int y = (int) Math.floor(e.getSceneY()/100);

				//if the value of the click position places x/y outside the array indices, set to array maximum
				if (x>7) 
					x = 7;
				if (y>7)
					y = 7;

				if (selected.getLayoutX()==x*100&&selected.getLayoutY()==y*100){
					//if the location that was clicked is the currently selected piece, deselects piece

					//relocates selected offscreen
					selected.relocate(-100, -100);

					//try running cleanBoard to remove indicators
					//try {
					cleanBoard(boardObject);
					/*} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}*/

				}else if (board[x][y].toCharArray()[1]==player) {
					//if the clicked location contains an unselected player piece, select that piece

					//relocate selected onto piece
					selected.relocate(x*100, y*100);

					//try running setBoard to update piece locations
					//try {
					cleanBoard(boardObject);
					/*} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}*/

					//find location of available moves for selected piece, places indicators
					placeIndicators(selected, background);

				}else if (board[x][y].toCharArray()[2]=='I') {
					//if the clicked location is a space the selected piece can move to/an indicated space, run end of turn code

					//runs end of turn with relevant info
					endTurn(background, arg0, x, y, preposition, lastPreposition, boardObject);

				}//ends click type if/else

			}//ends handle method

		});//ends onMouseClicked()

		//runs when window is closed
		arg0.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {

				//before window is closed, stores all states into text file
				try {
					ChessAI.saveStates();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}//ends handle method

		});//ends on close request

	}//end start()


	public static void cleanBoard(ChessBoard gameBoard) {

		gameBoard.toFront();
		markers.toFront();
		
		//for all tiles on the board, checks if they are currently indicated. if they are indicated, removes indicators
		for (int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {

				//if tile is indicated, changes indicating char to empty char
				if (board[i][j].toCharArray()[2]=='I') 
					board[i][j] = board[i][j].toCharArray()[0] + String.valueOf(board[i][j].toCharArray()[1]) + "E" + board[i][j].toCharArray()[3];

			}//ends inner for
		}//ends outer for

		MDArray.print(board);
		System.out.println();
		
		//runs sub method to place pieces into position
		helper_setBoard();

	}//end cleanBoard()

	private static void helper_setBoard() {
		
		int[] pieceCounts = new int[12];

		//for all tiles on the board, checks if it contains a piece, then moves image to position and front
		for (int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				
				//if the position contains a piece
				if (board[i][j].toCharArray()[0]!='E') {
					
					//outer switch to find piece owner, inner switch to find piece type. then brings relevant image to new position and brings to front
					switch (board[i][j].toCharArray()[1]) {
					case 'B': 
						switch (board[i][j].toCharArray()[0]) {
						case 'P': images[8+pieceCounts[5]].relocate(i*100, j*100); images[8+pieceCounts[5]].toFront(); pieceCounts[5]++; break;
						case 'R': if (pieceCounts[0]==0) {images[0].relocate(i*100, j*100); images[0].toFront();} else {images[7].relocate(i*100, j*100); images[7].toFront();} pieceCounts[0]++; break;
						case 'N': if (pieceCounts[1]==0) {images[1].relocate(i*100, j*100); images[1].toFront();} else {images[6].relocate(i*100, j*100); images[6].toFront();} pieceCounts[1]++; break;
						case 'B': if (pieceCounts[2]==0) {images[2].relocate(i*100, j*100); images[2].toFront();} else {images[5].relocate(i*100, j*100); images[5].toFront();} pieceCounts[2]++; break;
						case 'Q': if (pieceCounts[3]==0) {images[3].relocate(i*100, j*100); images[3].toFront();} else {images[32+pieceCounts[3]].relocate(i*100, j*100); images[32+pieceCounts[3]].toFront();} pieceCounts[3]++;break;
						case 'K': images[4].relocate(i*100, j*100); images[4].toFront(); break;
						} break;
					case 'W':
						switch (board[i][j].toCharArray()[0]) {
						case 'P': images[16+pieceCounts[6]].relocate(i*100, j*100); images[16+pieceCounts[6]].toFront(); pieceCounts[6]++; break;
						case 'R': if (pieceCounts[7]==0) {images[24].relocate(i*100, j*100); images[24].toFront();} else {images[31].relocate(i*100, j*100); images[31].toFront();} pieceCounts[7]++; break;
						case 'N': if (pieceCounts[8]==0) {images[25].relocate(i*100, j*100); images[25].toFront();} else {images[30].relocate(i*100, j*100); images[30].toFront();} pieceCounts[8]++; break;
						case 'B': if (pieceCounts[9]==0) {images[26].relocate(i*100, j*100); images[26].toFront();} else {images[29].relocate(i*100, j*100); images[29].toFront();} pieceCounts[9]++; break;
						case 'Q': if (pieceCounts[10]==0) {images[27].relocate(i*100, j*100); images[27].toFront();} else {images[39+pieceCounts[10]].relocate(i*100, j*100); images[39+pieceCounts[10]].toFront();} pieceCounts[10]++;break;
						case 'K': images[28].relocate(i*100, j*100); images[28].toFront(); break;
						} break;	
					}//end switches

				}//end if

			}//ends inner for

		}//ends outer for

	}//end helper_setBoard()

	public static String[] placeIndicators(Rectangle selected, Pane background) {

		//generates an empty array for the indicator circles and move notations, gets an array of potential moves using findPositions()
		Circle[] positionCircles = new Circle[0];
		int[][] positions = findPositions((int) selected.getLayoutX()/100, (int) selected.getLayoutY()/100, board, selected);
		String[] notations = new String[0];

		//for all positions given, place either a dot indicator for an empty space or a circle indicator for a space with an opponents piece
		for (int i = 0;i<positions.length;i++) {

			if (board[positions[i][0]][positions[i][1]].toCharArray()[1]==opponent) {

				//create a new transparent circle, add it to circle array, reposition, give circle gray border and set opacity
				positionCircles = Array.insertElement(positionCircles, new Circle(40, Color.TRANSPARENT), positionCircles.length);
				positionCircles[positionCircles.length-1].relocate(positions[i][0]*100+10, positions[i][1]*100+10);
				positionCircles[positionCircles.length-1].setStroke(Color.GRAY);
				positionCircles[positionCircles.length-1].setStrokeWidth(10);
				positionCircles[positionCircles.length-1].setOpacity(.33);

				//add new circle to pane and update position in gameboard array to indicated space
				background.getChildren().add(positionCircles[positionCircles.length-1]);
				board[positions[i][0]][positions[i][1]] = String.valueOf(board[positions[i][0]][positions[i][1]].toCharArray()[0])+String.valueOf(board[positions[i][0]][positions[i][1]].toCharArray()[1])+"I"+board[positions[i][0]][positions[i][1]].toCharArray()[3];

			}else {

				//create a new smaller gray circle, add to array, reposition and set opacity
				positionCircles = Array.insertElement(positionCircles, new Circle(15, Color.GRAY), positionCircles.length);
				positionCircles[positionCircles.length-1].relocate(positions[i][0]*100+35, positions[i][1]*100+35);
				positionCircles[positionCircles.length-1].setOpacity(.33);

				//add new circle to pane and update position in gameboard array to indicated space
				background.getChildren().add(positionCircles[positionCircles.length-1]);
				board[positions[i][0]][positions[i][1]] = String.valueOf(board[positions[i][0]][positions[i][1]].toCharArray()[0])+String.valueOf(board[positions[i][0]][positions[i][1]].toCharArray()[1])+"I"+board[positions[i][0]][positions[i][1]].toCharArray()[3];

			}//end if/else

			//creates a new notation for the current move, adds to notations array
			notations = Array.insertElement(notations, ChessAI.generateNotations(positions[i][0], positions[i][1]), notations.length);
			
		}//end for

		//returns all possible move notations
		return notations;

	}//ends place indicators

	public static int[][] findPositions(int x, int y, String[][] board, Rectangle selected){

		//pieceType stores the char representing the selected piece, positions stores the end points of all viable moves for that piece, moveDistance is the max distance a piece can move, 7 for queen/rook/bishop, 1 for king
		int moveDistance = 7;
		char pieceType = board[x][y].toCharArray()[0];
		int[][] positions = new int[0][0];

		//switch to determine which move set to use depending on the piece
		switch (pieceType) {

		//case for pawns
		case 'P':

			//switch to check whether piece is a black or white pawn
			switch (board[x][y].toCharArray()[1]) {

			//case for white pawns
			case 'W': 

				System.out.println(board[x][y-1]);
				
				//if the next space is empty, and the pawn isnt trying to move off the board
				if (y>0&&board[x][y-1].toCharArray()[1]=='E') {

					//if moving the pawn forward wouldnt place the pawn in check, add a new position one space above pawn
					if (!testMove(selected, x, y-1)){
						int[] addPos = {x, y-1};
						positions = MDArray.insertRow(positions, addPos, positions.length);
					}

					//if the pawn is in its starting row, moving forward 2 wouldn't place it in check and the space two spaces ahead is empty, add moving forward 2 to positions array
					if (y+2==board.length&&!testMove(selected, x, y-2)&&board[x][y-2].toCharArray()[1]=='E') {

						int[] addPos2 = {x, y-2};
						positions = MDArray.insertRow(positions, addPos2, positions.length);

					}

				}//end if

				//if there is an opponent piece up and left, and moving up and left wouldn't cause check, add up/left to positions array
				if (x>0&&y>0&&board[x-1][y-1].toCharArray()[1]==opponent&&!testMove(selected, x-1, y-1)) {

					int[] addPos = {x-1, y-1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				}

				//if there is an opponent piece up and right, and moving up and right wouldn't cause check, add up/right to positions array
				if (x<7&&y>0&&board[x+1][y-1].toCharArray()[1]==opponent&&!testMove(selected, x+1, y-1)) {

					int[] addPos = {x+1, y-1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				} break;

				//case for black pawn
			case 'B':

				//if the piece is not at the edge of the board and the space in front of it empty
				if (y<7&&board[x][y+1].toCharArray()[1]=='E') {

					//if moving the piece 1 forward would not cause check, add move 1 forward to positions
					if (!testMove(selected, x, y+1)) {

						int[] addPos = {x, y+1};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

					//if the pawn is in its starting position and moving forward 2 would not cause check and the space 2 forward is currently empty, add move two forward to positions
					if (y-1==0&&!testMove(selected, x, y+2)&&board[x][y+2].toCharArray()[1]=='E') {

						int[] addPos2 = {x, y+2};
						positions = MDArray.insertRow(positions, addPos2, positions.length);

					}
				}

				//if moving forward and left is possible/doesnt cause check, and an opponent piece is forward and left, add forward/left to positions array
				if (x>0&&y<7&&board[x-1][y+1].toCharArray()[1]==opponent&&!testMove(selected, x-1, y+1)) {

					int[] addPos = {x-1, y+1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				}

				//if moving forward and right is possible/doesnt cause check, and an opponent piece is forward and right, add forward/right to positions array
				if (x<7&&y<7&&board[x+1][y+1].toCharArray()[1]==opponent&&!testMove(selected, x+1, y+1)) {

					int[] addPos = {x+1, y+1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				} break;

			}//end black/white switch
			break;

			//case for knights
		case 'N':

			//if moving one space up wouldn't put the knight offboard
			if (x>0) {

				//if moving two spaces right wouldn't put the knight off board
				if (y<6) {

					//if the space one up two right isnt a player piece
					if (!(board[x-1][y+2].toCharArray()[1]==player)) {

						//if moving one up two right wouldnt cause check, add to positions
						if (!testMove(selected, x-1, y+2)) {
							int[] addPos = {x-1, y+2};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving two spaces left wouldn't put the knight off board
				if (y>1) {

					//if the space one up two right isnt a player piece
					if (!(board[x-1][y-2].toCharArray()[1]==player)) {

						//if moving one up two right wouldnt cause check, add to positions
						if (!testMove(selected, x-1, y-2)) {
							int[] addPos = {x-1, y-2};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

			}

			//if moving one space down wouldnt place the knight off the board
			if (x<7) {

				//if moving two right wouldn't place the knight off the board
				if (y<6) {

					//if one down two right isnt a player piece
					if (!(board[x+1][y+2].toCharArray()[1]==player)) {

						//if moving one down two right doesnt cause check, add to positions
						if (!testMove(selected, x+1, y+2)) {
							int[] addPos = {x+1, y+2};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//moving two left wouldnt place knight off board
				if (y>1) {

					//if one down two left isnt a player piece
					if (!(board[x+1][y-2].toCharArray()[1]==player)) {

						//if moving one down two left doesnt cause check, add to positions
						if (!testMove(selected, x+1, y-2)) {
							int[] addPos = {x+1, y-2};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

			}

			//if moving down 2 is possible
			if (x<6) {

				//if moving right 1 is possible
				if (y<7) {

					//if down 2 right 1 is not a player piece
					if (!(board[x+2][y+1].toCharArray()[1]==player)) {

						//if down 2 right 1 doesnt cause check, add position
						if (!testMove(selected, x+1, y+1)) {
							int[] addPos = {x+2, y+1};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving left 1 is possible
				if (y>0) {

					//if down 2 left 1 is not a player piece
					if (!(board[x+2][y-1].toCharArray()[1]==player)) {

						//if down 2 left 1 doesnt cause check, add position
						if (!testMove(selected, x+2, y-1)) {
							int[] addPos = {x+2, y-1};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

			}

			//if moving up one is possible
			if (x>1) {

				//if moving right 2 is possible
				if (y<7) {

					//if up 1 right 2 is not a player
					if (!(board[x-2][y+1].toCharArray()[1]==player)) {

						//if up 1 right 2 doesn't cause check, add position
						if (!testMove(selected, x-2, y+1)) {
							int[] addPos = {x-2, y+1};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving left 2 is possible
				if (y>0) {

					//if up one left 2 isnt a player piece
					if (!(board[x-2][y-1].toCharArray()[1]==player)) {

						//if up one left 2 doesnt cause check, add position
						if (!testMove(selected, x-2, y-1)) {
							int[] addPos = {x-2, y-1};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

			}
			break;

			//rook case. queen case flows through both rook and bishop case to improve code readability. king case functions like queen case, but sets move distance to 1 so it only checks one space out
		case 'K': moveDistance = 1;
		case 'Q':
		case 'R':

			//stores four positions, along the up, down, left and right axis
			int[][] currentPos = {

					{x,y},
					{x,y},
					{x,y},
					{x,y}

			};

			//loops 7 times, the maximum distance a piece can move in any direction
			for (int j = 0;j<moveDistance;j++) {

				//if moving up doesn't place the piece off board
				if (!(currentPos[0][0]-1<0)) {

					//if the current position isn't an enemy piece and the next space wouldn't be a player piece
					if (!(board[currentPos[0][0]][currentPos[0][1]].toCharArray()[1]==opponent)&&!(board[currentPos[0][0]-1][currentPos[0][1]].toCharArray()[1]==player)) {

						//move the current position up one and if moving to the next position wouldn't cause check, add position
						currentPos[0][0]--;
						if (!testMove(selected, currentPos[0][0], currentPos[0][1])) {
							int[] addPos = {currentPos[0][0], currentPos[0][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving left doesnt place piece off board
				if (!(currentPos[1][1]-1<0)) {

					//if current position isnt an enemy piece and one left isnt a player piece
					if (!(board[currentPos[1][0]][currentPos[1][1]].toCharArray()[1]==opponent)&&!(board[currentPos[1][0]][currentPos[1][1]-1].toCharArray()[1]==player)) {

						//move current position one left, and if moving one left doesnt cause check, add position
						currentPos[1][1]--;
						if (!testMove(selected, currentPos[1][0], currentPos[1][1])) {
							int[] addPos = {currentPos[1][0], currentPos[1][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving down doesn't place piece off board
				if (!(currentPos[2][0]+1>7)) {

					//if current position isn't an opponent piece and moving down one isn't a player piece
					if (!(board[currentPos[2][0]][currentPos[2][1]].toCharArray()[1]==opponent)&&!(board[currentPos[2][0]+1][currentPos[2][1]].toCharArray()[1]==player)) {

						//move current position down one, and if down one doesn't cause check, add position
						currentPos[2][0]++;
						if (!testMove(selected, currentPos[2][0], currentPos[2][1])) {
							int[] addPos = {currentPos[2][0], currentPos[2][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

				//if moving one right doesn't place piece off board
				if (!(currentPos[3][1]+1>7)) {

					//if current position isn't opponent piece, and moving one right isn't player piece
					if (!(board[currentPos[3][0]][currentPos[3][1]].toCharArray()[1]==opponent)&&!(board[currentPos[3][0]][currentPos[3][1]+1].toCharArray()[1]==player)) {

						//move current piece one right, and if one right doesn't cause check, add position
						currentPos[3][1]++;
						if (!testMove(selected, currentPos[3][0], currentPos[3][1])) {
							int[] addPos = {currentPos[3][0], currentPos[3][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}

				}

			}
			if (pieceType == 'R') {

				break;

			}

			//bishop case
		case 'B':

			//creates booleans used to determine which directions can still be moved in, and sets the starting positions of the piece
			boolean[] direct = {true, true, true, true};
			int[][] currentPoints = {

					{x,y},
					{x,y},
					{x,y},
					{x,y}

			};

			//loops the max distance the piece can move
			for (int j = 0;j<moveDistance;j++) {

				//checks through all 4 directions, and if any direction is at the edge of the board, set its boolean to false
				if (currentPoints[0][0]-1<0||currentPoints[3][0]-1<0) {

					direct[0] = false;

				}
				if (currentPoints[0][1]-1<0||currentPoints[1][1]-1<0) {

					direct[2] = false;

				}
				if (currentPoints[2][0]+1>7||currentPoints[1][0]+1>7) {

					direct[1] = false;

				}
				if (currentPoints[2][1]+1>7||currentPoints[3][1]+1>7) {

					direct[3] = false;

				}

				//if the up and left booleans are true, the current position isn't an opponent and one up one left isn't a player piece
				if (direct[0]&&direct[2]) {
					if (!(board[currentPoints[0][0]][currentPoints[0][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[0][0]-1][currentPoints[0][1]-1].toCharArray()[1]==player)) {

						//move the current position up and left, and if up/left doesn't cause check add position
						currentPoints[0][0]--;
						currentPoints[0][1]--;
						if (!testMove(selected, currentPoints[0][0], currentPoints[0][1])) {
							int[] addPos = {currentPoints[0][0], currentPoints[0][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}
				}

				//if down and left is available, current position isn't opponent piece and down left isn't player piece
				if (direct[1]&&direct[2]) {
					if (!(board[currentPoints[1][0]][currentPoints[1][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[1][0]+1][currentPoints[1][1]-1].toCharArray()[1]==player)) {

						//move current position down and left, and if down/left doesn't cause check, add position
						currentPoints[1][0]++;
						currentPoints[1][1]--;
						if (!testMove(selected, currentPoints[1][0], currentPoints[1][1])) {
							int[] addPos = {currentPoints[1][0], currentPoints[1][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}
				}

				//if up/right is available, current position isn't opponent piece and up/right isn't player piece
				if (direct[0]&&direct[3]) {
					if (!(board[currentPoints[3][0]][currentPoints[3][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[3][0]-1][currentPoints[3][1]+1].toCharArray()[1]==player)) {

						//move current position down/right, and if up/right doesn't cause check, add position
						currentPoints[3][0]--;
						currentPoints[3][1]++;
						if (!testMove(selected, currentPoints[3][0], currentPoints[3][1])) {
							int[] addPos = {currentPoints[3][0], currentPoints[3][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}
				}

				//if down/right is available, current position isn't opponent piece and down/right isn't player piece
				if (direct[1]&&direct[3]) {
					if (!(board[currentPoints[2][0]][currentPoints[2][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[2][0]+1][currentPoints[2][1]+1].toCharArray()[1]==player)) {

						//move current position down/right, and if down/right doesn't cause check, add position
						currentPoints[2][0]++;
						currentPoints[2][1]++;
						if (!testMove(selected, currentPoints[2][0], currentPoints[2][1])) {
							int[] addPos = {currentPoints[2][0], currentPoints[2][1]};
							positions = MDArray.insertRow(positions, addPos, positions.length);
						}

					}
				}

			}
			break;
		default: break;
		}//end pieceType switch

		//return all the found positions
		return positions;

	}//end findPositions()

	public static int[][] findPositionsNoCheck(int x, int y, String[][] board, Rectangle selected){

		//pieceType stores the char representing the selected piece, positions stores the end points of all viable moves for that piece, moveDistance is the max distance a piece can move, 7 for queen/rook/bishop, 1 for king
		int moveDistance = 7;
		char pieceType = board[x][y].toCharArray()[0];
		int[][] positions = new int[0][0];

		//switch to determine which move set to use depending on the piece
		switch (pieceType) {

		//case for pawns
		case 'P':

			//switch to check whether piece is a black or white pawn
			switch (board[x][y].toCharArray()[1]) {

			//case for white pawns
			case 'W': 

				//if the next space is empty, and the pawn isnt trying to move off the board, add a new position one space above pawn
				if (y>0&&board[x][y-1].toCharArray()[1]=='E') {

					int[] addPos = {x, y-1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

					//if the pawn is in its starting row, and the space two spaces ahead is empty, add moving forward 2 to positions array
					if (y+2==board.length&&board[x][y-2].toCharArray()[1]=='E') {

						int[] addPos2 = {x, y-2};
						positions = MDArray.insertRow(positions, addPos2, positions.length);

					}

				}//end if

				//if there is an opponent piece up and left, add up/left to positions array
				if (x>0&&y>0&&board[x-1][y-1].toCharArray()[1]==opponent) {

					int[] addPos = {x-1, y-1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				}

				//if there is an opponent piece up and right, add up/right to positions array
				if (x<7&&y>0&&board[x+1][y-1].toCharArray()[1]==opponent) {

					int[] addPos = {x+1, y-1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				} break;

				//case for black pawn
			case 'B':

				//if the piece is not at the edge of the board and the space in front of it empty, add move 1 forward to positions
				if (y<7&&board[x][y+1].toCharArray()[1]=='E') {

					int[] addPos = {x, y+1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

					//if the pawn is in its starting position and the space 2 forward is currently empty, add move two forward to positions
					if (y-1==0&&board[x][y+2].toCharArray()[1]=='E') {

						int[] addPos2 = {x, y+2};
						positions = MDArray.insertRow(positions, addPos2, positions.length);

					}

				}

				//if moving forward and left is possible and an opponent piece is forward and left, add forward/left to positions array
				if (x>0&&y<7&&board[x-1][y+1].toCharArray()[1]==opponent) {

					int[] addPos = {x-1, y+1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				}

				//if moving forward and right is possible and an opponent piece is forward and right, add forward/right to positions array
				if (x<7&&y<7&&board[x+1][y+1].toCharArray()[1]==opponent) {

					int[] addPos = {x+1, y+1};
					positions = MDArray.insertRow(positions, addPos, positions.length);

				} break;

			}//end black/white switch
			break;

			//case for knights
		case 'N':

			//if moving one space up wouldn't put the knight offboard
			if (x>0) {

				//if moving two spaces right wouldn't put the knight off board
				if (y<6) {

					//if the space one up two right isnt a player piece, add to positions
					if (!(board[x-1][y+2].toCharArray()[1]==player)) {

						int[] addPos = {x-1, y+2};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving two spaces left wouldn't put the knight off board
				if (y>1) {

					//if the space one up two right isnt a player piece, add to positions
					if (!(board[x-1][y-2].toCharArray()[1]==player)) {

						int[] addPos = {x-1, y-2};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

			}

			//if moving one space down wouldnt place the knight off the board
			if (x<7) {

				//if moving two right wouldn't place the knight off the board
				if (y<6) {

					//if one down two right isnt a player piece, add to positions
					if (!(board[x+1][y+2].toCharArray()[1]==player)) {

						int[] addPos = {x+1, y+2};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//moving two left wouldnt place knight off board
				if (y>1) {

					//if one down two left isnt a player piece, add to positions
					if (!(board[x+1][y-2].toCharArray()[1]==player)) {

						int[] addPos = {x+1, y-2};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

			}

			//if moving down 2 is possible
			if (x<6) {

				//if moving right 1 is possible
				if (y<7) {

					//if down 2 right 1 is not a player piece, add to positions
					if (!(board[x+2][y+1].toCharArray()[1]==player)) {

						int[] addPos = {x+2, y+1};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving left 1 is possible
				if (y>0) {

					//if down 2 left 1 is not a player piece, add to positions
					if (!(board[x+2][y-1].toCharArray()[1]==player)) {

						int[] addPos = {x+2, y-1};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

			}

			//if moving up one is possible
			if (x>1) {

				//if moving right 2 is possible
				if (y<7) {

					//if up 1 right 2 is not a player, add to positions
					if (!(board[x-2][y+1].toCharArray()[1]==player)) {

						int[] addPos = {x-2, y+1};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving left 2 is possible
				if (y>0) {

					//if up one left 2 isnt a player piece, add to positions
					if (!(board[x-2][y-1].toCharArray()[1]==player)) {

						int[] addPos = {x-2, y-1};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

			}
			break;

			//rook case. queen case flows through both rook and bishop case to improve code readability. king case functions like queen case, but sets move distance to 1 so it only checks one space out
		case 'K': moveDistance = 1;
		case 'Q':
		case 'R':

			//stores four positions, along the up, down, left and right axis
			int[][] currentPos = {

					{x,y},
					{x,y},
					{x,y},
					{x,y}

			};

			//loops 7 times, the maximum distance a piece can move in any direction
			for (int j = 0;j<moveDistance;j++) {

				//if moving up doesn't place the piece off board
				if (!(currentPos[0][0]-1<0)) {

					//if the current position isn't an enemy piece and the next space wouldn't be a player piece
					if (!(board[currentPos[0][0]][currentPos[0][1]].toCharArray()[1]==opponent)&&!(board[currentPos[0][0]-1][currentPos[0][1]].toCharArray()[1]==player)) {

						//move the current position up one and add position
						currentPos[0][0]--;
						int[] addPos = {currentPos[0][0], currentPos[0][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving left doesnt place piece off board
				if (!(currentPos[1][1]-1<0)) {

					//if current position isnt an enemy piece and one left isnt a player piece
					if (!(board[currentPos[1][0]][currentPos[1][1]].toCharArray()[1]==opponent)&&!(board[currentPos[1][0]][currentPos[1][1]-1].toCharArray()[1]==player)) {

						//move current position one left and add position
						currentPos[1][1]--;
						int[] addPos = {currentPos[1][0], currentPos[1][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving down doesn't place piece off board
				if (!(currentPos[2][0]+1>7)) {

					//if current position isn't an opponent piece and moving down one isn't a player piece
					if (!(board[currentPos[2][0]][currentPos[2][1]].toCharArray()[1]==opponent)&&!(board[currentPos[2][0]+1][currentPos[2][1]].toCharArray()[1]==player)) {

						//move current position down one and add position
						currentPos[2][0]++;
						int[] addPos = {currentPos[2][0], currentPos[2][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

				//if moving one right doesn't place piece off board
				if (!(currentPos[3][1]+1>7)) {

					//if current position isn't opponent piece, and moving one right isn't player piece
					if (!(board[currentPos[3][0]][currentPos[3][1]].toCharArray()[1]==opponent)&&!(board[currentPos[3][0]][currentPos[3][1]+1].toCharArray()[1]==player)) {

						//move current piece one right and add position
						currentPos[3][1]++;
						int[] addPos = {currentPos[3][0], currentPos[3][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}

				}

			}

			//if the current piece is a rook, not a king/queen, don't continue to bishop case
			if (pieceType == 'R') {

				break;

			}

			//bishop case
		case 'B':

			//creates booleans used to determine which directions can still be moved in, and sets the starting positions of the piece
			boolean[] direct = {true, true, true, true};
			int[][] currentPoints = {

					{x,y},
					{x,y},
					{x,y},
					{x,y}

			};

			//loops the max distance the piece can move
			for (int j = 0;j<moveDistance;j++) {

				//checks through all 4 directions, and if any direction is at the edge of the board, set its boolean to false
				if (currentPoints[0][0]-1<0||currentPoints[3][0]-1<0) {

					direct[0] = false;

				}
				if (currentPoints[0][1]-1<0||currentPoints[1][1]-1<0) {

					direct[2] = false;

				}
				if (currentPoints[2][0]+1>7||currentPoints[1][0]+1>7) {

					direct[1] = false;

				}
				if (currentPoints[2][1]+1>7||currentPoints[3][1]+1>7) {

					direct[3] = false;

				}

				//if the up and left booleans are true, the current position isn't an opponent and one up one left isn't a player piece
				if (direct[0]&&direct[2]) {
					if (!(board[currentPoints[0][0]][currentPoints[0][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[0][0]-1][currentPoints[0][1]-1].toCharArray()[1]==player)) {

						//move the current position up and left and add position
						currentPoints[0][0]--;
						currentPoints[0][1]--;
						int[] addPos = {currentPoints[0][0], currentPoints[0][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}
				}

				//if down and left is available, current position isn't opponent piece and down left isn't player piece
				if (direct[1]&&direct[2]) {
					if (!(board[currentPoints[1][0]][currentPoints[1][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[1][0]+1][currentPoints[1][1]-1].toCharArray()[1]==player)) {

						//move current position down and left and add position
						currentPoints[1][0]++;
						currentPoints[1][1]--;
						int[] addPos = {currentPoints[1][0], currentPoints[1][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}
				}

				//if up/right is available, current position isn't opponent piece and up/right isn't player piece
				if (direct[0]&&direct[3]) {
					if (!(board[currentPoints[3][0]][currentPoints[3][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[3][0]-1][currentPoints[3][1]+1].toCharArray()[1]==player)) {

						//move current position down/right and add position
						currentPoints[3][0]--;
						currentPoints[3][1]++;
						int[] addPos = {currentPoints[3][0], currentPoints[3][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}
				}

				//if down/right is available, current position isn't opponent piece and down/right isn't player piece
				if (direct[1]&&direct[3]) {
					if (!(board[currentPoints[2][0]][currentPoints[2][1]].toCharArray()[1]==opponent)&&!(board[currentPoints[2][0]+1][currentPoints[2][1]+1].toCharArray()[1]==player)) {

						//move current position down/right and add position
						currentPoints[2][0]++;
						currentPoints[2][1]++;
						int[] addPos = {currentPoints[2][0], currentPoints[2][1]};
						positions = MDArray.insertRow(positions, addPos, positions.length);

					}
				}

			}
			break;
		default: break;
		}//end pieceType switch

		//return all the found positions
		return positions;

	}//end findPositionsNoCheck()

	public static boolean testMove(Rectangle selected, int x, int y) {

		//creates a copy of the current board, and stores the information for the selected piece
		String[][] testBoard = MDArray.copyArray(board);
		String store = testBoard[(int) selected.getLayoutX()/100][(int) selected.getLayoutY()/100];

		//replaces the test board at the selected location with an empty space, and places the stored piece information in the ending location
		testBoard[(int) selected.getLayoutX()/100][(int) selected.getLayoutY()/100] = "EEEE";
		testBoard[x][y] = store;

		//return the result of running findKing with the simulated board
		return findKing(testBoard, selected);

	}

	public static boolean findKing(String[][] board, Rectangle selected) {

		//sets the default king location to 0,0
		int x = 0;
		int y = 0;

		//run through the entire board until the players king is found, then update the location of the king and break the loop
		for (int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				if (board[i][j].toCharArray()[0]=='K'&&board[i][j].toCharArray()[1]==player) {

					x = i;
					y = j;
					break;
				}
			}
		}

		//return the result of checkCheck() using the current board and king location
		return checkCheck(x, y, board, selected);

	}

	public static boolean checkCheck(int x, int y, String[][] board, Rectangle selected) {

		//loops through the entire board and checks each space for an opponents piece
		for (int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				if (board[i][j].toCharArray()[1]==opponent) {

					//swaps the active player
					char nextPlayer = opponent;
					opponent = player;
					player = nextPlayer;

					//get the available positions using the noCheck method
					int[][] currentPositions = findPositionsNoCheck(i, j, board, selected);

					//checks through all the available positions, and if one is found that matches the king location, swap the players back and return true
					for (int h = 0;h<currentPositions.length;h++) {
						if (currentPositions[h][0]==x) {
							if (currentPositions[h][1]==y) {

								nextPlayer = opponent;
								opponent = player;
								player = nextPlayer;

								return true;

							}
						}
					}

					//swap the players back
					nextPlayer = opponent;
					opponent = player;
					player = nextPlayer;

				}

			}

		}

		//if no check positions are found, after the loops end return false
		return false;

	}

	public static boolean checkMate(String notation) {

		//initialize the score difference as 0
		int scoreChange = 0;

		//checks all positions on the board to find player pieces
		for (int j = 0;j<8;j++) {
			for (int i = 0;i<8;i++) {
				if (board[j][i].toCharArray()[1]==player) {

					//creates a copy of the selected rectangle, places it at the location of the currently found player piece and attempt to find available positions
					Rectangle checkSelected = new Rectangle(100, 100, Color.TRANSPARENT);
					checkSelected.relocate(i*100, j*100);
					int[][] currentPositions = findPositions(j, i, board, checkSelected);

					//if any positions are found, return false
					if (currentPositions.length>0) 
						return false;

				}
			}
		}

		//if the code has got this far, the player has no moves available to make. therefore, if they are in check, it is checkmate, and if they are not in check it is stalemate
		if(findKing(board, selected)) {

			//print that the player is in mate, and increase or decrease the score if the player is black or white
			System.err.println(player + " in mate");
			if (player=='W') {
				scoreChange=15;
			}else {
				scoreChange=-15;
			} 

			//add a hashtag to the move notation to signal a checkmate
			notation = notation + "#";

		}else {

			//prints that the game is in stalemate, but don't change the score
			System.err.println("stalemate");

		}

		//save a new state
		ChessAI.states = Array.insertElement(ChessAI.states, new WorldState(board, player, notation+"#", (double) scoreChange), ChessAI.states.length);

		//try to store all the states in the text file
		try {
			ChessAI.saveStates();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//wait 4 seconds
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//close the system, then return true
		System.exit(scoreChange);
		return true;		

	}//end checkMate()

	public static void endTurn(Pane background, Stage arg0, int x, int y, Rectangle prePosition, Rectangle lastPrePosition, ChessBoard boardObject) {

		//create an integer to hold the current score difference, generate a notation string for the action and store the identifier string for the selected piece
		int scoreDiff = 0;
		String notation = "";//ChessAI.createNotation(x, y, selected);
		String store = board[(int) selected.getLayoutX()/100][(int) selected.getLayoutY()/100];

		//moves the position markers for the prior move to the start and end points of the new move
		prePosition.relocate(x*100, y*100);
		lastPrePosition.relocate(selected.getLayoutX(), selected.getLayoutY());

		//if the position being moved to contains a piece
		if (board[x][y].toCharArray()[0]!='E') {

			//determine the piece type using the char identifier, then change the score difference relative to the piece type
			char piece = board[y][x].toCharArray()[0];
			switch (piece) {
			case 'P': if (player=='W') {
				scoreDiff--;
			}else {
				scoreDiff++;
			} break;
			case 'N':
			case 'B': if (player=='W') {
				scoreDiff-=3;
			}else {
				scoreDiff+=3;
			} break;
			case 'R': if (player=='W') {
				scoreDiff-=5;
			}else {
				scoreDiff+=5;
			} break;
			case 'Q': if (player=='W') {
				scoreDiff-=9;
			}else {
				scoreDiff+=9;
			} break;

			}
		}

		//empty the selected space's identifier
		board[(int) selected.getLayoutX()/100][(int) selected.getLayoutY()/100] = "EEEE";

		//sets the moved to location to the selected piece identifier, move the selected rectangle offscreen
		board[x][y] = store;
		selected.relocate(-100, -100);

		//queens any queenable pawns, and if a pawn is queened, add an = to the notation
		if (upgradePawn(background)) 
			notation += "=";

		//swaps player to check if the opponent is currently in check mate
		char nextPlayer = opponent;
		opponent = player;
		player = nextPlayer;
		checkMate(notation);

		//if the opponent isn't currently in check mate, check if they opponent is in check. if white is in check, add 2 to score difference
		if(findKing(board, selected)&&player == 'W') 
			scoreDiff+=2;

		//sets board for the next turn and saves current state
		ChessAI.states = Array.insertElement(ChessAI.states, new WorldState(board, player, notation, (double) scoreDiff), ChessAI.states.length);
		cleanBoard(boardObject);

		textSpace.addText(opponent + ": " + notation);
		
		if (player=='B')
			ChessAI.move(board, background, prePosition, lastPrePosition, arg0, boardObject);

	}

	public static boolean upgradePawn(Pane background) {

		//loops through all tiles on the board, and finds pawns
		for (int i = 0;i<8;i++) {
			for (int j = 0;j<8;j++) {
				if (board[i][j].toCharArray()[0]=='P') {

					//if a pawn is found, check the pawns player and determines if it is on its opponents backline. if it is, changes the pawn to a queened pawn and returns true
					if (board[i][j].toCharArray()[1]=='W') {
						if (j == 0) {
							board[i][j] = "Q" + "W" + board[j][i].toCharArray()[2] + "P";
							return true;
						}
					}else {
						if (j == 7) {
							board[i][j] = "Q" + "B" + board[j][i].toCharArray()[2] + "P";
							return true;
						}
					}

				}

			}

		}

		//if no pawns to queen are found, return false
		return false;

	}

}//end class