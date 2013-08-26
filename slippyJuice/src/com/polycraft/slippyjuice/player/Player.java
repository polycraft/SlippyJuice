package com.polycraft.slippyjuice.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.polycraft.slippyjuice.scene.character.Character;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.ItemStuff;
import com.polycraft.slippyjuice.stuff.Stuff;

public class Player extends Observable {
	private PlayerInformation playerInformation;
	private List<Stuff> stuffs;
	private Map<EquipmentType, Stuff> inventory;
	private Map<Properties, Float> properties;
	private Character character;

	public Player(PlayerInformation information) {
		this(information, new Float(0), new Float(2), new Float(1));
	}

	public Player(PlayerInformation information, Float speed, Float weight,
			Float defence) {
		this(information, new Float(100), new Float(100), new Float(0), speed,
				new Float(0), weight, new Float(1), defence, new Float(0));
	}

	public Player(PlayerInformation playerInformation, Float health,
			Float vomit, Float overJuice, Float speed, Float acceleration,
			Float weight, Float friction, Float defence, Float forceX) {
		super();
		this.playerInformation = playerInformation;
		this.properties = new HashMap<Properties, Float>();
		this.properties.put(Properties.SPEED, speed);
		this.properties.put(Properties.ACCELERATION, acceleration);
		this.properties.put(Properties.HEALTH, health);
		this.properties.put(Properties.DEFENCE, defence);
		this.properties.put(Properties.WEIGHT, weight);
		this.properties.put(Properties.VOMIT, vomit);
		this.properties.put(Properties.OVERJUICE, overJuice);
		this.properties.put(Properties.FRICTION, friction);
		this.properties.put(Properties.FORCEX, forceX);
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
			// update character skin inventory
			updateCharacter();
		} else {
			System.out.println("NOT (EQUIPMENT OR IN BAG): " + stuffToEquip);
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
			// update character skin inventory
			updateCharacter();
		} else {
			System.out.println("NOT AN EQUIPMENT OR NOT IN THE EQUIPMENT: "
					+ stuffToUnEquip);
		}

	}

	public void use(Stuff stuff) {
		if (ItemStuff.class.isInstance(stuff)) {
			this.stuffs.remove(stuff);
			useEffects((ItemStuff) stuff);
		}
	}

	public void addStuff(Stuff stuff) {
		this.stuffs.add(stuff);
	}

	private void useEffects(ItemStuff item) {
		for (Properties caracteristics : Properties.values()) {
			Float temp = new Float(this.properties.get(caracteristics)
					.floatValue());
			if (item.getEffects().get(caracteristics) != null) {
				temp += item.getEffects().get(caracteristics);
			}
			this.properties.put(caracteristics, temp);
		}
	}

	private void updateCharacter() {
		this.character.setInventory(inventory);
	}

	public String toString() {
		String outProperties = "";
		for (Properties caracteristics : Properties.values()) {
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

	public Map<EquipmentType, Stuff> getInventory() {
		return inventory;
	}

	public Float getPropertie(Properties caracteristic) {
		if (this.properties.get(caracteristic) == null)
			return new Float(0);
		else
			return this.properties.get(caracteristic);
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void updatePropertie(Properties caracteristic, Float value) {
		this.properties.put(caracteristic, value);
		this.character.update(properties.get(Properties.SPEED));
		setChanged();
		notifyObservers();
	}
}
