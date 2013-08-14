package com.polycraft.slippyjuice.assets;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SlippyJuiceAssets {
	private static Map<String, String> ressourcesPaths;

	public SlippyJuiceAssets() {
		super();
		buildPaths();
	}

	public static void loadMenuAssets(AssetManager manager) {
		manager.clear();
		manager.load(getPath("uiSkin"), Skin.class);
		manager.load(getPath("title"), Texture.class);
	}

	public static void loadGameAssets(AssetManager manager) {
		manager.clear();
		manager.load(getPath("uiSkin"), Skin.class);
		manager.load(getPath("rightArm"), Texture.class);
		manager.load(getPath("rightLeg"), Texture.class);
		manager.load(getPath("body"), Texture.class);
		manager.load(getPath("head"), Texture.class);
		manager.load(getPath("cubeTest"), Texture.class);
		manager.load(getPath("groundPiece"), Texture.class);
		manager.load(getPath("mountain"), Texture.class);
		manager.load(getPath("hill"), Texture.class);

	}

	private void buildPaths() {
		// à automatiser avec un fichier externe
		ressourcesPaths = new HashMap<String, String>();
		ressourcesPaths.put("default", "data/default.png");
		ressourcesPaths.put("uiSkin", "data/ui/uiskin.json");
		ressourcesPaths.put("title", "data/slippyjuice.png");
		ressourcesPaths.put("rightArm", "data/textures/skin/right_arm.png");
		ressourcesPaths.put("rightLeg", "data/textures/skin/right_leg.png");
		ressourcesPaths.put("body", "data/textures/skin/body.png");
		ressourcesPaths.put("head", "data/textures/skin/head.png");
		ressourcesPaths.put("cubeTest", "data/cubeTest.png");
		ressourcesPaths.put("groundPiece", "data/groundPiece.png");
		ressourcesPaths.put("mountain",
				"data/textures/backgrounds/mountain.png");
		ressourcesPaths.put("hill", "data/textures/backgrounds/hill.png");
	}

	public static String getPath(String key) {
		return ressourcesPaths.get(key);
	}
}
