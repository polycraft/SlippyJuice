package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.scene.Layer;
import com.polycraft.slippyjuice.scene.LayerObject;
import com.polycraft.slippyjuice.scene.LayerType;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;
import com.polycraft.slippyjuice.ui.GameLoopHUD;

public class GameLoopRenderer extends Renderer {

	public GameLoopRenderer(float height, float width,
			AssetManager assetManager, Player player) {
		super(assetManager);

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		Gdx.input.setInputProcessor(scene);

		hud = new GameLoopHUD(assetManager, width, height, true, batch);

		player.addObserver(hud);

		Gdx.input.setInputProcessor(hud);

		/*
		 * Test construction de scene
		 */
		Layer layer1 = new Layer(new Float(25));
		Sprite layerSprite = new Sprite(assetManager.get(
				"data/textures/backgrounds/mountain.png", Texture.class));
		layer1.setPosition(0, 64 * 4);
		LayerObject object1 = new LayerObject();
		object1.setSize(layerSprite.getWidth(), layerSprite.getHeight());
		object1.addSprite(layerSprite);
		layer1.addActor(object1);

		Layer layer2 = new Layer(new Float(10));
		Sprite layerSprite2 = new Sprite(assetManager.get(
				"data/textures/backgrounds/hill.png", Texture.class));
		layer2.setPosition(0, 64 * 4);
		LayerObject object2 = new LayerObject();
		object2.setSize(layerSprite2.getWidth(), layerSprite2.getHeight());
		object2.addSprite(layerSprite2);
		layer2.addActor(object2);

		scene.setLayer(LayerType.BACKGROUND1, layer1);
		scene.setLayer(LayerType.BACKGROUND2, layer2);

		/*
		 * Ajout du joueur
		 */

		//
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
