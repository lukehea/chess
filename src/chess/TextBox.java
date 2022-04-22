package chess;

import array.Array;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TextBox extends Object{

	private Color color;
	private double height;
	private double width;
	private Text[] text;
	double posX;
	double posY;
	Rectangle box;
	Color borderColor;
	Pane pane;
	double strokeWidth;

	public TextBox(Color color, double height, double width, double xPosition, double yPosition, Pane pane) {

		this.color = color;
		this.height = height;
		this.width = width;
		this.posX = xPosition;
		this.posY = yPosition;
		this.text = new Text[0];
		this.borderColor = Color.TRANSPARENT;
		this.pane = pane;
		this.strokeWidth = 0;

	}

	public TextBox(Color color, double height, double width, double xPosition, double yPosition, Color borderColor, Pane pane) {

		this.color = color;
		this.height = height;
		this.width = width;
		this.posX = xPosition;
		this.posY = yPosition;
		this.text = new Text[0];
		this.borderColor = borderColor;
		this.pane = pane;
		this.strokeWidth = 5;

	}
	
	public TextBox(Color color, double height, double width, double xPosition, double yPosition, Color borderColor, Pane pane, double borderWidth) {

		this.color = color;
		this.height = height;
		this.width = width;
		this.posX = xPosition;
		this.posY = yPosition;
		this.text = new Text[0];
		this.borderColor = borderColor;
		this.pane = pane;
		this.strokeWidth = borderWidth;

	}

	public Color getColor() {

		return this.color;

	}

	public void setColor(Color color) {

		this.color = color;

	}

	public double getHeight() {

		return this.height;

	}

	public void setHeight(double height) {

		this.height = height;

	}

	public double getWidth() {

		return this.width;

	}

	public void setWidth(double width) {

		this.width = width;

	}

	public double getPosX() {

		return this.posX;

	}

	public void setPosX(double posX) {

		this.posX = posX;

	}

	public double getPosY() {

		return this.posY;

	}

	public void setPosY(double posY) {

		this.posY = posY;
		this.box.relocate(this.posY, this.posX);

	}

	public void showTBox() {

		this.box = new Rectangle(this.width, this.height, this.color);
		this.box.relocate(this.posX, this.posY);
		this.box.setStroke(borderColor);
		this.box.setStrokeWidth(this.strokeWidth);
		pane.getChildren().add(this.box);

	}

	public void addText(String text) {

		for (int i = 0;i<this.text.length;i++) {
			this.text[i].setLayoutY(this.text[i].getLayoutY()-25);
		}
		
		Text newText = new Text(text);
		newText.relocate(this.posX + 5 + this.strokeWidth, this.posY + this.height - 15 - this.strokeWidth);
		this.text = Array.insertElement(this.text, newText, this.text.length);
		
		if (this.text.length>(height/25)) {
			
			this.text[0].setFill(Color.TRANSPARENT);
			this.text = Array.deleteElement(this.text, 0);
			
		}
		
		pane.getChildren().add(newText);

	}

}