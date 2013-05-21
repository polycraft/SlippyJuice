package com.polycraft.slippyjuice.simulation;

import java.text.DecimalFormat;

import com.polycraft.slippyjuice.player.Caracteristics;
import com.polycraft.slippyjuice.player.Player;

public class GameLoopEngine {
	private GameLoopState gameLoopState;
	private Player player;
	private float acceleration;
	private float speed;
	private static float LIMIT = 0.1f;

	public GameLoopEngine(Player player) {
		super();
		acceleration = 0;
		speed = 4;
		this.player = player;
		gameLoopState = GameLoopState.CREATED;
	}

	public void update(float deltaTime) {
		DecimalFormat df = new DecimalFormat("###.##");
		// force of player to +X, like powers
		float forceX = 0;
		// ground friction ( depends on the ground's type)
		float forceFriction = 1f;
		// player weight
		float weight = player.getPropertie(Caracteristics.WEIGHT);

		// player acceleration
		Float playerAcceleration = player
				.getPropertie(Caracteristics.ACCELERATION);
		// player speed
		Float playerSpeed = player.getPropertie(Caracteristics.SPEED);

		// calculate New Acceleration
		float newAcceleration = (forceX - forceFriction * playerSpeed) / weight;
		// calculate New Speed
		float newSpeed = playerSpeed + newAcceleration * deltaTime;
		if (newSpeed < LIMIT)
			newSpeed = 0;

		// Calculate distance
		float distance = (newSpeed + playerSpeed) * deltaTime / 2;

		System.out.println("Player(" + weight + "g) Acc="
				+ df.format(newAcceleration) + " Speed=" + df.format(newSpeed)
				+ "m/s Dist=" + distance + "m");

		player.getCharacter().translate(distance * 64, 0);
		// MAJ Acceleration
		playerAcceleration = newAcceleration;
		// MAJ Speed
		playerSpeed = newSpeed;
	}
}
