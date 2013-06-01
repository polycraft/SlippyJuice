package com.polycraft.slippyjuice.ui;

import java.util.Observable;
import java.util.Observer;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HUD extends Stage implements Observer {

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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
