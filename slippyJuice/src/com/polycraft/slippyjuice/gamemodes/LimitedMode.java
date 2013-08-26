package com.polycraft.slippyjuice.gamemodes;

import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.Properties;

public class LimitedMode extends GameMode {

	public LimitedMode() {
		super();
		startingTime = 5;
		runningTime = 5;
	}

	@Override
	protected void start(Player player) {
		System.out.println("Starting...");
		player.getCharacter().run();
		if (time > startingTime) {
			changeStateTo(GameModeState.RUNNING);
			System.out.println("******* Start End *******");
			player.updatePropertie(Properties.FORCEX, 10f);
			player.getCharacter().vomit();

		}

	}

	@Override
	protected void run(Player player) {
		System.out.println("Running...");
		if (time > runningTime) {
			changeStateTo(GameModeState.STOPPING);
			System.out.println("******* Run End *******");

			player.updatePropertie(Properties.FORCEX, 0f);
		}
	}

	@Override
	protected void stop(Player player) {
		System.out.println("Stopping...");
		if (time > runningTime) {
			changeStateTo(GameModeState.STARTING);
			System.out.println("******* Stop End *******");
		}
	}

}
