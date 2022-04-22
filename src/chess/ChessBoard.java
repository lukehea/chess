package chess;

import java.util.LinkedList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ChessBoard extends GameBoard {

	public LinkedList<Rectangle> rectangles;
	
	public ChessBoard(int rows, int columns, double height, double width, double xPos, double yPos, Color boardColor1, Color boardColor2) {
		super(rows, columns, height, width, xPos, yPos, boardColor1, boardColor2);
		this.cellHeight = height/rows;
		this.cellWidth = width/rows;
		this.rectangles = new LinkedList<Rectangle>();
	}

	/**
	 * Returns a pane with the graphical representation of the game board, with each cell as its own separate rectangle on the pane.
	 * Whenever any cell on the board is clicked, the last coordinates int array will be updated to contain the row and column number
	 * of the clicked cell.
	 * @return pane with the graphical representation fo the game board.
	 */
	public Pane getBoardToDisplay() {
		
		//create root pane
		Pane root = new Pane();
		
		//first print out all the squares in a nested for loop
		double xCoordinate = this.xPos;
		double yCoordinate = this.yPos;
		
		for(int i = 0; i < this.rows; i++) {
			
			for(int j = 0; j < this.columns; j++) {
				
				//create cell and adds to list
				Rectangle cell = new Rectangle(xCoordinate, yCoordinate, this.cellWidth, this.cellHeight);
				this.rectangles.addLast(cell);
				
				//create checkered pattern if two colors; otherwise make them all same color
				if((i+j)%2 == 1 && this.boardColor2 != null) cell.setFill(this.boardColor2);
				else cell.setFill(this.boardColor1);
				
				//if clicked, set lastCoordinates to the row and column of the cell
				cell.setOnMouseClicked(event -> {
					this.lastCoordinates[0] = (int) ((cell.getLayoutBounds().getMinX() - this.xPos)/this.cellWidth);
					this.lastCoordinates[1] = (int) ((cell.getLayoutBounds().getMinY() - this.yPos)/this.cellHeight);
				});
				
				//add to pane
				root.getChildren().add(cell);
				
				//give a border for the sides if columnBorders are selected (don't do it on the exposed side of the edge cells)
				if(this.columnBorder) {
					if(j != 0) {
						Line leftBorder = new Line(xCoordinate, yCoordinate, xCoordinate, yCoordinate + this.cellHeight);
						leftBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(leftBorder);
					}
					if(j != this.columns-1) {
						Line rightBorder = new Line(xCoordinate + this.cellWidth, yCoordinate, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
						rightBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(rightBorder);
					}//end if
				}//end if
				
				//do same for rows if rowBorders are selected (don't do it on the exposed side of the top and bottom cells)
				if(this.columnBorder) {
					if(i != 0) {
						Line topBorder = new Line(xCoordinate, yCoordinate, xCoordinate + this.cellWidth, yCoordinate);
						topBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(topBorder);
					}
					if(i != this.rows-1) {
						Line bottomBorder = new Line(xCoordinate, yCoordinate + this.cellHeight, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
						bottomBorder.setStrokeWidth(this.innerBorderWeight);
						root.getChildren().add(bottomBorder);
					}//end if
				}//end if
				
				//also add borders to exposed sides of cells if those options are selected
				if(this.leftBorder && j == 0) {
					Line leftBorder = new Line(xCoordinate, yCoordinate, xCoordinate, yCoordinate + this.cellHeight);
					leftBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(leftBorder);
				}
				if(this.rightBorder && j == this.columns-1) {
					Line rightBorder = new Line(xCoordinate + this.cellWidth, yCoordinate, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
					rightBorder.setStrokeWidth(this.innerBorderWeight);
					root.getChildren().add(rightBorder);
				}
				if(this.topBorder && i == 0) {
					Line topBorder = new Line(xCoordinate, yCoordinate, xCoordinate + this.cellWidth, yCoordinate);
					topBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(topBorder);
				}
				if(this.bottomBorder && i == this.rows - 1) {
					Line bottomBorder = new Line(xCoordinate, yCoordinate + this.cellHeight, xCoordinate + this.cellWidth, yCoordinate + this.cellHeight);
					bottomBorder.setStrokeWidth(this.outerBorderWeight);
					root.getChildren().add(bottomBorder);
				}//end series of if statements
				
				//update the x coordinate when moving to next cell
				xCoordinate += this.cellWidth;
				
			}//end inner for
			
			//update both the x and y coordinates when moving onto next row
			xCoordinate = this.xPos;
			yCoordinate += this.cellHeight;
			
		}//end outer for
		
		return root;
	}//end getBoardToDisplay method
	
	public void toFront() {
		
		//goes through all cells in the list and brings them to front
		for(int i = 0;i<rectangles.size();i++) 
			this.rectangles.get(i).toFront();
		
	}
	
}
