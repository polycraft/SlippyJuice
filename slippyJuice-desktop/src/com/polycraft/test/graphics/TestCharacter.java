package com.polycraft.test.graphics;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.polycraft.slippyjuice.tests.app.TestGame;

public class TestCharacter {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "slippyJuice";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 600;

		new LwjglApplication(new TestGame(), cfg);

	}
}
