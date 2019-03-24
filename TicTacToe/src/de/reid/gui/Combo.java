package de.reid.gui;

public class Combo {
	private final Tile[] tiles;

	public Combo(final Tile... tiles) {
		this.tiles = tiles;
	}

	public boolean isComplete() {
		if (getTiles()[0].getValue().isEmpty()) {
			return false;
		}
		return getTiles()[0].getValue().equals(getTiles()[1].getValue()) && getTiles()[0].getValue().equals(getTiles()[2].getValue());

	}

	public Tile[] getTiles() {
		return tiles;
	}

}
