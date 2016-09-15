package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
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


}
