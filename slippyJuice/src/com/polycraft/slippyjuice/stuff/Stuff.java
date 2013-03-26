package com.polycraft.slippyjuice.stuff;

import java.util.HashMap;
import java.util.Map;

public class Stuff {
	protected Integer price;
	protected Integer rarity;
	protected String name;
	protected String definition;
	protected Map<Caracteristics, Integer> effects;

	public Stuff(String name, String definition, Integer price, Integer rarity) {
		super();
		this.name = name;
		this.definition = definition;
		this.price = price;
		this.rarity = rarity;
		this.effects = new HashMap<Caracteristics, Integer>();
	}

	/**
	 * @param caracteristics
	 * @param value
	 * @return object with a new effect on the caracteristic
	 */
	public Stuff addEffect(Caracteristics caracteristics, Integer value) {
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

	public Map<Caracteristics, Integer> getEffects() {
		return effects;
	}

	public String toString() {
		String outEffects = "";
		for (Caracteristics caractAffected : effects.keySet()) {
			outEffects += caractAffected + ":" + effects.get(caractAffected)
					+ "/";
		}
		return name + " ; " + definition + " ; " + outEffects;
	}
}
