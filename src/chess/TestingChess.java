package chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import com.google.gson.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import array.MDArray;

public class TestingChess extends Application{

	public static void main(String[] args) throws IOException {

		launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {

		Pane background = new Pane();
		Scene scene = new Scene(background, 800, 800, Color.WHITE);
		arg0.setScene(scene);
		arg0.show();

		TextBox box = new TextBox(Color.WHITE, 600, 150, 100, 100, Color.BLACK, background);

		box.showTBox();
		box.addText("Hello World");

		//code runs when user clicks on the screen
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Random rand = new Random();
				if (rand.nextInt()>.5) {
					box.addText("Goodbye World");
				}else {
					box.addText("Hello World");
				}
			}

		});

	}


	public static String toString(WorldState s1) {

		Gson gson = new Gson();

		return gson.toJson(s1);

	}

	public static WorldState fromString() throws IOException {

		BufferedReader read = new BufferedReader(new FileReader("chessStates.json"));

		String gsonData = read.readLine();

		Gson gsonParser = new Gson();

		return gsonParser.fromJson(gsonData, WorldState.class);

	}

}
