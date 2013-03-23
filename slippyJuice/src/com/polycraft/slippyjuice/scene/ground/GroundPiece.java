package com.polycraft.slippyjuice.scene.ground;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GroundPiece extends Sprite {
    private GroundType groundType;

    public GroundPiece(GroundType groundType) {
	this.groundType = groundType;
    }

    public void draw(SpriteBatch batch) {
	this.draw(batch);
    }
}
