package com.polycraft.slippyjuice.scene.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Parent extends Group {
	Child child;
	Sprite sprite;
	TextureRegion region;

	public Parent() {
		super();
		sprite = new Sprite(new Texture(Gdx.files.internal("data/body.png")));
		region = new TextureRegion(new Texture(
				Gdx.files.internal("data/body.png")));
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {

		// drawChildren(batch, parentAlpha);
		//
		// Color color = getColor();
		// batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		// batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(),
		// getWidth(), getHeight(), getScaleX(), getScaleY(),
		// getRotation());
		// sprite.setPosition(getX(), getY());
		// sprite.setRotation(getRotation());
		// sprite.draw(batch);

		batch.setColor(getColor());
		batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
				getWidth(), getHeight(), getScaleX(), getScaleY(),
				getRotation());
		drawChildren(batch, parentAlpha);
		// super.draw(batch, parentAlpha);
	}

}
