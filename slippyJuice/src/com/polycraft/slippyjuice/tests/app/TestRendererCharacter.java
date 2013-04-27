package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.polycraft.slippyjuice.renderers.Renderer;
import com.polycraft.slippyjuice.scene.character.Character;

public class TestRendererCharacter extends Renderer {

	Character human;

	public TestRendererCharacter() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		stage = new Stage(width, height, true, batch);
		Gdx.input.setInputProcessor(stage);

		batch = new SpriteBatch(); // #22
		AssetManager manager = new AssetManager();
		manager.load("data/body.png", Texture.class);

		human = new Character(0, 0, 64, 64);

		stage.addActor(human);

	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(2, 2, 2, 2);
		// actualise le background
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #24

		// batch.setProjectionMatrix(camera.combined);

		// batch.begin();
		// // // human.draw(batch);
		// batch.end();

		stage.draw();
		// stage.act();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);
			human.setPosition(touchPos.x, touchPos.y);

		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			human.rotateLeftArm(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			human.rotateLeftArm(-2);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			human.rotateBody(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			human.rotateBody(-2);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.I)) {
			human.rotateRightLeg(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.K)) {
			human.rotateRightLeg(-2);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.O)) {
			human.rotateHead(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.L)) {
			human.rotateHead(-2);
		}

	}
}
