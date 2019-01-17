package us.kickspiel.states;

import java.awt.Graphics;

import us.kickspiel.entitys.Player;
import us.kickspiel.general.Engine;
import us.kickspiel.gfx.Assets;
import us.kickspiel.physics.Physics;

public class GameState extends State {

	private Player player;
	public static boolean hasleftborders;
	private int backgroundState = 1;

	public GameState(Engine engine) {
		super(engine);
		player = new Player(engine, 400, 300);
	}

	@Override
	public void tick() {
		player.tick();
		Physics.tick();
	}

	@Override
	public void render(Graphics gfx) {
		if (hasleftborders) {
			if (backgroundState == 1) {
				backgroundState = 2;
				gfx.drawImage(Assets.woods, 0, 0, null);
			}
			if (backgroundState == 2) {
				backgroundState = 1;
				gfx.drawImage(Assets.background, 0, 0, null);
			}
		}
		if (backgroundState == 1) {
			gfx.drawImage(Assets.background, 0, 0, null);
		}
		if (backgroundState == 2) {
			gfx.drawImage(Assets.woods, 0, 0, null);
		}

		player.render(gfx);
	}

}
