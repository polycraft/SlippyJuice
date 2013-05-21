package com.polycraft.slippyjuice.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuHUD extends HUD {

	public MainMenuHUD(AssetManager assetManager) {
		super(assetManager);
		buildHUD();
	}

	public MainMenuHUD(AssetManager assetManager2, float width, float height,
			boolean keepAspectRatio, SpriteBatch batch) {
		super(assetManager2, width, height, keepAspectRatio, batch);
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
