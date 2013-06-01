package com.polycraft.test.models;

import com.polycraft.slippyjuice.player.Properties;
import com.polycraft.slippyjuice.stuff.ItemStuff;

public class TestItems {
	public static void main(String[] args) {

		// creer des stuffs
		ItemStuff item1 = new ItemStuff(null, "item1", "blazdbla", 31, 5,
				Properties.SPEED, 21);
		ItemStuff item2 = new ItemStuff(null, "item2", "zqdqzd", 31, 5,
				Properties.VOMIT, 300);
		ItemStuff item3 = new ItemStuff(null, "item3", "blazzzzzbla", 31, 5,
				Properties.HEALTH, 100);

		System.out.println("" + item1 + item2 + item3);

	}
}
