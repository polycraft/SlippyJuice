package com.polycraft.slippyjuice.ui;

import java.text.DecimalFormat;
import java.util.Observable;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.Properties;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;

public class GameLoopHUD extends HUD {

	private Label debugInfos;
	private Label totalDistance;
	private DecimalFormat df = new DecimalFormat("###.##");

	public GameLoopHUD(AssetManager assetManager) {
		super(assetManager);
		buildHUD();
	}

	public GameLoopHUD(AssetManager assetManager2, float width, float height,
			boolean keepAspectRatio, SpriteBatch batch) {
		super(assetManager2, width, height, keepAspectRatio, batch);
		buildHUD();
	}

	private void buildHUD() {
		Skin skinUI = assetManager.get("data/ui/uiskin.json", Skin.class);
		TextButton button = new TextButton("Test", skinUI);
		button.setPosition(this.getWidth() - button.getWidth(),
				this.getHeight() - button.getHeight());
		addActor(button);

		debugInfos = new Label("", skinUI);
		debugInfos.setPosition(0, this.getHeight() - debugInfos.getHeight()
				- 10);
		addActor(debugInfos);

		totalDistance = new Label("", skinUI);
		totalDistance.setPosition(0,
				this.getHeight() - totalDistance.getHeight() - 40);
		addActor(totalDistance);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (Player.class.isInstance(obs)) {
			Player player = (Player) obs;
			debugInfos.setText("life :"
					+ player.getPropertie(Properties.HEALTH) + ", weight :"
					+ df.format(player.getPropertie(Properties.WEIGHT)) + "g"
					+ ", acc :"
					+ df.format(player.getPropertie(Properties.ACCELERATION))
					+ "m/s²" + ", speed :"
					+ df.format(player.getPropertie(Properties.SPEED)) + "m/s");
			System.out.println("player updated");
		}
		if (GameLoopEngine.class.isInstance(obs)) {
			GameLoopEngine engine = (GameLoopEngine) obs;

			totalDistance
					.setText("TotalDistance: " + engine.getTotalDistance());
		}
	}
}
