package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	protected int mx,my;
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		this.handler=handler;
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
	
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.obj.size(); i++) {
			GameObject tempObj = handler.obj.get(i);
			
			if(tempObj.getId() == ID.Obstcl) {
				if(getBounds().intersects(tempObj.getBounds())) {
					//collision code
					HUD.LIVES--;
				}
			}
		}
 	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	

}
