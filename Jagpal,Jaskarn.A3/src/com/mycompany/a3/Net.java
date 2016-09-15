package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
/**
 * 
 * @author jaskarnjagpal
 * Gameobject that extends the Catchers game object class
 * This class provides a toString method to retrieve 
 * updated information 
 *
 */
public class Net extends Catchers {
	@Override
	public String toString(){
		return("Net: loc = "+getLocationX()+", "+getLocationY()+
				" color = ["+ColorUtil.red(getColor()) +
							", "+ColorUtil.green(getColor()))+
							", "+ColorUtil.blue(getColor())+"] ";
		
	}
	public void draw(Graphics g, Point pCmpRelPrnt)
	{
		int halfSize = getSize()/2;
		g.setColor(getColor());
		g.drawRect((int)getLocationX()-halfSize, (int)getLocationY()-halfSize, getSize(), getSize());
		g.drawRect((int)getLocationX(), (int)getLocationY(), 5, 5);
		g.fillRect((int)getLocationX()-halfSize, (int)getLocationY()-halfSize, getSize(), getSize());
	}


}
