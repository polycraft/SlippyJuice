package com.polycraft.slippyjuice.scene.character;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.polycraft.slippyjuice.scene.particles.ParticleEffectActor;

public class BodyPart extends Group {
	private Sprite skin;
	private List<Sprite> skinDecals;
	private List<Sprite> stuffDecals;
	private List<ParticleEffectActor> particlesEffects;

	public BodyPart(Texture texture, float x, float y) {
		super();
		skin = new Sprite(texture);
		skinDecals = new ArrayList<Sprite>();
		stuffDecals = new ArrayList<Sprite>();
		particlesEffects = new ArrayList<ParticleEffectActor>();

		setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
		setSize(texture.getWidth(), texture.getHeight());
		setPosition(-texture.getWidth() / 2 + x, -texture.getHeight() / 2 + y);

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		drawSkin(batch, parentAlpha);
		drawDecals(batch, skinDecals, parentAlpha);
		drawDecals(batch, stuffDecals, parentAlpha);
		// drawParticles(batch, parentAlpha);
		super.draw(batch, parentAlpha);
	}

	// private void drawParticles(SpriteBatch batch, float parentAlpha) {
	// for (ParticleEffect particleEffect : particlesEffects) {
	// particleEffect.setPosition(getX(), getY());
	// particleEffect.draw(batch, parentAlpha);
	// }
	// }

	private void drawSkin(SpriteBatch batch, float parentAlpha) {
		skin.setOrigin(getOriginX(), getOriginY());
		skin.setPosition(getX(), getY());
		skin.setRotation(getRotation());
		skin.setSize(getWidth(), getHeight());
		skin.setColor(this.getColor());
		skin.draw(batch, parentAlpha);
	}

	private void drawDecals(SpriteBatch batch, List<Sprite> decals,
			float parentAlpha) {
		for (Sprite sprite : decals) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch, parentAlpha);
		}
	}

	public void addSkinDecal(Sprite sprite) {
		skinDecals.add(sprite);
	}

	public void clearSkinDecals() {
		this.skinDecals.clear();
	}

	public void addStuffDecal(Sprite sprite) {
		stuffDecals.add(sprite);
	}

	public void clearStuffDecals() {
		this.stuffDecals.clear();
	}

	public void addParticleEffect(ParticleEffect particleEffect, float x,
			float y) {
		ParticleEffectActor effectActor = new ParticleEffectActor(
				particleEffect);
		effectActor.setPosition(x, y);
		particlesEffects.add(effectActor);
		addActor(effectActor);
	}

	public List<ParticleEffectActor> getParticlesEffects() {
		return particlesEffects;
	}

}
