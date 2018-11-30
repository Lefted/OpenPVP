package us.kickspiel.assets;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player;
	
	public static void init() {
		player = ImageLoader.loadImage("/textures/Authist.png");
	}
	
}
