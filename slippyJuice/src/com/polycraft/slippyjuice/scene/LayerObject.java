package com.polycraft.slippyjuice.scene;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LayerObject extends Actor {

	private List<Sprite> sprites;

	public LayerObject() {
		super();
		this.sprites = new ArrayList<Sprite>();
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
