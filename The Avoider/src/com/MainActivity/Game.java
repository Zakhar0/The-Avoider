package com.MainActivity;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -3192454351902361511L;
	
	public final static int WIDTH = 640, HEIGHT = WIDTH/12*9;

	
	public Game() {
		new Window(WIDTH, HEIGHT, "The Avoider", this);
		
	}
	
	public synchronized void start() {
		
	}

	public void run() {
		
	}
	
	public static void main(String[] args) {
		new Game();
		// TODO Auto-generated method stub

	}

}
