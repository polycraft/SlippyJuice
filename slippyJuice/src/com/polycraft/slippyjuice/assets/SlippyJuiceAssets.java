package com.polycraft.slippyjuice.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SlippyJuiceAssets {

	public SlippyJuiceAssets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void loadMenuAssets(AssetManager manager) {
		manager.clear();
		manager.load("data/ui/uiskin.json", Skin.class);
	}

	public static void loadGameAssets(AssetManager manager) {
		manager.clear();
		manager.load("data/ui/uiskin.json", Skin.class);
		manager.load("data/textures/skin/right_arm.png", Texture.class);
		manager.load("data/textures/skin/right_leg.png", Texture.class);
		manager.load("data/textures/skin/body.png", Texture.class);
		manager.load("data/textures/skin/head.png", Texture.class);
		manager.load("data/cubeTest.png", Texture.class);
		manager.load("data/groundPiece.png", Texture.class);

	}
}
