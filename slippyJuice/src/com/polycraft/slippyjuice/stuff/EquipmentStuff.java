package com.polycraft.slippyjuice.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EquipmentStuff extends Stuff {
	private EquipmentType equipmentType;
	private Boolean equiped;
	private Sprite sprite;

	public EquipmentStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, EquipmentType equipmentType,
			Caracteristics caractAffected, Integer value) {
		this(texture, name, definition, price, rarity, equipmentType);
		this.addEffect(caractAffected, value);
	}

	public EquipmentStuff(Texture texture, String name, String definition,
			Integer price, Integer rarity, EquipmentType equipmentType) {
		super(name, definition, price, rarity);
		this.sprite = new Sprite(texture);
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

	public void draw(SpriteBatch batch, float parentAlpha) {
		sprite.draw(batch, parentAlpha);
	}

	public String toString() {
		return "Equipment stuff:" + equipmentType + " : " + super.toString()
				+ " ::" + equiped + "\n";
	}

	public Sprite getSprite() {
		return sprite;
	}

}
