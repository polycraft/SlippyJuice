package com.polycraft.slippyjuice.scene.character;

// The decorations : hairs, eyes etc...

public enum BodyPartType {
	HEAD(), BODY(), ARM(), LEG(), DEFAULT(BODY), LEFT_ARM(ARM), RIGHT_ARM(ARM), LEFT_LEG(
			LEG), RIGHT_LEG(LEG), EYES(HEAD), HAIR(HEAD), TATOO(BODY);

	private final BodyPartType bodyPart;

	BodyPartType(BodyPartType bodyPart) {
		this.bodyPart = bodyPart;
	}

	BodyPartType() {
		bodyPart = this;
	}

	public BodyPartType bodyPart() {
		return bodyPart;
	}
}
