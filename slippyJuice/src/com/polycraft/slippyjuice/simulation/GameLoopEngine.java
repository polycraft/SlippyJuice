package com.polycraft.slippyjuice.simulation;

import java.util.Observable;

import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.gamemodes.GameMode;
import com.polycraft.slippyjuice.pattern.GroundGenerator;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.Properties;
import com.polycraft.slippyjuice.scene.LayerType;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.scene.ground.Ground;

public class GameLoopEngine extends Observable {
	private AssetManager assetManager;
	private GameLoopState gameLoopState;

	private GameMode gameMode;
	private Player player;
	private Scene scene;

	private GroundGenerator groundGenerator;

	private static float LIMIT = 0.001f;

	private float totalDistance;

	public GameLoopEngine(Player player, Scene scene,
			AssetManager assetManager, GameMode gameMode) {
		super();
		this.player = player;
		this.scene = scene;

		totalDistance = 0;
		this.assetManager = assetManager;
		groundGenerator = new GroundGenerator(assetManager, 4, 15);
		// / a deporter
		buildScene();
		updateScene();

		this.gameMode = gameMode;

		setState(GameLoopState.READY);
	}

	private void buildScene() {
		Ground ground = new Ground();

		// ground.addPieces(pieces);

		scene.setLayer(LayerType.GROUND, ground);

		scene.addActor(player.getCharacter());

	}

	public void update(float deltaTime) {
		switch (gameLoopState) {
		case READY:
			setState(GameLoopState.RUNNING);
			break;
		case RUNNING:
			run(deltaTime);
			break;
		case PAUSED:

			break;
		case STOPPED:

			break;
		default:
			break;
		}

	}

	private void run(float deltaTime) {
		float distance = simulate(deltaTime);
		moveDistance(distance);

		if (scene != null) {
			scene.update(-distance);
		}

		updateScene();

		gameMode.runMode(deltaTime, player);
	}

	private float simulate(float deltaTime) {
		// force of player to +X, like powers
		float forceX = player.getPropertie(Properties.FORCEX);
		// float forceX = 30;
		// ground friction ( depends on the ground's type)
		float forceFriction = player.getPropertie(Properties.FRICTION);
		// player weight
		float weight = player.getPropertie(Properties.WEIGHT);

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
		player.updatePropertie(Properties.ACCELERATION, newAcceleration);
		player.updatePropertie(Properties.SPEED, newSpeed);

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
				ground.addPieces(groundGenerator.generatePath());
			}
		}

	}

	private void moveDistance(float distance) {
		totalDistance += distance;
		setChanged();
		notifyObservers();
	}

	public float getTotalDistance() {
		return totalDistance;
	}

	public GameLoopState getState() {
		return gameLoopState;
	}

	public void setState(GameLoopState gameLoopState) {
		this.gameLoopState = gameLoopState;
		System.out.println("Game " + gameLoopState);
	}

}
