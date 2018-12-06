package us.kickspiel.entitys;

import java.awt.Graphics;

public abstract class Entity {

	protected float posX, posY;
	
	public Entity(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics gfx);
	
}
