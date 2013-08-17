package com.polycraft.slippyjuice.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.polycraft.slippyjuice.scene.menu.SpritesActor;
import com.polycraft.slippyjuice.scene.particles.ParticleEffectActor;

public class MainMenuHUD extends HUD {

	private SpritesActor titleActor;

	public MainMenuHUD(AssetManager assetManager) {
		super(assetManager);
		buildHUD();
	}

	public MainMenuHUD(AssetManager assetManager2, float width, float height,
			boolean keepAspectRatio, SpriteBatch batch) {
		super(assetManager2, width, height, keepAspectRatio, batch);
		buildHUD();
	}

	private void buildHUD() {

		Sprite titleSprite = new Sprite(assetManager.get(
				"data/slippyjuice.png", Texture.class));
		// titleSprite.setPosition(0, 250);
		// titleSprite.setSize(this.getWidth(), titleSprite.getHeight());

		titleActor = new SpritesActor(titleSprite);
		titleActor.setPosition(0, 250);
		titleActor.setSize(this.getWidth(), titleSprite.getHeight());
		titleActor.setOrigin(titleActor.getWidth() / 2,
				titleActor.getHeight() / 2);

		titleActor.addAction(Actions.forever(Actions.sequence(
				Actions.scaleBy(0, -0.1f, 1), Actions.scaleBy(0, 0.1f, 1))));
		// titleActor.addAction(Actions.moveBy(100, 100, 1));

		addActor(titleActor);

		Skin skinUI = assetManager.get("data/ui/uiskin.json", Skin.class);
		TextButton button = new TextButton("Jouer", skinUI);
		button.setPosition(this.getWidth() / 2 - button.getWidth(),
				this.getHeight() / 2 - button.getHeight());
		addActor(button);

		ParticleEffect p = new ParticleEffect();
		p.load(Gdx.files.internal("data/particles/vomit.p"),
				Gdx.files.internal("data/particles"));
		p.getEmitters().get(0).getVelocity().setHigh(1, 20);

		ParticleEffectActor particleEffectActor = new ParticleEffectActor(p);
		particleEffectActor.setPosition(100, 100);
		addActor(particleEffectActor);
	}
}
