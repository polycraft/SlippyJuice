package com.polycraft.slippyjuice.scene.character;

// The decorations : hairs, eyes etc...

public enum FeatureType {
	HAIR("hair"), EYE("eye");

	private final String code;

	FeatureType(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}
}
