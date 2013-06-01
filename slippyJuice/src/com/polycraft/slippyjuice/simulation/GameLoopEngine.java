package com.polycraft.slippyjuice.simulation;

import java.text.DecimalFormat;

import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.Properties;
import com.polycraft.slippyjuice.scene.Scene;

public class GameLoopEngine {
	private GameLoopState gameLoopState;
	private Player player;
	private Scene scene;
	private static float LIMIT = 0.001f;

	public GameLoopEngine(Player player, Scene scene) {
		super();
		this.player = player;
		this.scene = scene;
		gameLoopState = GameLoopState.CREATED;
	}

	public void update(float deltaTime) {
		DecimalFormat df = new DecimalFormat("###.##");
		// force of player to +X, like powers
		float forceX = 1;
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

		System.out.println("Player(" + weight + "g) Acc="
				+ df.format(playerAcceleration) + " Speed="
				+ df.format(playerSpeed) + "m/s Dist=" + distance + "m");

		if (scene != null) {
			scene.update(-distance);
		}
		// MAJ Acceleration
		// MAJ Speed

		// UPDATE MODEL
		player.update(Properties.ACCELERATION, newAcceleration);
		player.update(Properties.SPEED, newSpeed);
	}
}
