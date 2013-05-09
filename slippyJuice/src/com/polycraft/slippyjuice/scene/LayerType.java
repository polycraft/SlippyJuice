package com.polycraft.slippyjuice.scene;

// The decorations : hairs, eyes etc...

public enum LayerType {
	SKY(0), BACKGROUND1(1), BACKGROUND2(2), BACKGROUND3(3), GROUND(4), FOREGROUND(
			5);

	private final Integer position;

	LayerType(Integer position) {
		this.position = position;
	}

	public Integer position() {
		return position;
	}
}
