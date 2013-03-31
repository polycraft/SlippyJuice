package com.polycraft.test.models;

import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.ItemStuff;

public class TestItems {
	public static void main(String[] args) {

		// creer des stuffs
		ItemStuff item1 = new ItemStuff("item1", "blazdbla", 31, 5,
				Caracteristics.SPEED, 21);
		ItemStuff item2 = new ItemStuff("item2", "zqdqzd", 31, 5,
				Caracteristics.VOMIT, 300);
		ItemStuff item3 = new ItemStuff("item3", "blazzzzzbla", 31, 5,
				Caracteristics.HEALTH, 100);

		System.out.println("" + item1 + item2 + item3);

	}
}
