package com.polycraft.slippyjuice.scene.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Human extends Group {

	public class Body extends Group {

		Sprite sprite;

		public Body(Texture texture) {
			super();
			sprite = new Sprite(texture);
			setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
			setSize(texture.getWidth(), texture.getHeight());
			setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
			setPosition(0, 0);
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
			setPosition(0, -15);
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
			setPosition(-3, -45);
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
			setPosition(0, 0);
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

	private Body body;
	private Arm leftArm;
	private Arm rightArm;
	private Leg leftLeg;
	private Leg rightLeg;
	private Head head;

	public Human(float x, float y) {
		super();
		setPosition(x, y);
		buildCharacter();
	}

	protected void buildCharacter() {
		// - Body
		body = new Body(new Texture(Gdx.files.internal("data/body.png")));
		body.setTransform(true);
		this.addActor(body);

		// - Left Arm
		leftArm = new Arm(new Texture(Gdx.files.internal("data/right_arm.png")));
		body.addActor(leftArm);

		// - Right Arm
		rightArm = new Arm(
				new Texture(Gdx.files.internal("data/right_arm.png")));
		body.addActor(rightArm);

		// - Left Leg
		leftLeg = new Leg(new Texture(Gdx.files.internal("data/right_leg.png")));
		body.addActor(leftLeg);

		// - Right Leg
		rightLeg = new Leg(
				new Texture(Gdx.files.internal("data/right_leg.png")));
		body.addActor(rightLeg);
		// - Head
		head = new Head(new Texture(Gdx.files.internal("data/head.png")));
		// body.addActor(head);

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

	public void rotateBody(float degrees) {
		body.rotate(degrees);
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

	public Body getBody() {
		return body;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public Arm getRightArm() {
		return rightArm;
	}

	public Leg getLeftLeg() {
		return leftLeg;
	}

	public Leg getRightLeg() {
		return rightLeg;
	}

	public Head getHead() {
		return head;
	}

}
