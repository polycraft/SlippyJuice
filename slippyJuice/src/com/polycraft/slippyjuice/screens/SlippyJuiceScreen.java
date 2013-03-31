package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Screen;
import com.polycraft.slippyjuice.SlippyJuice;

public abstract class SlippyJuiceScreen implements Screen {
	protected SlippyJuice game;

	public SlippyJuiceScreen(SlippyJuice game) {
		this.game = game;
	}
}
