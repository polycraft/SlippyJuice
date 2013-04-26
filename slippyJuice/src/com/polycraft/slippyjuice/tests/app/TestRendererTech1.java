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

public class TestRendererTech1 extends Renderer {

	private World world;
	private BodyBuilder bodyBuilder;
	private JointBuilder jointBuilder;
	Body bodyA;
	Body bodyB;
	Body bodyC;
	Body bodyD;
	Body bodyE;
	Body bodyF;
	Sprite spriteA;
	Sprite spriteB;
	Sprite spriteC;
	Sprite spriteD;
	Sprite spriteE;
	Sprite spriteF;

	float stateTime;

	public TestRendererTech1() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		stage = new Stage(width, height, true, batch);

		world = new World(new Vector2(0, -200), true);

		bodyBuilder = new BodyBuilder(world);

		bodyA = bodyBuilder
				.fixture(
						bodyBuilder.fixtureDefBuilder().circleShape(0)
								.restitution(0).density(0).friction(10))
				.position(0, 0).mass(1f).type(BodyType.StaticBody).build();
		bodyB = bodyBuilder
				.fixture(

						bodyBuilder.fixtureDefBuilder().circleShape(0)
								.restitution(0).density(0).friction(100))
				.position(0, 0).inertia(1f).mass(10f)
				.type(BodyType.DynamicBody).build();
		bodyC = bodyBuilder
				.fixture(

						bodyBuilder.fixtureDefBuilder().circleShape(0)
								.restitution(100).density(1).friction(0.1f))
				.position(0, 0).inertia(10f).mass(0.1f)
				.type(BodyType.DynamicBody).build();

		// bodyB.setAngularVelocity(2);

		jointBuilder = new JointBuilder(world);

		Joint joint1 = jointBuilder.revoluteJoint().bodyA(bodyA, -5, 14)
				.bodyB(bodyB, 32, 0).collideConnected(false).build();
		Joint joint2 = jointBuilder.revoluteJoint().bodyA(bodyA, -5, 14)
				.bodyB(bodyC, 32, 0).collideConnected(false).build();

		Texture texture = new Texture(Gdx.files.internal("data/boule.png"));
		Texture textureBody = new Texture(Gdx.files.internal("data/body.png"));
		Texture textureArm = new Texture(
				Gdx.files.internal("data/right_arm.png"));

		spriteA = new Sprite(textureBody);

		spriteB = new Sprite(textureArm);
		spriteC = new Sprite(textureArm);
		// spriteC.setOrigin(32, 0);
	}

	@Override
	public void render(float delta) {
		world.step(1 / 32f, 6, 2);

		spriteA.setPosition(bodyA.getPosition().x, bodyA.getPosition().y);
		spriteA.setRotation(bodyA.getAngle() * MathUtils.radiansToDegrees);

		spriteB.setPosition(bodyB.getPosition().x, bodyB.getPosition().y);
		spriteB.setRotation(bodyB.getAngle() * MathUtils.radiansToDegrees - 90);
		spriteC.setPosition(bodyC.getPosition().x, bodyC.getPosition().y);
		spriteC.setRotation(bodyC.getAngle() * MathUtils.radiansToDegrees - 90);
		// init the background color
		Gdx.gl.glClearColor(1, 1, 1, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); // #14
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		spriteC.draw(batch);
		spriteA.draw(batch);
		spriteB.draw(batch);
		batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);
			bodyA.setTransform(touchPos.x, touchPos.y, 0);
		}

		System.out.println("angleB:"
				+ (bodyC.getAngle() * MathUtils.radiansToDegrees));
	}
}
