package us.kickspiel.physics;

import us.kickspiel.entitys.Entity;

public class GrundCollision{

	private Physics physics;

	private void Ground(Physics phyics) {
		this.physics = phyics;
	}

	
	public static void tick(Entity entity) {
		if (entity.getPosY() >= 385) {
			entity.setPosY(385);
		}
	}
}
