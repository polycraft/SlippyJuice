package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.PlayerInformation;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.scene.character.Character;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;

public class GameLoopRenderer extends Renderer {

	private GameLoopEngine gameLoopEngine;

	private Player player;

	public GameLoopRenderer(AssetManager assetManager) {
		super(assetManager);
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		Gdx.input.setInputProcessor(scene);

		PlayerInformation playerInformation = new PlayerInformation("TEST", 0,
				1);
		player = new Player(playerInformation);
		player.setCharacter(new Character(assetManager, 0, 0, 100, 100));

		gameLoopEngine = new GameLoopEngine(player, scene);
		scene.addActor(player.getCharacter());
	}

	@Override
	public void render(float deltaTime) {
		// update models
		gameLoopEngine.update(deltaTime);
		scene.act(deltaTime);

		// draw the scene
		// init the background color
		Gdx.gl.glClearColor(0, 0, 0, 1);
		// actualise le background
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		scene.draw();
	}

}
