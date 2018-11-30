package us.kickspiel.general;

public class Launcher {

	static Engine engine;

	public static void main(String[] args) {
		engine = new Engine("KickSpiel", 800, 600);
		engine.start();
	}

}
