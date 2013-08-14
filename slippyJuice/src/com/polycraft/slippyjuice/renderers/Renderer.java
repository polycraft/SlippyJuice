package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;
import com.polycraft.slippyjuice.ui.HUD;

public abstract class Renderer {
	protected AssetManager assetManager;
	protected OrthographicCamera camera;
	protected SpriteBatch batch;
	protected Scene scene;
	protected HUD hud;

	public Renderer(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	public void render(float delta) {

	}

	public void render(float deltaTime, GameLoopEngine gameLoopEngine) {
		// TODO Auto-generated method stub

	}

	public Scene getScene() {
		return this.scene;
	}

	public HUD getHud() {
		return hud;
	}

}
