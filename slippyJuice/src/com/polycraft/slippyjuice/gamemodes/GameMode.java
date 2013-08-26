package com.polycraft.slippyjuice.gamemodes;

import com.polycraft.slippyjuice.player.Player;

public abstract class GameMode {

	protected float time;
	protected float startingTime;
	protected float runningTime;
	protected GameModeState state;

	public GameMode() {
		state = GameModeState.STARTING;
		startingTime = 0;
		runningTime = 0;
		time = 0;
	}

	public void runMode(float deltaTime, Player player) {
		time += deltaTime;

		switch (state) {
		case NONE:
			state = GameModeState.STARTING;
			break;
		case STARTING:
			start(player);
			break;
		case RUNNING:
			run(player);
			break;
		case STOPPING:
			stop(player);
			break;
		}

	}

	protected abstract void start(Player player);

	protected abstract void run(Player player);

	protected abstract void stop(Player player);

	public void changeStateTo(GameModeState state) {
		time = 0;
		this.state = state;
	}

}
