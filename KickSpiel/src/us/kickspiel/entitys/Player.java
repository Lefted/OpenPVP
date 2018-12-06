package us.kickspiel.entitys;

import java.awt.Graphics;

import us.kickspiel.general.Engine;
import us.kickspiel.gfx.Assets;

public class Player extends Entity{

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
	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(Assets.player, (int) posX, (int) posY, null);
	}

}
