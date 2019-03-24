package de.reid.gui;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
	private final Text text = new Text();

	public Tile(final TicTacToeBoard board) {
		final Rectangle border = new Rectangle(200, 200);
		border.setFill(null);
		border.setStroke(Color.BLACK);

		text.setFont(Font.font(72));

		setAlignment(Pos.CENTER);
		getChildren().addAll(border);
		getChildren().addAll(text);

		setOnMouseClicked(event -> {
			if (!board.isPlayable())
				return;

			if (event.getButton() == MouseButton.PRIMARY) {
				if (!board.isTurnX())
					return;
				drawX();
				board.setTurnX(false);
				board.checkState();
			} else if (event.getButton() == MouseButton.SECONDARY) {
				if (board.isTurnX())
					return;
				drawO();
				board.setTurnX(true);
				board.checkState();
			}
		});

	}

	public String getValue() {
		return text.getText();
	}

	public double getCenterX() {
		return getTranslateX() + 100;
	}

	public double getCenterY() {
		return getTranslateY() + 100;
	}

	private void drawX() {
		text.setText("X");
	}

	private void drawO() {
		text.setText("O");
	}

}
