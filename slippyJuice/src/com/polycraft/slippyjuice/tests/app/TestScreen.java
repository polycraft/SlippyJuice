package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Screen;
import com.polycraft.slippyjuice.renderers.Renderer;

public class TestScreen implements Screen {
	protected TestGame game;
	protected Renderer renderer;

	public TestScreen(TestGame testGame) {
		// renderer = new TestRenderer();
		renderer = new TestRendererCharacter();
		this.game = testGame;
	}

	@Override
	public void render(float delta) {
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
