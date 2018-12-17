package us.kickspiel.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private static boolean[] keysPressed;
	public static boolean keyW, keyA, keyS, keyD;
	
	public KeyManager() {
		keysPressed = new boolean[256];
	}
	
	public void tick() {
		keyW = keysPressed[KeyEvent.VK_W];
		keyA = keysPressed[KeyEvent.VK_A];
		keyS = keysPressed[KeyEvent.VK_S];
		keyD = keysPressed[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keysPressed[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysPressed[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
