package com.polycraft.slippyjuice.scene.ground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GroundPiece extends Actor {
	private GroundType groundType;
	private Float coefficient;
	private Sprite sprite;

	public GroundPiece(GroundType groundType) {
		this.groundType = groundType;
	}

	public GroundPiece(Texture texture) {
		this.sprite = new Sprite(texture);
		this.coefficient = new Float(1);
	}

	public void draw(SpriteBatch batch, float parentAlpha) {
		sprite.setOrigin(getOriginX(), getOriginY());
		sprite.setPosition(getX(), getY());
		sprite.setRotation(getRotation());
		sprite.setSize(getWidth(), getHeight());
		sprite.setColor(getColor());
		sprite.draw(batch, parentAlpha);
		super.draw(batch, parentAlpha);
	}

	public void destroy() {
		// destroy piece
		remove();
	}
}
