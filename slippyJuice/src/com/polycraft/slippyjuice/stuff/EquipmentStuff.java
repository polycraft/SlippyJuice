package com.polycraft.slippyjuice.stuff;

public class EquipmentStuff extends Stuff {
	private EquipmentType equipmentType;
	private Boolean equiped;

	public EquipmentStuff(String name, String definition, Integer price,
			Integer rarity, EquipmentType equipmentType,
			Caracteristics caractAffected, Integer value) {
		this(name, definition, price, rarity, equipmentType);
		this.equipmentType = equipmentType;
		this.addEffect(caractAffected, value);
	}

	public EquipmentStuff(String name, String definition, Integer price,
			Integer rarity, EquipmentType equipmentType) {
		super(name, definition, price, rarity);
		this.equipmentType = equipmentType;
		this.equiped = false;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquiped(Boolean equiped) {
		this.equiped = equiped;
	}

	public Boolean isEquiped() {
		return equiped;
	}

	public String toString() {
		return "Equipment stuff:" + equipmentType + " : " + super.toString()
				+ " ::" + equiped + "\n";
	}
}
