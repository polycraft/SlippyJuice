package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;
import com.polycraft.slippyjuice.ui.HUD;

public class GameLoopRenderer extends Renderer {

	public GameLoopRenderer(AssetManager assetManager, Player player) {
		super(assetManager);
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		Gdx.input.setInputProcessor(scene);
		hud = new HUD(assetManager, width, height, true, batch);
		Gdx.input.setInputProcessor(hud);

		scene.addActor(player.getCharacter());
	}

	@Override
	public void render(float deltaTime, GameLoopEngine gameLoopEngine) {

		scene.act(deltaTime);
		hud.act(deltaTime);

		// draw the scene
		// init the background color
		Gdx.gl.glClearColor(0, 0.68f, 0.94f, 1);
		// actualise le background
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		scene.draw();
		hud.draw();
	}

}
