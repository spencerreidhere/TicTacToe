package de.reid.app;

import de.reid.gui.TicTacToeBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {

		final Pane root = new Pane();
		new TicTacToeBoard(root);

		final Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
