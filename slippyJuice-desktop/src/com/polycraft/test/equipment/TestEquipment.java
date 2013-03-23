package com.polycraft.test.equipment;

import com.polycraft.slippyjuice.player.info.Caracteristics;
import com.polycraft.slippyjuice.player.info.Equipment;
import com.polycraft.slippyjuice.player.info.EquipmentStuff;
import com.polycraft.slippyjuice.player.info.EquipmentType;

public class TestEquipment {
	public static void main(String[] args) {

		// creer des stuffs
		EquipmentStuff stuff1 = new EquipmentStuff("stuff1", "blabla", 31, 5,
				EquipmentType.ARMOR, Caracteristics.RESISTANCE, 21);
		EquipmentStuff stuff2 = new EquipmentStuff("stuff2", "blablzdzdzda",
				551, 5, EquipmentType.PANT, Caracteristics.RESISTANCE, 21);
		EquipmentStuff stuff3 = new EquipmentStuff("stuff3", "zzdzdzdbla", 5,
				5, EquipmentType.GLASSES, Caracteristics.SPEED, 10);

		Equipment equipment = new Equipment();

		equipment.equip(stuff1);
		equipment.equip(stuff2);
		equipment.equip(stuff3);

		System.out.println(equipment + "===============\n");

		EquipmentStuff stuff4 = new EquipmentStuff("stuff4", "TTTT", 2000, 1,
				EquipmentType.ARMOR, Caracteristics.SPEED, 100);
		equipment.equip(stuff4);
		System.out.println(equipment + "===============\n");
	}
}
