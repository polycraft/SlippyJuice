package com.polycraft.slippyjuice;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.assets.SlippyJuiceAssets;
import com.polycraft.slippyjuice.screens.GameLoopScreen;
import com.polycraft.slippyjuice.screens.LoadingScreen;
import com.polycraft.slippyjuice.screens.MainMenuScreen;

public class SlippyJuice extends Game {

	private float screenWidth;
	private float screenHeight;

	private AssetManager assetManager;
	private SlippyJuiceAssets slippyJuiceAssets;
	private MainMenuScreen mainMenuScreen;
	private GameLoopScreen gameLoopScreen;
	private LoadingScreen loadingScreen;

	@Override
	public void create() {
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();

		assetManager = new AssetManager();
		slippyJuiceAssets = new SlippyJuiceAssets();
		loadingScreen = new LoadingScreen(this, assetManager);
		// mainMenuScreen = new MainMenuScreen(this, assetManager);
		// gameLoopScreen = new GameLoopScreen(this, assetManager);
		setLoading("menu");
	}

	// public void setMainMenuScreen() {
	// setScreen(mainMenuScreen);
	// System.out.println("menu rendering");
	// }
	//
	// public void setGameLoopScreen() {
	// setScreen(gameLoopScreen);
	// System.out.println("game rendering");
	// }

	public void setScreen(String screenType) {
		if ("menu".equals(screenType)) {
			mainMenuScreen = new MainMenuScreen(screenHeight, screenWidth,
					this, assetManager);
			setScreen(mainMenuScreen);
			System.out.println("menu rendering");
		}
		if ("game".equals(screenType)) {
			gameLoopScreen = new GameLoopScreen(screenHeight, screenWidth,
					this, assetManager);
			setScreen(gameLoopScreen);
			System.out.println("game rendering");
		}
	}

	public void setLoading(String screenToLoad) {
		if ("menu".equals(screenToLoad)) {
			SlippyJuiceAssets.loadMenuAssets(assetManager);
			loadingScreen.setScreenToLoad(screenToLoad);
			setScreen(loadingScreen);
		}
		if ("game".equals(screenToLoad)) {
			SlippyJuiceAssets.loadGameAssets(assetManager);
			loadingScreen.setScreenToLoad(screenToLoad);
			setScreen(loadingScreen);
		}
	}
}
