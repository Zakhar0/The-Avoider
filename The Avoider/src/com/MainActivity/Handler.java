package com.MainActivity;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> obj = new LinkedList<>();
	
	public void tick() {
		for(int i = 0; i < obj.size(); i++) {
			GameObject tempObj = obj.get(i);
			
			tempObj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < obj.size(); i++) {
			GameObject tempObj = obj.get(i);
			
			tempObj.render(g);
		}
		
	}
		
	public void addObj(GameObject obj) {
		this.obj.add(obj);
	}
	
	public void removeObj (GameObject obj) {
		this.obj.remove(obj);
	}
	

}
