package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.polycraft.slippyjuice.renderers.Renderer;

public class TestRenderer4 extends Renderer {

	public Group group;
	public Actor actor;

	public TestRenderer4() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		stage = new Stage(width, height, true, batch);

		group = new Group();
		actor = new Actor();

		group.addActor(actor);

		stage.addActor(group);

		group.addAction(Actions.moveTo(300, 300, 1000));
	}

	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();

		System.out.println("parent " + group.getX() + "," + group.getY()
				+ " | child " + actor.getX() + "," + actor.getY());
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			group.translate(1, 1);
		}

	}

}
