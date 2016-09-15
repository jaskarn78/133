package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

/**
 * Dog is a gameObject that extends Animals
 * This class provides methods for the scratch function
 * as well as a toString method
 * @author jaskarnjagpal
 *
 */
public class Dog extends Animals {
	private int scratch;
	
	//Everytime a fight occurs, a random dog gets scratched
	//the speed of dog is decreased and color is changed
	public int getScratch(){
		return scratch;
	}
	public void setScratch(int scratch)
	{
		this.scratch=scratch;
	}
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

}
