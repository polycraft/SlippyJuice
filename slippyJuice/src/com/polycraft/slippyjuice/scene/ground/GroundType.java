package com.polycraft.slippyjuice.scene.ground;

public enum GroundType {
	GRASS_01(0);

	private final Integer id;

	GroundType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
