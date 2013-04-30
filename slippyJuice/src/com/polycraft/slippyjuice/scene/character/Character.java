package com.polycraft.slippyjuice.scene.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Character extends Group {

	public class Body extends Group {

		Sprite sprite;

		public Body(Texture texture) {
			super();
			sprite = new Sprite(texture);
			setOrigin(0, 0);
			setSize(texture.getWidth(), texture.getHeight());
			setPosition(-texture.getWidth() / 2, -texture.getHeight() / 2);
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch);
			super.draw(batch, parentAlpha);
		}
	}

	public class Arm extends Group {
		Sprite sprite;

		public Arm(Texture texture) {
			super();
			sprite = new Sprite(texture);
			setOrigin(texture.getWidth() / 2, texture.getHeight());
			setSize(texture.getWidth(), texture.getHeight());
			setPosition(-texture.getWidth() / 2, -texture.getHeight() / 2 - 15);
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch);
			super.draw(batch, parentAlpha);
		}
	}

	public class Leg extends Group {
		Sprite sprite;

		public Leg(Texture texture) {
			super();
			sprite = new Sprite(texture);
			setOrigin(texture.getWidth() / 2, texture.getHeight());
			setSize(texture.getWidth(), texture.getHeight());
			// setPosition(-3, -45);
			setPosition(-texture.getWidth() / 2 - 3,
					-texture.getHeight() / 2 - 45);
		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch);
			super.draw(batch, parentAlpha);
		}

	}

	public class Head extends Group {
		Sprite sprite;

		public Head(Texture texture) {
			super();
			sprite = new Sprite(texture);
			setOrigin(texture.getWidth() / 2, texture.getHeight());
			setSize(texture.getWidth(), texture.getHeight());
			setPosition(-texture.getWidth() / 2, -texture.getHeight() / 2 - 15);
			setRotation(180);

		}

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			sprite.setOrigin(getOriginX(), getOriginY());
			sprite.setPosition(getX(), getY());
			sprite.setRotation(getRotation());
			sprite.setSize(getWidth(), getHeight());
			sprite.draw(batch);
			super.draw(batch, parentAlpha);
		}

	}

	private BodyPart body;
	private BodyPart leftArm;
	private BodyPart rightArm;
	private BodyPart leftLeg;
	private BodyPart rightLeg;
	private BodyPart head;

	public Character(float x, float y, float width, float height) {
		super();
		setSize(width, height);
		setOrigin(0, 0);
		setPosition(x, y);
		buildCharacter();
	}

	protected void buildCharacter() {
		// Du plus éloigné au plus proche

		// - Left Arm

		leftArm = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/right_arm.png")), 0, 15);
		this.addActor(leftArm);

		// - Left Leg
		leftLeg = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/right_leg.png")), 0, -16);
		this.addActor(leftLeg);

		// - Body
		body = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/body.png")), 0, 0);
		this.addActor(body);

		// - Head
		head = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/head.png")), 0, 20);
		this.addActor(head);

		// - Right Leg
		rightLeg = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/right_leg.png")), 0, -16);
		this.addActor(rightLeg);

		// - Right Arm
		rightArm = new BodyPart(new Texture(
				Gdx.files.internal("data/skin/right_arm.png")), 0, 15);
		this.addActor(rightArm);

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
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

}
