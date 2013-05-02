package com.polycraft.slippyjuice.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.polycraft.slippyjuice.scene.character.BodyPartType;

public class Feature {
	private int id;
	private String name;
	private BodyPartType type;
	private Sprite sprite;

	public Feature(int id, String name, BodyPartType type, Texture texture) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.sprite = new Sprite(texture);
	}

	public String getName() {
		return name;
	}

	public BodyPartType getType() {
		return type;
	}

	public Sprite getSprite() {
		return sprite;
	}

}
