package com.polycraft.slippyjuice.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern {
	private List<String> sprites;

	public Pattern() {
		this.sprites = new ArrayList<String>();
	}

	public Pattern(String... filename) {
		this.sprites = Arrays.asList(filename);
	}

	public List<String> getSprites() {
		return sprites;
	}

	public void setSprites(List<String> sprites) {
		this.sprites = sprites;
	}

}
