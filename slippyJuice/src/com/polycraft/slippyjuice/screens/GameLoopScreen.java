package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Gdx;
import com.polycraft.slippyjuice.SlippyJuice;

public class GameLoopScreen extends SlippyJuiceScreen {

	public GameLoopScreen(SlippyJuice game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(float delta) {
		if (Gdx.input.justTouched())
			game.setMainMenuScreen(); // test switching screens
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
