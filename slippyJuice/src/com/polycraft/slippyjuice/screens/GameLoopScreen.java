package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.SlippyJuice;
import com.polycraft.slippyjuice.renderers.GameLoopRenderer;

public class GameLoopScreen extends SlippyJuiceScreen {

	public GameLoopScreen(SlippyJuice game, AssetManager assetManager) {
		super(game, assetManager);
		renderer = new GameLoopRenderer(assetManager);
	}

	@Override
	public void render(float delta) {
		renderer.render(delta);
		if (Gdx.input.justTouched())
			game.setLoading("menu"); // test switching screens
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
