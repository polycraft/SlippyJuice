package com.polycraft.slippyjuice.player;

import java.util.HashMap;
import java.util.Map;

import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.Stuff;

public class Equipment {
	private Map<EquipmentType, Stuff> stuffs;

	public Equipment() {
		this.stuffs = new HashMap<EquipmentType, Stuff>();
	}

	public Stuff equip(Stuff newStuff) {
		Stuff holdStuff = null;
		// verifie si c'est un equipement et non un item
		if (EquipmentStuff.class.isInstance(newStuff)) {
			EquipmentStuff equipment = (EquipmentStuff) newStuff;
			holdStuff = this.stuffs
					.put(equipment.getEquipmentType(), equipment);
		} else {
			System.out.println("NOT AN EQUIPMENT : " + newStuff);
		}

		return holdStuff;
	}

	public void unequip(Stuff stuff) {
		if (EquipmentStuff.class.isInstance(stuff)) {
			EquipmentStuff equipment = (EquipmentStuff) stuff;
			// verifie equipement dans la liste
			if (this.stuffs.get(equipment.getEquipmentType()).equals(equipment)) {
				this.stuffs.remove(equipment.getEquipmentType());
			} else {
				System.out.println("NOT IN THE EQUIPMENT : " + stuff);
			}
		} else {
			System.out.println("NOT AN EQUIPMENT : " + stuff);
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
