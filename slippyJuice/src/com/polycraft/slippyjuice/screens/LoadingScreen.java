package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.polycraft.slippyjuice.SlippyJuice;

public class LoadingScreen extends SlippyJuiceScreen {

	private String screenToLoad;

	public LoadingScreen(SlippyJuice game, AssetManager assetManager) {
		super(game, assetManager);

	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(0.5f, 0.5f, 0, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		assetManager.update();
		System.out.println(assetManager.getProgress() * 100 + "%");
		if (assetManager.update()) {
			game.setScreen(screenToLoad);
		}
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

	public void setScreenToLoad(String screen) {
		this.screenToLoad = screen;
	}

}
