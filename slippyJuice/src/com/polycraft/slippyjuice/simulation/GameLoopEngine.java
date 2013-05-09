package com.polycraft.slippyjuice.simulation;

import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.scene.Scene;

public class GameLoopEngine {
	private Player player;
	private Scene scene;
	private float acceleration;
	private float speed;

	public GameLoopEngine(Player player, Scene scene) {
		super();
		acceleration = 0;
		speed = 64;
		this.player = player;
		this.scene = scene;
	}

	public void buildScene() {

	}

	public void update(float deltaTime) {
		// calculate New Speed
		float newSpeed = speed + acceleration * deltaTime;
		// Calculate distance
		float distance = (newSpeed + speed) * deltaTime / 2;

		// System.out.println("A:" + acceleration + ";S:" + speed + " :: NewS:"
		// + newSpeed + ";Dist:" + distance);

		// MAJ Speed
		speed = newSpeed;
	}
}
