package com.polycraft.slippyjuice.scene.ground;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.scene.Layer;

public class Ground extends Layer {
	private static int NB_LINES_GROUND = 4;
	private static int NB_COLUMN_GROUND = 15;

	private List<GroundPiece> groundPieces;

	private boolean deleteLines;
	private boolean addLines;

	public Ground() {
		super(new Float(1));
		groundPieces = new ArrayList<GroundPiece>();
		deleteLines = false;
		addLines = true;
	}

	@Override
	public void update(Float distance) {
		System.out.println("groundPieces: " + groundPieces.size());
		for (GroundPiece piece : groundPieces) {
			if (isOutOfRange(piece)) {
				deleteLines = true;
			}
			piece.translate(distance * (piece.getWidth() / 2) / farDistance, 0);
		}
		if (groundPieces.size() / NB_LINES_GROUND <= NB_COLUMN_GROUND) {
			addLines = true;
		} else if (addLines) {
			addLines = false;
		}
	}

	private boolean isOutOfRange(GroundPiece piece) {
		boolean outOfRange = false;
		outOfRange = piece.getX() + piece.getWidth() < 0;
		return outOfRange;
	}

	public void addPieces(List<GroundPiece> newPieces) {
		// alignement des nouvelles pieces du sol
		for (GroundPiece piece : newPieces) {
			piece.setSize(128, 64);
			piece.setPosition(getNextPositionX(), getNextPositionY());
			this.addActor(piece);
			this.groundPieces.add(piece);
		}
	}

	public void deleteFirstPieces() {
		deletePieces(1);
	}

	public void deletePieces(int nbLines) {
		for (int i = 0; i < NB_LINES_GROUND * nbLines; i++) {
			groundPieces.get(0).remove();
			groundPieces.remove(0);
		}
		deleteLines = false;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {

		super.draw(batch, parentAlpha);
	}

	private float getNextPositionX() {
		float nextPositionX = 0;

		if (!groundPieces.isEmpty()) {
			if ((groundPieces.size() % NB_LINES_GROUND) != 0) {
				// position X de l'ancienne
				nextPositionX = groundPieces.get(groundPieces.size() - 1)
						.getX();
			} else {
				// position X de l'ancienne + sa taille
				nextPositionX = groundPieces.get(groundPieces.size() - 1)
						.getX()
						+ groundPieces.get(groundPieces.size() - 1).getWidth()
						/ 2;
			}

		}

		return nextPositionX;
	}

	private float getNextPositionY() {
		float nextPositionY = (NB_LINES_GROUND - 1) * 64;

		if (!groundPieces.isEmpty()) {
			if ((groundPieces.size() % NB_LINES_GROUND) != 0) {
				// position Y de l'ancienne - sa taille
				nextPositionY = groundPieces.get(groundPieces.size() - 1)
						.getY()
						- groundPieces.get(groundPieces.size() - 1).getHeight();

			} else {
				// position Y de l'ancienne
				nextPositionY = groundPieces.get(groundPieces.size() - 4)
						.getY();
			}

		}

		return nextPositionY;
	}

	public boolean isDeleteLines() {
		return deleteLines;
	}

	public boolean isAddLines() {
		return addLines;
	}
}
