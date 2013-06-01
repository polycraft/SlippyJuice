package com.polycraft.slippyjuice.scene;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Layer extends Group {

	private Float farDistance;
	private List<Sprite> sprites;

	public Layer(Float farDistance) {
		super();
		this.farDistance = farDistance;
		this.sprites = new ArrayList<Sprite>();
	}

	public void update(Float distance) {
		for (Actor actor : getChildren()) {
			actor.translate(distance * 64 / farDistance, 0);
		}
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		for (Sprite sprite : sprites) {
			// sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			// sprite.setRotation(getRotation());
			// sprite.setSize(getWidth(), getHeight());
			sprite.setColor(this.getColor());
			sprite.draw(batch, parentAlpha);
		}
		super.draw(batch, parentAlpha);
	}

	public void addSprite(Sprite sprite) {
		this.sprites.add(sprite);
	}
}
