package us.kickspiel.general;

public class Engine implements Runnable {

	private String title;
	private int width, height;

	private Display display;
	private Thread thread;

	private boolean running = false;

	public Engine(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}

	private void init() {
		display = new Display(title, width, height);
	}

	@Override
	public void run() {
		init();
		while(running) {
			
			tick();
			render();
			
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

}
