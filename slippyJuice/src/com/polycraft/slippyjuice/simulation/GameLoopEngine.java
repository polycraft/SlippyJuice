package com.polycraft.slippyjuice.simulation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.polycraft.slippyjuice.assets.SlippyJuiceAssets;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.Properties;
import com.polycraft.slippyjuice.scene.LayerType;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.scene.ground.Ground;
import com.polycraft.slippyjuice.scene.ground.GroundPiece;

public class GameLoopEngine extends Observable {
	private AssetManager assetManager;
	private GameLoopState gameLoopState;
	private Player player;
	private Scene scene;
	private static float LIMIT = 0.001f;

	private float totalDistance;

	public GameLoopEngine(Player player, Scene scene, AssetManager assetManager) {
		super();
		this.player = player;
		this.scene = scene;
		gameLoopState = GameLoopState.CREATED;
		totalDistance = 0;
		this.assetManager = assetManager;
		// / a deporter
		buildScene();
	}

	private void buildScene() {
		Ground ground = new Ground();

		// ground.addPieces(pieces);

		scene.setLayer(LayerType.GROUND, ground);

		scene.addActor(player.getCharacter());

	}

	public void update(float deltaTime) {
		float distance = simulate(deltaTime);
		moveDistance(distance);

		if (scene != null) {
			scene.update(-distance);
		}

		updateScene();
	}


	private float simulate(float deltaTime) {
		DecimalFormat df = new DecimalFormat("###.##");
		// force of player to +X, like powers
		float forceX = 20;
		// ground friction ( depends on the ground's type)
		float forceFriction = player.getPropertie(Properties.FRICTION);
		// player weight
		float weight = player.getPropertie(Properties.WEIGHT);

		// player acceleration
		Float playerAcceleration = player.getPropertie(Properties.ACCELERATION);
		// player speed
		Float playerSpeed = player.getPropertie(Properties.SPEED);

		// calculate New Acceleration
		float newAcceleration = (forceX - forceFriction * playerSpeed) / weight;
		// calculate New Speed
		float newSpeed = playerSpeed + newAcceleration * deltaTime;
		if (newSpeed < LIMIT)
			newSpeed = 0;

		// Calculate distance
		float distance = (newSpeed + playerSpeed) * deltaTime / 2;

		//
		// System.out.println("Player(" + weight + "g) Acc="
		// + df.format(playerAcceleration) + " Speed="
		// + df.format(playerSpeed) + "m/s Dist=" + distance + "m");

		// MAJ Acceleration
		// MAJ Speed

		// UPDATE MODEL
		player.update(Properties.ACCELERATION, newAcceleration);
		player.update(Properties.SPEED, newSpeed);

		return distance;
	}

	private void updateScene() {
		// ground
		if (Ground.class.isInstance(scene.getLayer(LayerType.GROUND))) {
			Ground ground = (Ground) scene.getLayer(LayerType.GROUND);
			if (ground.isDeleteLines()) {
				ground.deleteFirstPieces();
			}
			if (ground.isAddLines()) {
				// ajouter un générateur
				ground.addPieces(generateNewPieces());
			}
		}

	}

	private List<GroundPiece> generateNewPieces() {
		List<GroundPiece> pieces = new ArrayList<GroundPiece>();
		for (int i = 0; i < 4; i++) {
			GroundPiece piece = new GroundPiece(assetManager.get(
					SlippyJuiceAssets.getPath("groundPiece"), Texture.class));
			pieces.add(piece);
		}
		return pieces;
	}

	private void moveDistance(float distance) {
		totalDistance += distance;
		setChanged();
		notifyObservers();
	}

	public float getTotalDistance() {
		return totalDistance;
	}

}
