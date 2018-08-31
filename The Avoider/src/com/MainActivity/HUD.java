package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int SCORE = 0;
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawString(Integer.toString(SCORE), 400, 20);
	}

}
