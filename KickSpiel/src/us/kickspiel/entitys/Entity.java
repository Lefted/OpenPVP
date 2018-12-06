package us.kickspiel.entitys;

import java.awt.Graphics;

public abstract class Entity {

	public float getPosX() {
		return posX;
	}

	protected float posX, posY;

	public Entity(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public abstract void tick();

	public abstract void render(Graphics gfx);

	// Class
	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}
}
