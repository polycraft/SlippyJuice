package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuRenderer extends Renderer {
	private Skin skinUI;
	private Label testText;

	public MainMenuRenderer() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		stage = new Stage(width, height, true, batch);
		Gdx.input.setInputProcessor(stage);

		skinUI = new Skin(Gdx.files.internal("data/ui/uiskin.json"));
		testText = new Label("Main menu", skinUI);
		testText.setPosition(Gdx.graphics.getWidth() / 2 - testText.getWidth()
				/ 2, Gdx.graphics.getHeight() - 20);
		TextButton button = new TextButton("Test", skinUI);
		stage.addActor(button);
		stage.addActor(this.testText);

	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(0, 0, 0, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

	}

}
