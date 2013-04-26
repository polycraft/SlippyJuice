package com.polycraft.slippyjuice.scene.character;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Character extends Rectangle {

	List<Sprite> bodyParts;

	public Character(float x, float y, float width, float height) {
		super(x, y, width, height);
		bodyParts = new ArrayList<Sprite>();
		buildCharacter();
	}

	public Character(Rectangle rect) {
		super(rect);
		bodyParts = new ArrayList<Sprite>();
		buildCharacter();
	}

	protected abstract void buildCharacter();

	public void draw(SpriteBatch spriteBatch) {
		for (Sprite bodyPart : bodyParts) {
			bodyPart.draw(spriteBatch);
		}
	};

}
