package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

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
		if (mx>0 && my>0 && mx <Game.WIDTH - 33 && my< Game.HEIGHT - 54) {
			setX(mx);
			setY(my);
		} else
		this.keepIn();
	}
	
	@Override
	public void keepIn(){
		
		if (mx<0 && my<0) {
			setX(0);
			setY(0);
		} else if (mx> Game.WIDTH - 33 && my> Game.HEIGHT - 54) {
			setX(Game.WIDTH - 33);
			setY(Game.HEIGHT - 54);
			
		} else if (mx<0 && my <= Game.HEIGHT - 54) {
			setX(0);
			setY(my);
			
		} else if (my<0 && mx< Game.WIDTH - 33) {
			setY(0);
			setX(mx);
			
		} else if (mx>Game.WIDTH - 33 && my>0){
			setX(Game.WIDTH - 33);
			setY(my);
			
		} else if (my>Game.HEIGHT - 54 && mx>0){
			setY(Game.HEIGHT - 54);
			setX(mx);
		}
	}
	
	public void tick() {
			followMouse();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	

}
