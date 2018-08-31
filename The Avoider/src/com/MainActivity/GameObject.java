package com.MainActivity;

import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int vx, vy;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
//	public boolean isIn() {
//		if (x<0 && y<0) {
//			x=0;
//			y=0;
//			return false;
//		} else if (x>Game.WIDTH - 33 && y> Game.HEIGHT - 54) {
//			x = Game.WIDTH - 33;
//			y = Game.HEIGHT- 54;
//			return false;
//		} else if (x<0) {
//			x=0;
//			return false;
//		} else if (y<0) {
//			y=0;
//			return false;
//		} else if (x>Game.WIDTH - 33){
//			x=Game.WIDTH - 33 -1;
//			return false;
//		} else if (y>Game.HEIGHT - 54){
//			y=Game.HEIGHT- 54 -1;
//			return false;
//		} else if (x>=0 && y>=0 && x<=Game.WIDTH - 33 && y<= Game.HEIGHT - 54) {
//			return true;
//		} else
//		return false;
//	}
	
	public void keepIn() {
	if (getX()<0 && getY()<0) {
		setX(0);
		setY(0);
		
	} else if (getX()>Game.WIDTH - 33 && getY()> Game.HEIGHT - 54) {
		setX(Game.WIDTH - 33);
		setY(Game.HEIGHT - 54);
		
	} else if (getX()<0) {
		setX(0);
		
	} else if (getY()<0) {
		setY(0);
		
	} else if (getX()>Game.WIDTH - 33){
		setX(Game.WIDTH - 33);
		
	} else if (getY()>Game.HEIGHT - 54){
		setY(Game.HEIGHT - 54);
	}
	}
	
	public void setX(int x) {
		this.x = x;
		
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVX(int vx) {
		this.vx = vx;
	}
	public void setVY(int vy) {
		this.vy = vy;
	}
	public int getVX() {
		return vx;
	}
	public int getVY() {
		return vy;
	}
	
	
}
