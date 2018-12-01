package us.kickspiel.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int sheetWIDTH = 128, sheetHEIGHT = 128;
	
	public static BufferedImage player, spriteSheet;
	public static  SpriteSheet sheet;
	
	public static void init() {
		spriteSheet = ImageLoader.loadImage("/textures/SpriteSheet.png");
		sheet = new SpriteSheet(spriteSheet);
		player = sheet.crop(0 * sheetWIDTH, 0 * sheetHEIGHT, sheetWIDTH, sheetHEIGHT);
	}
	
}
