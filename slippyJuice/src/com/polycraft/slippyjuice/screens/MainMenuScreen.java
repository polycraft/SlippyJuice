package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.SlippyJuice;
import com.polycraft.slippyjuice.renderers.MainMenuRenderer;

public class MainMenuScreen extends SlippyJuiceScreen {

	public MainMenuScreen(float height, float width, SlippyJuice game,
			AssetManager assetManager) {
		super(game, assetManager);
		renderer = new MainMenuRenderer(height, width, assetManager);

	}

	@Override
	public void render(float delta) {
		renderer.render(delta);

		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			game.setLoading("game"); // test switching screens

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
