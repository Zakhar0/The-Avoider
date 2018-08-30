package com.MainActivity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		
		super(x, y, id);
	}
	
	public void tick() {		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);

	}
	

}
