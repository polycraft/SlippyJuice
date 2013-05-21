package com.polycraft.slippyjuice.stuff;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.polycraft.slippyjuice.player.Caracteristics;
import com.polycraft.slippyjuice.scene.character.BodyPartType;

public class EquipmentStuff extends Stuff {
	private EquipmentType equipmentType;
	private Boolean equiped;
	private Map<BodyPartType, Sprite> spritesParts;

	public EquipmentStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, EquipmentType equipmentType,
			Caracteristics caractAffected, Integer value,
			Map<BodyPartType, Sprite> spritesParts) {
		this(texture, name, definition, price, rarity, equipmentType);
		this.addEffect(caractAffected, value);
		setSpritesParts(spritesParts);
	}

	public EquipmentStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, EquipmentType equipmentType,
			Caracteristics caractAffected, Integer value) {
		this(texture, name, definition, price, rarity, equipmentType);
		this.addEffect(caractAffected, value);
	}

	public EquipmentStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, EquipmentType equipmentType) {
		super(texture, name, definition, price, rarity);
		this.equipmentType = equipmentType;
		this.equiped = false;
		this.spritesParts = new HashMap<BodyPartType, Sprite>();
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

	public Map<BodyPartType, Sprite> getSpritesParts() {
		return spritesParts;
	}

	public void setSpritesParts(Map<BodyPartType, Sprite> spritesParts) {
		this.spritesParts = spritesParts;
	}

	public String toString() {
		return "Equipment stuff:" + equipmentType + " : " + super.toString()
				+ " ::" + equiped + "\n";
	}

}
