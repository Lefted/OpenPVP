package us.kickspiel.general;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import us.kickspiel.gfx.Assets;
import us.kickspiel.input.KeyManager;
import us.kickspiel.states.GameState;
import us.kickspiel.states.State;

public class Engine implements Runnable {

	private String title;
	private int width, height;
	private int fps;
	private boolean running = false;	

	private Display display;
	private Thread thread;

	private BufferStrategy bufferStrategy;
	private Graphics gfx;

	//	States go here
	private State gameState;

	private KeyManager keyManager;

	public Engine(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	private void init() {
		Assets.init();
		display = new Display(title, width, height);

		display.getFrame().addKeyListener(keyManager);
		gameState = new GameState(this);
		State.setState(gameState);

	}

	public void tick() {
		keyManager.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	public void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		gfx = bufferStrategy.getDrawGraphics();

		gfx.clearRect(0, 0, width, height);
		//		Draw

		State.getState().render(gfx);
		//		EndDraw
		bufferStrategy.show();
		gfx.dispose();

	}

	@Override
	public void run() {
		init();

		fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		@SuppressWarnings("unused")
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				//				System.out.println("Ticks / Frame: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

}
