package com.polycraft.slippyjuice.tests.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.polycraft.slippyjuice.player.Feature;
import com.polycraft.slippyjuice.player.Player;
import com.polycraft.slippyjuice.player.PlayerInformation;
import com.polycraft.slippyjuice.renderers.Renderer;
import com.polycraft.slippyjuice.scene.Scene;
import com.polycraft.slippyjuice.scene.character.BodyPartType;
import com.polycraft.slippyjuice.scene.character.Character;
import com.polycraft.slippyjuice.simulation.GameLoopEngine;
import com.polycraft.slippyjuice.stuff.Caracteristics;
import com.polycraft.slippyjuice.stuff.EquipmentStuff;
import com.polycraft.slippyjuice.stuff.EquipmentType;
import com.polycraft.slippyjuice.stuff.Stuff;

public class TestRendererCharacter extends Renderer {

	Character human;
	GameLoopEngine gameLoopEngine;

	public TestRendererCharacter(AssetManager assetManager) {

		super(assetManager);
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);
		camera.translate(width / 2, height / 2);
		camera.update();

		batch = new SpriteBatch();
		scene = new Scene(width, height, true, batch);
		Gdx.input.setInputProcessor(scene);

		batch = new SpriteBatch(); // #22
		AssetManager manager = new AssetManager();
		manager.load("data/body.png", Texture.class);

		human = new Character(assetManager, 0, 0, 64, 64);

		scene.addActor(human);

		// un joueur
		PlayerInformation playerInformation = new PlayerInformation("Bob", 10,
				1);
		Player player = new Player(playerInformation);

		// equipment
		EquipmentStuff equip1 = new EquipmentStuff(null, "Masque", "blabla",
				31, 5, EquipmentType.HELMET, Caracteristics.RESISTANCE, 21);

		Texture texture = new Texture(
				Gdx.files.internal("data/textures/equipments/mask1.png"));
		Map<BodyPartType, Sprite> spriteParts = new HashMap<BodyPartType, Sprite>();
		spriteParts.put(BodyPartType.HEAD, new Sprite(texture));

		equip1.setSpritesParts(spriteParts);

		// spiderman armure test
		Map<BodyPartType, Sprite> spritePartsSpiderMan = new HashMap<BodyPartType, Sprite>();
		spritePartsSpiderMan
				.put(BodyPartType.BODY,
						new Sprite(
								new Texture(
										Gdx.files
												.internal("data/textures/equipments/armor1_body.png"))));
		spritePartsSpiderMan.put(
				BodyPartType.RIGHT_ARM,
				new Sprite(new Texture(Gdx.files
						.internal("data/textures/equipments/armor1_arm.png"))));

		EquipmentStuff equip2 = new EquipmentStuff(null, "Haut SpiderMan",
				"blabla", 31, 5, EquipmentType.ARMOR,
				Caracteristics.RESISTANCE, 21, spritePartsSpiderMan);

		// inventory
		Map<EquipmentType, Stuff> inventory = new HashMap<EquipmentType, Stuff>();

		// inventory.put(equip1.getEquipmentType(), equip1);
		inventory.put(equip2.getEquipmentType(), equip2);

		// player.addStuff(equip1);
		// player.equip(equip1);

		Feature featureTest = new Feature(0, "test", BodyPartType.HEAD,
				new Texture(
						Gdx.files.internal("data/textures/features/hair1.png")));
		List<Feature> features = new ArrayList<Feature>();
		features.add(featureTest);

		human.setFeatures(features);
		human.setInventory(inventory);

		human.setSkinColor(0, 0.5f, 1, 1);

		gameLoopEngine = new GameLoopEngine(player, scene);
	}

	@Override
	public void render(float delta) {
		gameLoopEngine.update(delta);
		// init the background color
		Gdx.gl.glClearColor(2, 2, 2, 2);
		// actualise le background
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #24

		// batch.setProjectionMatrix(camera.combined);

		// batch.begin();
		// // // human.draw(batch);
		// batch.end();

		scene.draw();
		// stage.act();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			camera.unproject(touchPos);
			human.setPosition(touchPos.x, touchPos.y);

		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			human.rotateRightArm(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			human.rotateRightArm(-2);
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
