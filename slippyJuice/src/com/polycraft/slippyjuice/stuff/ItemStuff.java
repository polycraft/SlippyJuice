package com.polycraft.slippyjuice.stuff;

import com.badlogic.gdx.graphics.Texture;

public class ItemStuff extends Stuff {

	private static Integer DEFAULT_TIME_EFFECT = 100;
	private Integer timeEffect;

	public ItemStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, Integer timeEffect,
			Caracteristics caractAffected, Integer value) {
		this(texture, name, definition, price, rarity);
		addEffect(caractAffected, value);
	}

	public ItemStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, Caracteristics caractAffected,
			Integer value) {
		this(texture, name, definition, price, rarity);
		addEffect(caractAffected, value);
		timeEffect = DEFAULT_TIME_EFFECT;
	}

	private ItemStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity) {
		super(texture, name, definition, price, rarity);
	}

	public String toString() {
		return "Item stuff: " + super.toString() + "\n";
	}

}
