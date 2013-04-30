package com.polycraft.slippyjuice.scene.character;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;

public class BodyPart extends Group {
	Sprite skin;
	List<Feature> features;
	List<EquipmentStuff> stuffs;

	public BodyPart(Texture texture, float x, float y) {
		super();
		skin = new Sprite(texture);
		features = new ArrayList<Feature>();
		stuffs = new ArrayList<EquipmentStuff>();

		setOrigin(texture.getWidth() / 2, texture.getHeight() / 2);
		setSize(texture.getWidth(), texture.getHeight());
		setPosition(-texture.getWidth() / 2 + x, -texture.getHeight() / 2 + y);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		drawSkin(batch, parentAlpha);
		drawFeatures(batch, parentAlpha);
		drawEquipment(batch, parentAlpha);
		super.draw(batch, parentAlpha);
	}

	private void drawSkin(SpriteBatch batch, float parentAlpha) {
		skin.setOrigin(getOriginX(), getOriginY());
		skin.setPosition(getX(), getY());
		skin.setRotation(getRotation());
		skin.setSize(getWidth(), getHeight());
		skin.draw(batch, parentAlpha);
	}

	private void drawFeatures(SpriteBatch batch, float parentAlpha) {
		for (Feature feature : features) {
			Sprite featureSprite = feature.getSprite();
			featureSprite.setOrigin(getOriginX(), getOriginY());
			featureSprite.setPosition(getX(), getY());
			featureSprite.setRotation(getRotation());
			featureSprite.setSize(getWidth(), getHeight());
			featureSprite.draw(batch, parentAlpha);
		}
	}

	private void drawEquipment(SpriteBatch batch, float parentAlpha) {
		for (EquipmentStuff stuff : stuffs) {
			Sprite stuffSprite = stuff.getSprite();
			stuffSprite.setOrigin(getOriginX(), getOriginY());
			stuffSprite.setPosition(getX(), getY());
			stuffSprite.setRotation(getRotation());
			stuffSprite.setSize(getWidth(), getHeight());
			stuffSprite.draw(batch, parentAlpha);
		}
	}

	public void addFeature(Feature feature) {
		features.add(feature);
	}

	public void addEquipmentStuff(EquipmentStuff equipmentStuff) {
		stuffs.add(equipmentStuff);
	}
}
