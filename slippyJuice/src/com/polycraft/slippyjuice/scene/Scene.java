package com.polycraft.slippyjuice.scene;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Scene extends Stage {

	private Map<LayerType, Group> layers;

	public Scene() {
		super();
		layers = new HashMap<LayerType, Group>();
	}

	public Scene(float width, float height, boolean keepAspectRatio,
			SpriteBatch batch) {
		super(width, height, keepAspectRatio, batch);
		// TODO Auto-generated constructor stub
	}

	public Scene(float width, float height, boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		// TODO Auto-generated constructor stub
	}

	public Group getLayer(LayerType layerType) {
		return this.layers.get(layerType);
	}

	public void setLayer(LayerType layerType, Group group) {
		this.layers.put(layerType, group);
	}

}
