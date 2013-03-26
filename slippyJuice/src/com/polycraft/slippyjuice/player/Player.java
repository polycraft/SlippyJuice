package com.polycraft.slippyjuice.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.ItemStuff;
import com.polycraft.slippyjuice.stuff.Stuff;

public class Player {
	private PlayerInformation playerInformation;
	private Equipment equipment;
	private List<Stuff> stuffs;
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
		this.equipment = new Equipment();
		this.stuffs = new ArrayList<Stuff>();
	}

	public PlayerInformation getPlayerInformation() {
		return playerInformation;
	}

	public void equip(Stuff stuffToEquip) {
		if (this.stuffs.contains(stuffToEquip)) {
			Stuff holdStuff = this.equipment.equip(stuffToEquip);
			if (holdStuff != null) {
				this.stuffs.add(holdStuff);
			}
			this.stuffs.remove(stuffToEquip);
		}
	}

	public void unequip(Stuff stuffToUnEquip) {
		this.equipment.unequip(stuffToUnEquip);
		this.stuffs.add(stuffToUnEquip);
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

		return playerInformation.toString() + "(" + outProperties + ")"
				+ "\n	EQUIPED : \n" + equipment.toString() + "\n	STUFFS : \n"
				+ outStuffs;
	}
}
