package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

/**
 * Dog is a gameObject that extends Animals
 * This class provides methods for the scratch function
 * as well as a toString method
 * @author jaskarnjagpal
 *
 */
public class Dog extends Animals implements IDrawable, ISelectable{
	private int scratch;
	private boolean selected;
	//private static GameWorld game;
	//private Sounds fightS;
	//Everytime a fight occurs, a random dog gets scratched
	//the speed of dog is decreased and color is changed

	public int getScratch(){
		return scratch;
	}
	public void setScratch(int scratch)
	{
		this.scratch=scratch;
	}
	Dog(){
		//fightS = new Sounds("dog_bark_x.wav");
		
	}
	//public static void setTarget(GameWorld gw)
	//{
	//	if(game==null)
	//		game=gw;
	//}
	@Override
	//toString method prints all relevant information regarding this gameObject
	public String toString()
	{
		return ("Dog: loc = "+ getLocationX()+","+getLocationY()+
				" color = ["+ColorUtil.red(getColor()) +
								", "+ColorUtil.green(getColor()))+
								", "+ColorUtil.blue(getColor())+"] "+
				" size = "+ getSize()+
				" speed = "+getSpeed()+
				" direction = "+getDirection()+
				" scratches = "+ getScratch();
	}
	

	public void setSelected(boolean select)
	{
		selected = select;
	}
	public boolean isSelected()
	{
		return selected;
	}
	public void resetScratches(){
		scratch=0;
	}

	public boolean collidesWith(GameObject other) {
		// TODO Auto-generated method stub
		boolean result = false;
		double thisCenterX = this.getLocationX()+(getSize()/2);
		double thisCenterY = this.getLocationY()+(getSize()/2);
		
		double otherX = other.getLocationX()+(other.getSize()/2);
		double otherY = other.getLocationY()+(other.getSize()/2);
		
		double dx = thisCenterX - otherX;
		double dy = thisCenterY -otherY;
		double distance = (dx*dx +dy*dy);
		
		int thisRadius = getSize()/2;
		int otherRadius = other.getSize()/2;
		
		int radii = (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		if(distance <= radii){
			result = true;
		}
		return result;
	}
	public void handleCollision(GameObject other, GameWorld gw) {
		// TODO Auto-generated method stub
		gw.fight();
		//fightS.playFight();
		
	}
	public boolean contains(Point p, Point pCmpRelPrnt) {
		double px = getLocationX()-(getSize()/2);
		double py = getLocationY()-(getSize()/2);
		double p2x = getLocationX()-(getSize()/2);
		double p2y = getLocationX()-(getSize()/2);
		
		if(pCmpRelPrnt.getX()>=px && pCmpRelPrnt.getX()<=p2x){
			if(pCmpRelPrnt.getY() >= py && pCmpRelPrnt.getY()<=p2y){
				return true;
				
			}
			
		}
		return false;
	}
	public void draw(Graphics g, Point pCmpRelPrnt)
	{
		g.fillArc((int)getLocationX(),(int)getLocationY(),2*(getSize()/2),2*(getSize()/2), 0, 360);

		if(isSelected()){
			//g.setColor(ColorUtil.LTGRAY);
			g.drawArc((int)getLocationX(),(int)getLocationY(),2*(getSize()/2),2*(getSize()/2), 0, 360);

		}
		else{
			g.fillArc((int)getLocationX(),(int)getLocationY(),2*(getSize()/2),2*(getSize()/2), 0, 360);

			g.setColor(getColor());
		}
	}
	

	

}
