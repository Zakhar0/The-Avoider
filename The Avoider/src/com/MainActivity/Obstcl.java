package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstcl extends GameObject{

	public Obstcl(int x, int y, ID id) {
		
		
		super(x, y, id);	
	}

	public void tick() {
		vy=1;
		y+=vy;
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 10, 10);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,10,10);
	}

}
