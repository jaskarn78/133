package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Cat extends Animals {
	
	public String toString(){
		return("Cat: loc = "+getLocationX() + ", "+getLocationY()+
				",  Color = ["+ColorUtil.red(getColor()) +
							", "+ColorUtil.green(getColor()))+
							", "+ColorUtil.blue(getColor())+"] "+
				" Size = " + getSize() +
				" speed = "+ getSpeed()+
				" direction = "+getDirection();
	}

}
