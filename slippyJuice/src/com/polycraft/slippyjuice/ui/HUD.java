package com.polycraft.slippyjuice.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HUD extends Stage {

	protected AssetManager assetManager;

	public HUD(AssetManager assetManager) {
		super();
		this.assetManager = assetManager;
	}

	public HUD(AssetManager assetManager, float width, float height,
			boolean keepAspectRatio, SpriteBatch batch) {
		super(width, height, keepAspectRatio, batch);
		this.assetManager = assetManager;
	}

	public HUD(AssetManager assetManager, float width, float height,
			boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		this.assetManager = assetManager;
	}

}
