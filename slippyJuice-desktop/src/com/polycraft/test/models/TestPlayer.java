package com.polycraft.test.models;

import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.PlayerInformation;
import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.ItemStuff;

public class TestPlayer {
	public static void main(String[] args) {

		// ========= Test equipement Player ====== //
		// creer des eqipment
		EquipmentStuff equip1 = new EquipmentStuff(null, "Armure de bois",
				"blabla", 31, 5, EquipmentType.ARMOR,
				Caracteristics.RESISTANCE, 21);
		EquipmentStuff equip2 = new EquipmentStuff(null, "Pantalon de caca",
				"blablzdzdzda", 551, 5, EquipmentType.PANT,
				Caracteristics.RESISTANCE, 21);
		EquipmentStuff equip3 = new EquipmentStuff(null, "Lunettes BG",
				"zzdzdzdbla", 5, 5, EquipmentType.GLASSES,
				Caracteristics.SPEED, 10);
		EquipmentStuff equip4 = new EquipmentStuff(null, "Armure de caca",
				"TTTT", 2000, 1, EquipmentType.ARMOR, Caracteristics.SPEED, 100);

		// creeer d'un item
		ItemStuff item1 = (ItemStuff) new ItemStuff("item1", "blazdbla", 31, 5,
				Caracteristics.SPEED, 21).addEffect(Caracteristics.HEALTH, 500);

		// un joueur
		PlayerInformation playerInformation = new PlayerInformation("Bob", 10,
				1);
		Player player = new Player(playerInformation);

		// on lui donne des equipements
		player.addStuff(equip1);
		player.addStuff(equip2);
		player.addStuff(equip3);
		player.addStuff(equip4);
		// et des items
		player.addStuff(item1);

		System.out.println(player);
		System.out.println("=================");

		player.equip(equip1);
		System.out.println(player);
		System.out.println("=================");

		player.equip(equip4);
		player.equip(equip3);
		System.out.println(player);
		System.out.println("=================");

		// ========= Test item effects on Player ====== //
		player.use(item1);
		System.out.println(player);
		System.out.println("=================");

	}
}
