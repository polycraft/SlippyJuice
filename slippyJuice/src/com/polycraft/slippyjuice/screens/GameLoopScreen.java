package com.polycraft.slippyjuice.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.polycraft.slippyjuice.SlippyJuice;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.PlayerInformation;
import com.polycraft.slippyjuice.renderers.GameLoopRenderer;
import com.polycraft.slippyjuice.scene.character.Character;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;

public class GameLoopScreen extends SlippyJuiceScreen {
	private Player player;
	private GameLoopEngine gameLoopEngine;

	public GameLoopScreen(SlippyJuice game, AssetManager assetManager) {
		super(game, assetManager);

		PlayerInformation playerInformation = new PlayerInformation("TEST", 0,
				1);
		player = new Player(playerInformation);
		player.setCharacter(new Character(assetManager, 100, 100, 100, 100));

		renderer = new GameLoopRenderer(assetManager, player);
		gameLoopEngine = new GameLoopEngine(player);
	}

	@Override
	public void render(float deltaTime) {
		// update models
		gameLoopEngine.update(deltaTime);

		// renders
		renderer.render(deltaTime, this.gameLoopEngine);
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			game.setLoading("menu"); // test switching screens
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
