package com.polycraft.slippyjuice.tests.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.polycraft.slippyjuice.box2d.BodyBuilder;
import com.polycraft.slippyjuice.box2d.JointBuilder;
import com.polycraft.slippyjuice.renderers.Renderer;

public class TestRendererPhysic extends Renderer {

	private World world;
	private BodyBuilder bodyBuilder;
	private JointBuilder jointBuilder;
	Body bodyA;
	Body bodyB;
	Sprite spriteA;
	Sprite spriteB;

	float stateTime;

	public TestRendererPhysic() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		stage = new Stage(width, height, true, batch);

		world = new World(new Vector2(0, -100), true);

		bodyBuilder = new BodyBuilder(world);

		bodyA = bodyBuilder
				.fixture(
						bodyBuilder.fixtureDefBuilder().circleShape(1f)
								.restitution(1).density(1).friction(10))
				.position(64, 64).mass(1f).type(BodyType.StaticBody).build();
		bodyB = bodyBuilder
				.fixture(

						bodyBuilder.fixtureDefBuilder().circleShape(1f)
								.restitution(1).density(1).friction(10))
				.position(0, 0).inertia(0.2f).mass(500)
				.type(BodyType.DynamicBody).build();

		// bodyB.setAngularVelocity(2);

		jointBuilder = new JointBuilder(world);

		Joint joint = jointBuilder.revoluteJoint().bodyA(bodyA, 0, 0)
				.bodyB(bodyB, 0, 64).collideConnected(false).build();

		Texture texture = new Texture(
				Gdx.files.internal("data/groundPiece.png"));

		spriteA = new Sprite(texture);
		spriteB = new Sprite(texture);

	}

	@Override
	public void render(float delta) {
		world.step(1 / 10f, 6, 2);

		spriteA.setPosition(bodyA.getPosition().x, bodyA.getPosition().y);
		spriteA.setRotation(bodyA.getAngle() * MathUtils.radiansToDegrees);

		spriteB.setPosition(bodyB.getPosition().x, bodyB.getPosition().y);
		spriteB.setRotation(bodyB.getAngle() * MathUtils.radiansToDegrees);
		// init the background color
		Gdx.gl.glClearColor(1, 1, 1, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); // #14
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		spriteA.draw(batch);
		spriteB.draw(batch);
		batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);
			bodyA.setTransform(touchPos.x, touchPos.y, 0);
		}
	}
}
