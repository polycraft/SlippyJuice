package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.SlippyJuice;
import com.polycraft.slippyjuice.renderers.Renderer;

public abstract class SlippyJuiceScreen implements Screen {
	protected SlippyJuice game;
	protected Renderer renderer;
	protected AssetManager assetManager;

	public SlippyJuiceScreen(SlippyJuice game, AssetManager assetManager) {
		this.game = game;
		this.assetManager = assetManager;
	}
}
