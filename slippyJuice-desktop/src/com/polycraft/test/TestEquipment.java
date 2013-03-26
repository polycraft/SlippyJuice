package com.polycraft.test;

import com.polycraft.slippyjuice.player.Equipment;
import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.ItemStuff;

public class TestEquipment {
	public static void main(String[] args) {

		// creer des stuffs
		EquipmentStuff stuff1 = new EquipmentStuff("Armure de bois", "blabla",
				31, 5, EquipmentType.ARMOR, Caracteristics.RESISTANCE, 21);
		EquipmentStuff stuff2 = new EquipmentStuff("Pantalon de caca",
				"blablzdzdzda", 551, 5, EquipmentType.PANT,
				Caracteristics.RESISTANCE, 21);
		EquipmentStuff stuff3 = new EquipmentStuff("Lunettes BG", "zzdzdzdbla",
				5, 5, EquipmentType.GLASSES, Caracteristics.SPEED, 10);

		Equipment equipment = new Equipment();

		equipment.equip(stuff1);
		equipment.equip(stuff2);
		equipment.equip(stuff3);

		System.out.println(equipment + "===============\n");

		// nouveau equipement
		EquipmentStuff stuff4 = new EquipmentStuff("Armure de caca", "TTTT",
				2000, 1, EquipmentType.ARMOR, Caracteristics.SPEED, 100);
		stuff4.addEffect(Caracteristics.HEALTH, 8000).addEffect(
				Caracteristics.VOMIT, 10);
		equipment.equip(stuff4);

		// equip d'un item
		ItemStuff item1 = new ItemStuff("item1", "blazdbla", 31, 5,
				Caracteristics.SPEED, 21);
		equipment.equip(item1);

		System.out.println(equipment + "===============\n");
		System.out.println(stuff1);
	}
}
