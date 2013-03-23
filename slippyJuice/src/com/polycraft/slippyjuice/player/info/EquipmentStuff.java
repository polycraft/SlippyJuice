package com.polycraft.slippyjuice.player.info;

public class EquipmentStuff extends Stuff {
	private EquipmentType equipmentType;
	private Caracteristics caractAffected;
	private Integer value;

	public EquipmentStuff(String name, String definition, Integer price,
			Integer rarity, EquipmentType equipmentType,
			Caracteristics caractAffected, Integer value) {
		super(name, definition, StuffType.EQUIPMENT, price, rarity);
		this.equipmentType = equipmentType;
		this.caractAffected = caractAffected;
		this.value = value;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public Caracteristics getCaractAffected() {
		return caractAffected;
	}

	public Integer getValue() {
		return value;
	}

	public String toString() {
		return "Equipment stuff:" + equipmentType + "/" + caractAffected + ":"
				+ value + "\n";
	}

}
