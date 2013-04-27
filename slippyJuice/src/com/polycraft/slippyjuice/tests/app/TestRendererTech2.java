package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.polycraft.slippyjuice.renderers.Renderer;
import com.polycraft.slippyjuice.scene.character.Child;
import com.polycraft.slippyjuice.scene.character.Human;
import com.polycraft.slippyjuice.scene.character.Parent;

public class TestRendererTech2 extends Renderer {

	Human human;
	Parent parent;
	Child child;
	Sprite sprite;

	public TestRendererTech2() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		stage = new Stage(width, height, true, batch);
		Gdx.input.setInputProcessor(stage);

		parent = new Parent();
		// parent.setRotation(30);
		parent.setTransform(true);
		// parent.setBounds(50, 50, 150, 150);
		stage.addActor(parent);

		child = new Child();
		// child.setTransform(true);
		// child.setBounds(10, 10, 35, 35);
		// child.setOriginX(100);
		// child.setRotation(45);
		parent.addActor(child);

		// Gdx.input.setInputProcessor(stage);

		batch = new SpriteBatch(); // #12
		AssetManager manager = new AssetManager();
		manager.load("data/body.png", Texture.class);

		human = new Human(100, 100);

		stage.addActor(human);

	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(1, 1, 1, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); // #14

		// batch.setProjectionMatrix(camera.combined);

		// batch.begin();
		// // // human.draw(batch);
		// batch.end();

		stage.draw();
		// stage.act();

		System.out.println("parent " + parent.getX() + "," + parent.getY()
				+ " | child " + child.getX() + "," + child.getY());
		// human.rotateLeftArm(testAngle);
		// human.rotateRightArm(-testAngle);
		// human.rotateRightLeg(+testAngle);
		// human.rotateLeftLeg(-testAngle);
		//
		// if (testAngle > 0 && human.getLeftArm().getRotation() > 45) {
		// testAngle = -testAngle;
		// } else if (testAngle < 0 && human.getLeftArm().getRotation() < -45) {
		// testAngle = -testAngle;
		// }

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);

		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			human.rotateLeftArm(1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			human.rotateBody(1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
		}

		if (Gdx.input.isKeyPressed(Input.Keys.I)) {
		}
		if (Gdx.input.isKeyPressed(Input.Keys.K)) {
		}

		if (Gdx.input.isKeyPressed(Input.Keys.O)) {
		}
		if (Gdx.input.isKeyPressed(Input.Keys.L)) {
		}

	}
}
