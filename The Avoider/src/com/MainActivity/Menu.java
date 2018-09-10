package com.MainActivity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.MainActivity.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	
	public Menu (Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();
		
		if (mouseOver(mx,my, 210, 100, 200, 64)) {
			game.gameState=STATE.Game;
			handler.addObj(new Player(100, 100, ID.Player, handler));
			handler.addObj(new Obstcl(300, 1, ID.Obstcl));
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if (my>y && my < y + height) {
				return true;
			} else
				return false;
		}else 
			return false;
		
	}
	
	public void tick() {
		
	}

	
	public void render(Graphics g) {
		Font f = new Font("Calibri", 1, 50);
		Font f2 = new Font("Calibri", 1, 30);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Menu", 250, 50);

		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Play", 285, 140);
		g.drawRect(210, 100, 200, 64);
		
		g.setColor(Color.white);
		g.drawString("Exit", 285, 240);
		g.drawRect(210, 200, 200, 64);
		 
	}
}
