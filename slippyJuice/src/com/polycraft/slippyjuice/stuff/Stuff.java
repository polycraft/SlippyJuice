package com.polycraft.slippyjuice.stuff;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.polycraft.slippyjuice.player.Properties;

public class Stuff {
	protected Integer price;
	protected Integer rarity;
	protected String name;
	protected String definition;
	protected Map<Properties, Integer> effects;
	protected Sprite sprite;

	public Stuff(Texture texture, String name, String definition,
			Integer price, Integer rarity) {
		super();
		this.name = name;
		this.definition = definition;
		this.price = price;
		this.rarity = rarity;
		this.effects = new HashMap<Properties, Integer>();
		if (texture == null) {
			// this.sprite = new Sprite(new Texture(
			// Gdx.files.internal("data/textures/default.png")));
		} else {
			this.sprite = new Sprite(texture);
		}

	}

	/**
	 * @param caracteristics
	 * @param value
	 * @return object with a new effect on the caracteristic
	 */
	public Stuff addEffect(Properties caracteristics, Integer value) {
		effects.put(caracteristics, value);
		return this;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getRarity() {
		return rarity;
	}

	public String getName() {
		return name;
	}

	public String getDefinition() {
		return definition;
	}

	public Map<Properties, Integer> getEffects() {
		return effects;
	}

	public String toString() {
		String outEffects = "";
		for (Properties caractAffected : effects.keySet()) {
			outEffects += caractAffected + ":" + effects.get(caractAffected)
					+ "/";
		}
		return name + " ; " + definition + " ; " + outEffects;
	}
}
