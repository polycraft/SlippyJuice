package com.polycraft.slippyjuice.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.polycraft.slippyjuice.ui.HUD;

public class MainMenuRenderer extends Renderer {
	private Skin skinUI;
	private Label testText;
	private Sprite titleSprite;

	public MainMenuRenderer(AssetManager assetManager) {
		super(assetManager);
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		batch = new SpriteBatch();
		hud = new HUD(assetManager, width, height, true, batch);
		Gdx.input.setInputProcessor(hud);

		skinUI = assetManager.get("data/ui/uiskin.json", Skin.class);
		testText = new Label("Main menu", skinUI);
		testText.setPosition(Gdx.graphics.getWidth() / 2 - testText.getWidth()
				/ 2, Gdx.graphics.getHeight() - 20);
		TextButton button = new TextButton("Test", skinUI);
		hud.addActor(button);
		hud.addActor(this.testText);

		titleSprite = new Sprite(assetManager.get("data/slippyjuice.png",
				Texture.class));
		titleSprite.setPosition(0, 250);
		titleSprite.setSize(width, titleSprite.getHeight());

	}

	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(0, 0, 0, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();
		titleSprite.draw(batch);
		batch.end();

		hud.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		hud.draw();

	}
}
