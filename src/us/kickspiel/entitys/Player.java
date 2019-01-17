package us.kickspiel.entitys;

import java.awt.Graphics;

import us.kickspiel.general.Engine;
import us.kickspiel.gfx.Assets;
import us.kickspiel.physics.Gravity;
import us.kickspiel.physics.GrundCollision;
import us.kickspiel.states.GameState;

public class Player extends Entity {

	private Engine engine;
	private float velocity = 4;

	public Player(Engine engine, float posX, float posY) {
		super(posX, posY);
		this.engine = engine;
	}

	@Override
	public void tick() {
		if (engine.getKeyManager().keyW) {
			posY -= velocity;
		}
		if (engine.getKeyManager().keyA) {
			posX -= velocity;
		}
		if (engine.getKeyManager().keyS) {
			posY += velocity;
		}
		if (engine.getKeyManager().keyD) {
			posX += velocity;
		}
		
		teleportToBorder();
//		System.out.println(posY);
		Gravity.tick(this);
		GrundCollision.tick(this);
	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(Assets.player, (int) posX, (int) posY, null);
	}

	private void teleportToBorder() {
		if (posX > 870) {
			posX = -70;
			GameState.hasleftborders = true;
		} else {
			GameState.hasleftborders = false;
		}
		if (posX < -100) {
			posX = 770;
			GameState.hasleftborders = true;
		} else {
			GameState.hasleftborders = false;
		}
		if (posY > 660) {
			posY = -70;
		}
		if (posY < -128) {
			posY = 660;
		}
	}
}
