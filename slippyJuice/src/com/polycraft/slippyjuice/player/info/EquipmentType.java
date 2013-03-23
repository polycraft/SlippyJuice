package com.polycraft.slippyjuice.player.info;

public enum EquipmentType {
	HELMET("helmet"), ARMOR("armor"), PANT("pant"), GLASSES("glasses");

	private final String code;

	EquipmentType(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
