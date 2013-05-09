package com.polycraft.slippyjuice.tests.app;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.polycraft.slippyjuice.renderers.Renderer;
import com.polycraft.slippyjuice.scene.Scene;

public class TestRenderer extends Renderer {
	protected Scene scene;

	private static final int FRAME_COLS = 4;
	private static final int FRAME_ROWS = 8;

	Animation walkAnimation;
	Texture walkSheet;
	TextureRegion[] walkFrames;
	SpriteBatch spriteBatch;
	TextureRegion currentFrame;
	Texture groundTexture;
	Sprite perso;
	Sprite cube;
	List<Sprite> groundPieces;

	float stateTime;

	public TestRenderer(AssetManager assetManager) {
		super(assetManager);
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		// Gdx.input.setInputProcessor(stage);

		walkSheet = new Texture(Gdx.files.internal("data/skin.png")); // #9
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight()
						/ FRAME_ROWS); // #10
		walkFrames = new TextureRegion[FRAME_COLS];
		int index = 0;

		for (int j = 0; j < FRAME_COLS; j++) {
			walkFrames[index++] = tmp[0][j];
		}
		walkAnimation = new Animation(0.2f, walkFrames); // #11
		spriteBatch = new SpriteBatch(); // #12
		stateTime = 0f; // #13

		perso = new Sprite(walkAnimation.getKeyFrame(stateTime, true));
		perso.setPosition(0, 0);
		perso.setSize(128 * 1.5f, 64 * 1.5f);

		cube = new Sprite(new Texture(Gdx.files.internal("data/cubeTest.png")));
		cube.setPosition(65 * 10, 64 * 2);

		groundTexture = new Texture(Gdx.files.internal("data/groundPiece.png"));
		buildGround();
	}

	@Override
	public void render(float delta) {
		// init the background color
		Gdx.gl.glClearColor(1, 1, 1, 1);
		// actualise le background
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); // #14
		spriteBatch.setProjectionMatrix(camera.combined);
		stateTime += Gdx.graphics.getDeltaTime(); // #15
		currentFrame = walkAnimation.getKeyFrame(stateTime, true); // #16
		perso.setRegion(currentFrame);
		spriteBatch.begin();
		for (Sprite sprite : groundPieces) {
			sprite.draw(spriteBatch);
		}
		perso.draw(spriteBatch);
		cube.draw(spriteBatch);

		spriteBatch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);
			perso.setY(touchPos.y);
			perso.setX(touchPos.x);
		}
	}

	private void buildGround() {
		groundPieces = new ArrayList<Sprite>();
		for (int i = 0; i < 4; i++) {
			for (int j = -1; j < 11; j++) {
				Sprite newSprite = new Sprite(groundTexture);
				newSprite.setPosition(j * 64, i * 64);
				groundPieces.add(newSprite);
			}
		}
	}

}
