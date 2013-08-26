package com.polycraft.slippyjuice.scene.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.polycraft.slippyjuice.player.Feature;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.Stuff;

public class Character extends Group {

	private CharacterState state;
	private BodyPart body;
	private BodyPart leftArm;
	private BodyPart rightArm;
	private BodyPart leftLeg;
	private BodyPart rightLeg;
	private BodyPart head;
	private Map<BodyPartType, BodyPart> bodyParts;

	public Character(AssetManager assetManager, float x, float y, float width,
			float height) {
		super();
		setSize(width, height);
		setOrigin(0, 0);
		setPosition(x, y);
		buildCharacter(assetManager);
		state = CharacterState.WAITING;
	}

	protected void buildCharacter(AssetManager assetManager) {
		bodyParts = new HashMap<BodyPartType, BodyPart>();

		// Du plus éloigné au plus proche

		// - Left Arm
		leftArm = new BodyPart(assetManager.get(
				"data/textures/skin/right_arm.png", Texture.class), 0, 15);
		bodyParts.put(BodyPartType.LEFT_ARM, leftArm);
		this.addActor(leftArm);

		// - Left Leg
		leftLeg = new BodyPart(assetManager.get(
				"data/textures/skin/right_leg.png", Texture.class), 0, -16);
		bodyParts.put(BodyPartType.LEFT_LEG, leftLeg);
		this.addActor(leftLeg);

		// - Body
		body = new BodyPart(assetManager.get("data/textures/skin/body.png",
				Texture.class), 0, 0);
		bodyParts.put(BodyPartType.BODY, body);
		this.addActor(body);

		// - Head
		head = new BodyPart(assetManager.get("data/textures/skin/head.png",
				Texture.class), 0, 20);
		bodyParts.put(BodyPartType.HEAD, head);
		this.addActor(head);

		// - Right Leg
		rightLeg = new BodyPart(assetManager.get(
				"data/textures/skin/right_leg.png", Texture.class), 0, -16);
		bodyParts.put(BodyPartType.RIGHT_LEG, rightLeg);
		this.addActor(rightLeg);

		// - Right Arm
		rightArm = new BodyPart(assetManager.get(
				"data/textures/skin/right_arm.png", Texture.class), 0, 15);
		bodyParts.put(BodyPartType.RIGHT_ARM, rightArm);
		this.addActor(rightArm);

		// Vomit effect
		ParticleEffect vomitEffect = new ParticleEffect();
		vomitEffect.load(Gdx.files.internal("data/particles/vomit.p"),
				Gdx.files.internal("data/particles"));
		head.addParticleEffect(vomitEffect, 70, 70);
	}

	public void setSkinColor(Color color) {
		for (BodyPartType partType : bodyParts.keySet()) {
			bodyParts.get(partType).setColor(color);
		}
	}

	public void setSkinColor(float r, float g, float b, float alpha) {
		for (BodyPartType partType : bodyParts.keySet()) {
			bodyParts.get(partType).setColor(r, g, b, alpha);
		}
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

	public void setInventory(Map<EquipmentType, Stuff> inventory) {
		// remove all before
		removeInventory();
		// all inventorys
		for (EquipmentType type : inventory.keySet()) {

			EquipmentStuff equipmentStuff = (EquipmentStuff) inventory
					.get(type);
			// all spriteParts of this equipment
			for (BodyPartType bodyPartType : equipmentStuff.getSpritesParts()
					.keySet()) {
				// if this part exist
				if (this.bodyParts.containsKey(bodyPartType)) {
					bodyParts.get(bodyPartType).addStuffDecal(
							equipmentStuff.getSpritesParts().get(bodyPartType));
				}
			}
		}
	}

	public void setFeatures(List<Feature> features) {
		// remove all before
		removeFeatures();
		// then add all
		for (Feature feature : features) {
			if (this.bodyParts.containsKey(feature.getType().bodyPart())) {
				this.bodyParts.get(feature.getType().bodyPart()).addSkinDecal(
						feature.getSprite());
			}
		}
	}

	public void removeInvetoryOn(BodyPartType type) {
		if (this.bodyParts.containsKey(type)) {
			bodyParts.get(type).clearStuffDecals();
		}
	}

	public void removeFeaturesOn(BodyPartType type) {
		if (this.bodyParts.containsKey(type)) {
			bodyParts.get(type).clearSkinDecals();
		}
	}

	public void removeInventory() {
		for (BodyPartType bodyPartType : this.bodyParts.keySet()) {
			this.bodyParts.get(bodyPartType).clearStuffDecals();
		}
	}

	public void removeFeatures() {
		for (BodyPartType bodyPartType : this.bodyParts.keySet()) {
			this.bodyParts.get(bodyPartType).clearSkinDecals();
		}
	}

	// TODO
	public void update(float speed) {
		head.getParticlesEffects().get(0).getEffect().getEmitters().get(0)
				.getWind().setHigh(-speed * 20);
	}

	public void run() {
		if (!this.state.equals(CharacterState.RUNNING)) {
			leftLeg.addAction(Actions.forever(Actions.sequence(
					Actions.rotateBy(45, 1), Actions.rotateBy(-45, 1))));
			state = CharacterState.RUNNING;
		}
	}

	public void vomit() {
		head.getParticlesEffects().get(0).getEffect().start();
	}

	public void rotateBody(float degrees) {
		this.rotate(degrees);
	}

	public void rotateLeftArm(float degrees) {
		leftArm.rotate(degrees);
	}

	public void rotateRightArm(float degrees) {
		rightArm.rotate(degrees);
	}

	public void rotateLeftLeg(float degrees) {
		leftLeg.rotate(degrees);
	}

	public void rotateRightLeg(float degrees) {
		rightLeg.rotate(degrees);
	}

	public void rotateHead(float degrees) {
		head.rotate(degrees);
	}

	public BodyPart getBody() {
		return body;
	}

	public BodyPart getLeftArm() {
		return leftArm;
	}

	public BodyPart getRightArm() {
		return rightArm;
	}

	public BodyPart getLeftLeg() {
		return leftLeg;
	}

	public BodyPart getRightLeg() {
		return rightLeg;
	}

	public BodyPart getHead() {
		return head;
	}

	public CharacterState getState() {
		return state;
	}

}
