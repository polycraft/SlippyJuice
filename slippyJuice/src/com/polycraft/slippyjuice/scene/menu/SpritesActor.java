package com.polycraft.slippyjuice.scene.menu;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SpritesActor extends Actor {

	private List<Sprite> sprites;

	public SpritesActor(List<Sprite> sprites) {
		this();
		sprites.addAll(sprites);
	}

	public SpritesActor(Sprite sprite) {
		this();
		sprites.add(sprite);
	}

	public SpritesActor() {
		sprites = new ArrayList<Sprite>();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		for (Sprite sprite : sprites) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.setScale(getScaleX(), getScaleY());
			sprite.draw(batch, parentAlpha);
		}
		super.draw(batch, parentAlpha);
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}

	public void addAllSprites(List<Sprite> sprites) {
		sprites.addAll(sprites);
	}

	public void destroy() {
		sprites.clear();
		remove();
	}
}
