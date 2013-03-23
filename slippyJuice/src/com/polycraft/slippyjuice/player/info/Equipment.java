package com.polycraft.slippyjuice.player.info;

import java.util.HashMap;
import java.util.Map;

public class Equipment {
	private Map<EquipmentType, Stuff> stuffs;

	public Equipment() {
		this.stuffs = new HashMap<EquipmentType, Stuff>();
	}

	public void equip(Stuff stuff) {
		// verifie si c'est un equipement et non un item
		if (StuffType.EQUIPMENT.equals(stuff.getStuffType())) {
			EquipmentStuff equip = (EquipmentStuff) stuff;
			this.stuffs.put(equip.getEquipmentType(), equip);
		}
	}

	public String toString() {
		StringBuffer string = new StringBuffer();
		for (EquipmentType key : stuffs.keySet()) {
			EquipmentStuff equip = (EquipmentStuff) stuffs.get(key);
			string.append(equip.toString());
		}

		return string.toString();
	}
}
