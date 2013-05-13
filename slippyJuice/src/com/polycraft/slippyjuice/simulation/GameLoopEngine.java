package com.polycraft.slippyjuice.simulation;

import java.text.DecimalFormat;

import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.stuff.Caracteristics;

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
		float forceX = 2;
		// ground friction ( depends on the ground's type)
		float forceFriction = 1f;
		// player weight
		float weight = player.getPropertie(Caracteristics.WEIGHT);

		// calculate New Acceleration
		float newAcceleration = (forceX - forceFriction * speed) / weight;
		// calculate New Speed
		float newSpeed = speed + newAcceleration * deltaTime;
		if (newSpeed < LIMIT)
			newSpeed = 0;

		// Calculate distance
		float distance = (newSpeed + speed) * deltaTime / 2;

		System.out.println("Player(" + weight + "g) Acc="
				+ df.format(acceleration) + " Speed=" + df.format(newSpeed)
				+ "m/s Dist=" + distance + "m");

		player.getCharacter().translate(distance * 64, 0);
		// MAJ Acceleration
		acceleration = newAcceleration;
		// MAJ Speed
		speed = newSpeed;
	}
}
