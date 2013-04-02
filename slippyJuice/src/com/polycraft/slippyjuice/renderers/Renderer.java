package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Renderer {
	protected OrthographicCamera camera;
	protected SpriteBatch batch;
	protected Stage stage;

	public abstract void render(float delta);
}
