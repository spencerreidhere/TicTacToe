package de.reid.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class TicTacToeBoard {
	private boolean playable = true;
	private boolean turnX = true;
	private final Tile[][] board = new Tile[3][3];
	private final List<Combo> combos = new ArrayList<>();
	private final Pane root;

	public TicTacToeBoard(final Pane root) {
		this.root = root;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final Tile tile = new Tile(this);
				tile.setTranslateX(j * 200);
				tile.setTranslateY(i * 200);
				root.getChildren().add(tile);

				board[j][i] = tile;
			}
		}

		// horizontal
		for (int y = 0; y < 3; y++) {
			combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
		}

		// vertikal
		for (int x = 0; x < 3; x++) {
			combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
		}

		// diagonal
		combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
		combos.add(new Combo(board[2][0], board[1][1], board[0][2]));

	}

	protected void checkState() {
		for (final Combo combo : combos) {
			if (combo.isComplete()) {
				setPlayable(false);
				playWinAnimation(combo);
				break;
			}
		}
	}

	private void playWinAnimation(final Combo combo) {
		final Line line = new Line();

		line.setStartX(combo.getTiles()[0].getCenterX());
		line.setStartY(combo.getTiles()[0].getCenterY());
		line.setEndX(combo.getTiles()[0].getCenterX());
		line.setEndY(combo.getTiles()[0].getCenterY());

		root.getChildren().add(line);

		final Timeline timeline = new Timeline();
		timeline.getKeyFrames()
				.add(new KeyFrame(Duration.seconds(2),
						new KeyValue(line.endXProperty(), combo.getTiles()[2].getCenterX()),
						new KeyValue(line.endYProperty(), combo.getTiles()[2].getCenterY())));

		timeline.play();
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public boolean isTurnX() {
		return turnX;
	}

	public void setTurnX(boolean turnX) {
		this.turnX = turnX;
	}

}
