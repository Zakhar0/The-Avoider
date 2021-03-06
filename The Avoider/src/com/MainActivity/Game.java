package com.MainActivity;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -3192454351902361511L;
	
	public final static int WIDTH = 640, HEIGHT = 400;
	private Thread thread;
	private boolean running = false;
	private HUD hud;
	
	private Handler handler;
	private Menu menu;
	 
	public enum STATE {
		 Menu,
		 Game
	 };
	 
	public STATE gameState= STATE.Menu;
	
	public Game() {
		
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "The Avoider", this);
		
		
		hud = new HUD();
		

		
		if (gameState == STATE.Game) {
		handler.addObj(new Player(100, 100, ID.Player, handler));
		handler.addObj(new Obstcl(300, 1, ID.Obstcl));
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if(System.currentTimeMillis()-timer > 1000) {
				timer +=1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		if (gameState == STATE.Game) {
			hud.tick();
		}else if (gameState == STATE.Menu){
			menu.tick();
		}
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		
		if (gameState == STATE.Game) {
			hud.render(g);
		} else if (gameState == STATE.Menu){
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public static int clamp(int var, int min, int max) {
		if (var>max) {
			return var = max;
		}if (var<min) {
			return var = min;
		}
			else
				return var;
	}
	
	public static void main(String[] args) {
		new Game();
		// TODO Auto-generated method stub

	}

}
