package us.kickspiel.states;

import java.awt.Graphics;

import us.kickspiel.general.Engine;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Engine engine;
	
	public State(Engine engine) {
		this.engine = engine;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics gfx);
	
}
