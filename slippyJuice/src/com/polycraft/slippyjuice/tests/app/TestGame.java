package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Game;

public class TestGame extends Game {

	private TestScreen testScreen;

	@Override
	public void create() {
		testScreen = new TestScreen(this);
		setTestScreen();
	}

	public void setTestScreen() {
		setScreen(testScreen);
	}

}
