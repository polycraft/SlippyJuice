package com.polycraft.slippyjuice.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.ItemStuff;
import com.polycraft.slippyjuice.stuff.Stuff;

public class Player {
	private PlayerInformation playerInformation;
	private List<Stuff> stuffs;
	private Map<EquipmentType, Stuff> inventory;
	private Map<Caracteristics, Float> properties;

	public Player(PlayerInformation information) {
		this(information, new Float(100), new Float(100), new Float(0),
				new Float(1), new Float(1), new Float(1));
	}

	public Player(PlayerInformation information, Float speed, Float weight,
			Float resistance) {
		this(information, new Float(100), new Float(100), new Float(0), speed,
				weight, resistance);
	}

	public Player(PlayerInformation playerInformation, Float health,
			Float vomit, Float overJuice, Float speed, Float weight,
			Float resistance) {
		super();
		this.playerInformation = playerInformation;
		this.properties = new HashMap<Caracteristics, Float>();
		this.properties.put(Caracteristics.SPEED, speed);
		this.properties.put(Caracteristics.HEALTH, health);
		this.properties.put(Caracteristics.RESISTANCE, resistance);
		this.properties.put(Caracteristics.WEIGHT, weight);
		this.properties.put(Caracteristics.VOMIT, vomit);
		this.properties.put(Caracteristics.OVERJUICE, overJuice);
		this.inventory = new HashMap<EquipmentType, Stuff>();
		this.stuffs = new ArrayList<Stuff>();
	}

	public PlayerInformation getPlayerInformation() {
		return playerInformation;
	}

	public Stuff equip(Stuff stuffToEquip) {
		Stuff holdStuff = null;
		// verifie si c'est un equipement et non un autre type de stuff
		if (stuffs.contains(stuffToEquip)
				&& EquipmentStuff.class.isInstance(stuffToEquip)) {
			EquipmentStuff equipment = (EquipmentStuff) stuffToEquip;
			holdStuff = this.inventory.put(equipment.getEquipmentType(),
					equipment);
		} else {
			System.out.println("NOT AN EQUIPMENT : " + stuffToEquip);
		}
		if (null != holdStuff) {
			this.stuffs.add(holdStuff);
		}

		return holdStuff;
	}

	public void unequip(Stuff stuffToUnEquip) {
		// si equipement et dans inventaire OK
		if (inventory.containsValue(stuffToUnEquip)
				&& EquipmentStuff.class.isInstance(stuffToUnEquip)) {
			EquipmentStuff equipment = (EquipmentStuff) stuffToUnEquip;
			this.inventory.remove(equipment.getEquipmentType());
			this.stuffs.add(equipment);
		} else {
			System.out.println("NOT AN EQUIPMENT OR NOT IN THE EQUIPMENT: "
					+ stuffToUnEquip);
		}

	}

	public void use(Stuff stuff) {
		if (ItemStuff.class.isInstance(stuff)) {
			this.stuffs.remove(stuff);
			useEffect((ItemStuff) stuff);
		}
	}

	public void addStuff(Stuff stuff) {
		this.stuffs.add(stuff);
	}

	private void useEffect(ItemStuff item) {
		for (Caracteristics caracteristics : Caracteristics.values()) {
			Float temp = new Float(this.properties.get(caracteristics)
					.floatValue());
			if (item.getEffects().get(caracteristics) != null) {
				temp += item.getEffects().get(caracteristics);
			}
			this.properties.put(caracteristics, temp);
		}
	}

	public String toString() {
		String outProperties = "";
		for (Caracteristics caracteristics : Caracteristics.values()) {
			outProperties += "" + caracteristics + ":"
					+ properties.get(caracteristics) + ",";
		}

		String outStuffs = "";
		for (Stuff stuff : stuffs) {
			outStuffs += "		" + stuff.toString();
		}

		String outInventory = "";
		for (EquipmentType key : inventory.keySet()) {
			EquipmentStuff equip = (EquipmentStuff) inventory.get(key);
			outInventory += "		" + equip.toString();
		}

		return playerInformation.toString() + "(" + outProperties + ")"
				+ "\n	EQUIPED : \n" + outInventory + "\n	STUFFS : \n"
				+ outStuffs;
	}
}
