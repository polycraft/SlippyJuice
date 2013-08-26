package com.polycraft.slippyjuice.scene.character;

// The decorations : hairs, eyes etc...

public enum CharacterState {
	WAITING(0), RUNNING(1), WALKING(2);

	private final int number;

	CharacterState(int number) {
		this.number = number;
	}

}
