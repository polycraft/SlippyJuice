package com.polycraft.slippyjuice;

import com.badlogic.gdx.Game;
import com.polycraft.slippyjuice.screens.GameLoopScreen;
import com.polycraft.slippyjuice.screens.MainMenuScreen;

public class SlippyJuice extends Game {

	private MainMenuScreen mainMenuScreen;
	private GameLoopScreen gameLoopScreen;

	@Override
	public void create() {
		mainMenuScreen = new MainMenuScreen(this);
		gameLoopScreen = new GameLoopScreen(this);
		setMainMenuScreen();
	}

	public void setMainMenuScreen() {
		setScreen(mainMenuScreen);
		System.out.println("menu rendering");
	}

	public void setGameLoopScreen() {
		setScreen(gameLoopScreen);
		System.out.println("game rendering");
	}

}
