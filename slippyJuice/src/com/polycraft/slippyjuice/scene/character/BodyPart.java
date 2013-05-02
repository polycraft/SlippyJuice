package com.polycraft.slippyjuice.scene.character;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BodyPart extends Group {
	Sprite skin;
	List<Sprite> decals;

	public BodyPart(Texture texture, float x, float y) {
		super();
		skin = new Sprite(texture);
		decals = new ArrayList<Sprite>();

		setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
		setSize(texture.getWidth(), texture.getHeight());
		setPosition(-texture.getWidth() / 2 + x, -texture.getHeight() / 2 + y);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		drawSkin(batch, parentAlpha);
		drawDecals(batch, parentAlpha);
		super.draw(batch, parentAlpha);
	}

	private void drawSkin(SpriteBatch batch, float parentAlpha) {
		skin.setOrigin(getOriginX(), getOriginY());
		skin.setPosition(getX(), getY());
		skin.setRotation(getRotation());
		skin.setSize(getWidth(), getHeight());
		skin.draw(batch, parentAlpha);
	}

	private void drawDecals(SpriteBatch batch, float parentAlpha) {
		for (Sprite sprite : decals) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch, parentAlpha);
		}
	}

	public void addDecal(Sprite sprite) {
		decals.add(sprite);
	}

	public void clearDecals() {
		this.decals.clear();
	}
}
