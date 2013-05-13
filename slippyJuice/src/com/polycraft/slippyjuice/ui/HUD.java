package com.polycraft.slippyjuice.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class HUD extends Stage {

	private AssetManager assetManager;

	public HUD(AssetManager assetManager) {
		super();
		this.assetManager = assetManager;
	}

	public HUD(AssetManager assetManager, float width, float height,
			boolean keepAspectRatio, SpriteBatch batch) {
		super(width, height, keepAspectRatio, batch);
		this.assetManager = assetManager;
		buildHUD();
	}

	public HUD(AssetManager assetManager, float width, float height,
			boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		this.assetManager = assetManager;
		buildHUD();
	}

	private void buildHUD() {
		Skin skinUI = assetManager.get("data/ui/uiskin.json", Skin.class);
		TextButton button = new TextButton("Test", skinUI);
		button.setPosition(this.getWidth() - button.getWidth(),
				this.getHeight() - button.getHeight());
		addActor(button);
	}
}
