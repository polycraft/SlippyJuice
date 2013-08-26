package com.polycraft.slippyjuice.scene.particles;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ParticleEffectActor extends Actor {
	ParticleEffect effect;

	public ParticleEffectActor(ParticleEffect effect) {
		this.effect = effect;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		effect.draw(batch, 1 - parentAlpha);
		super.draw(batch, parentAlpha);
	}

	@Override
	public void act(float delta) {
		effect.setPosition(this.getX(), this.getY()); // set to whatever x/y you
		// prefer
		effect.update(delta); // update it
		super.act(delta);
	}

	public ParticleEffect getEffect() {
		return effect;
	}

}
