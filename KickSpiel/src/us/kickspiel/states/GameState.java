package us.kickspiel.states;

import java.awt.Graphics;

import us.kickspiel.entitys.Player;
import us.kickspiel.general.Engine;
import us.kickspiel.gfx.Assets;

public class GameState extends State {

	private Player player;
	
	public GameState(Engine engine) {
		super(engine);
		player = new Player(engine, 400, 300);
	}

	@Override
	public void tick() {
		player.tick();			
	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(Assets.background, 0, 0, null);
		player.render(gfx);
	}

}
