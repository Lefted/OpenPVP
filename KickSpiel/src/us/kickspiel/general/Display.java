package us.kickspiel.general;

import javax.swing.JFrame;

public class Display {

	String title;
	int sizeX, sizeY;
	
	JFrame frame;
	
	public Display(String title, int sizeX, int sizeY) {
		this.title = title;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		createDisplay();
	}
	
	public void createDisplay() {
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(sizeX, sizeY);
		frame.setLocationRelativeTo(null);
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
