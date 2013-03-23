package com.polycraft.slippyjuice.player.info;

public class Stuff {
	protected StuffType stuffType;
	protected Integer price;
	protected Integer rarity;
	protected String name;
	protected String definition;

	public Stuff(String name, String definition, StuffType stuffType,
			Integer price, Integer rarity) {
		super();
		this.name = name;
		this.definition = definition;
		this.stuffType = stuffType;
		this.price = price;
		this.rarity = rarity;
	}

	public StuffType getStuffType() {
		return stuffType;
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

}
