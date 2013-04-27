package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polycraft.slippyjuice.scene.Scene;

public class GameLoopRenderer extends Renderer {

	public GameLoopRenderer() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		Gdx.input.setInputProcessor(scene);
	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(0, 0, 0, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

}
