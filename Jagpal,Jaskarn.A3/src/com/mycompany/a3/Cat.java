package com.mycompany.a3;


import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Cat extends Animals implements IDrawable, ICollider {
	//private static Random worldRNG = new Random();
	private static GameWorld game;
	
	public Cat(){
		setColor(ColorUtil.YELLOW);
		this.setSpeed(15);

	}
	public static void setTarget(GameWorld gw){
		if(game == null)
			game = gw;
	}
	
	public String toString(){
		return("Cat: loc = "+getLocationX() + ", "+getLocationY()+
				",  Color = ["+ColorUtil.red(getColor()) +
							", "+ColorUtil.green(getColor()))+
							", "+ColorUtil.blue(getColor())+"] "+
				" Size = " + getSize() +
				" speed = "+ getSpeed()+
				" direction = "+getDirection();
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		Point top = new Point((int)getLocationX(), (int)getLocationY()+(getSize()/2));
		Point bottomLeft = new Point((int)getLocationX()-(getSize()/2),(int)getLocationY()-(getSize()/2));
		Point bottomRight = new Point((int)getLocationX()+(getSize()/2), (int)getLocationY()-(getSize()/2));
		
		int [] xPts = new int[] {(int) top.getX(), (int) bottomLeft.getX(), (int) bottomRight.getX()};
		int [] yPts = new int[] {(int) top.getY(), (int) bottomLeft.getY(), (int)bottomRight.getY()};
		g.fillPolygon(xPts, yPts, 3);
		
	}
	public Point getPostion(){
		Point p = new Point((int)getLocationX(), (int)getLocationY());
		return p;
	}

	public boolean collidesWith(GameObject other) {
		// TODO Auto-generated method stub
				double p1x = getLocationX();
				double p2x = getLocationX()+getSize();
				double p3x = getLocationX();
				double p4x = getLocationX()+getSize();
				double p1y = getLocationY();
				double p2y = getLocationY();
				double p3y = getLocationY()+getSize();
				double p4y = getLocationY()+getSize();
				
				Animals animal = (Animals) other;
				double a1x = animal.getLocationX();
				double a2x = animal.getLocationX()+animal.getSize();
				double a3x = animal.getLocationX();
				//double a4x = animal.getLocationX()+getSize();
				double a1y = animal.getLocationY();
				//double a2y = animal.getLocationY();
				double a3y = animal.getLocationY()+animal.getSize();
				//double a4y = animal.getLocationY()+animal.getSize();

		return (p1x > a1x && p1x < a2x) && (p1y > a1y && p1y < a3y) ||
				(p2x > a1x && p2x < a2x) && (p2y > a1y && p2y < a3y) ||
				(p3x > a1x && p3x < a2x) && (p3y > a1y && p3y < a3y) ||
				(p4x > a1x && p4x < a2x) && (p4y > a1y && p4x < a3x);
				
	}
	public void handleCollision(GameObject other, GameWorld gw) {
		// TODO Auto-generated method stub
		gw.catPopulate();
		
	}
	

}
