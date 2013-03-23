package com.polycraft.slippyjuice.player.info;

public class ItemStuff extends Stuff {
	private Caracteristics caractAffected;
	private Integer value;

	public ItemStuff(String name, String definition, Integer price,
			Integer rarity, Caracteristics caractAffected, Integer value) {
		super(name, definition, StuffType.ITEM, price, rarity);
		this.caractAffected = caractAffected;
		this.value = value;
	}

	public Caracteristics getCaractAffected() {
		return caractAffected;
	}

	public Integer getValue() {
		return value;
	}

	public String toString() {
		return "Item stuff: " + name + " ; " + definition + " ; "
				+ caractAffected + ":" + value + "\n";
	}

}
