package com.polycraft.slippyjuice.scene;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Scene extends Stage {

	private Map<LayerType, Layer> layers;

	public Scene() {
		super();
		layers = new HashMap<LayerType, Layer>();
	}

	public Scene(float width, float height, boolean keepAspectRatio,
			SpriteBatch batch) {
		super(width, height, keepAspectRatio, batch);
		layers = new HashMap<LayerType, Layer>();
	}

	public Scene(float width, float height, boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		layers = new HashMap<LayerType, Layer>();
	}

	public void update(Float distance) {
		for (LayerType layerType : layers.keySet()) {
			layers.get(layerType).update(distance);
		}
	}

	public Layer getLayer(LayerType layerType) {
		return this.layers.get(layerType);
	}

	public void setLayer(LayerType layerType, Layer layer) {
		layer.setZIndex(layerType.zIndex());
		this.layers.put(layerType, layer);
		this.addActor(layer);
	}

}
