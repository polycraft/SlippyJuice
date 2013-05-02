package com.polycraft.slippyjuice.stuff;

import com.polycraft.slippyjuice.scene.character.BodyPartType;

public enum EquipmentType {
	HELMET("helmet", BodyPartType.HEAD), ARMOR("armor", BodyPartType.BODY), PANT(
			"pant", BodyPartType.LEG), GLASSES("glasses", BodyPartType.HEAD);

	private final String code;
	private final BodyPartType bodyPart;

	EquipmentType(String code, BodyPartType bodyPart) {
		this.code = code;
		this.bodyPart = bodyPart;
	}

	public String code() {
		return code;
	}

	public BodyPartType bodyPart() {
		return bodyPart;
	}
}
