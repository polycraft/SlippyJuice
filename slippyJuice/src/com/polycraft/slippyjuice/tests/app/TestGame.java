package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.assets.SlippyJuiceAssets;

public class TestGame extends Game {

	private TestScreen testScreen;
	private AssetManager assetManager;

	@Override
	public void create() {
		assetManager = new AssetManager();
		SlippyJuiceAssets.loadGameAssets(assetManager);
		assetManager.finishLoading();
		System.out.println("Asset loading finished");
		testScreen = new TestScreen(this, assetManager);
		setTestScreen();
	}

	public void setTestScreen() {
		setScreen(testScreen);
	}

}
