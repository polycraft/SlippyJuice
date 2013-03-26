package com.polycraft.slippyjuice.stuff;

public class ItemStuff extends Stuff {

	private static Integer DEFAULT_TIME_EFFECT = 100;
	private Integer timeEffect;

	public ItemStuff(String name, String definition, Integer price,
			Integer rarity, Integer timeEffect, Caracteristics caractAffected,
			Integer value) {
		this(name, definition, price, rarity);
		addEffect(caractAffected, value);
	}

	public ItemStuff(String name, String definition, Integer price,
			Integer rarity, Caracteristics caractAffected, Integer value) {
		this(name, definition, price, rarity);
		addEffect(caractAffected, value);
		timeEffect = DEFAULT_TIME_EFFECT;
	}

	private ItemStuff(String name, String definition, Integer price,
			Integer rarity) {
		super(name, definition, price, rarity);
	}

	public String toString() {
		return "Item stuff: " + super.toString() + "\n";
	}

}
