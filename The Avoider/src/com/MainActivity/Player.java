package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	protected int mx,my;

	public Player(int x, int y, ID id) {
		
		super(x, y, id);
	}
	public void followMouse(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		this.mx = (int) b.getX()-420;
		this.my = (int) b.getY()-290;
	}
	
	
	
	public void tick() {
		followMouse();
		
		x = Game.clamp(mx, 0, Game.WIDTH-33);
		y = Game.clamp(my, 0, Game.HEIGHT-54);
			
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		g.setColor(Color.white);
		g2d.draw(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	

}
