package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Screen;
import com.polycraft.slippyjuice.SlippyJuice;
import com.polycraft.slippyjuice.renderers.Renderer;

public abstract class SlippyJuiceScreen implements Screen {
	protected SlippyJuice game;
	protected Renderer renderer;

	public SlippyJuiceScreen(SlippyJuice game) {
		this.game = game;
	}
}
