package com.polycraft.slippyjuice.scene.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Feature {
	private String name;
	private FeatureType type;
	private Sprite sprite;

	public Feature(String name, FeatureType type, Texture texture) {
		super();
		this.name = name;
		this.type = type;
		this.sprite = new Sprite(texture);
	}

	public String getName() {
		return name;
	}

	public FeatureType getType() {
		return type;
	}

	public Sprite getSprite() {
		return sprite;
	}

}
