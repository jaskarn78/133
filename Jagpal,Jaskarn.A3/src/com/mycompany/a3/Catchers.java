package com.mycompany.a3;

public class Catchers extends GameObject implements IGuidable{
	/**
	 * 
	 */
	public void moveUp(){
		double x = getLocationX();
		double y = getLocationY();
		y++;
		if(y<1000-(getSize()/2)){
			setLoc(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveDown(){
		double x = getLocationX();
		double y = getLocationY();
		y--;
		if(y>(getSize()/2)){
			setLoc(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveRight(){
		double x = getLocationX();
		x++;
		double y = getLocationY();
		if(x<1000-(getSize()/2))
		{
			setLoc(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveLeft()
	{
		double x = getLocationX();
		x--;
		double y = getLocationY();
		if(x>(getSize()/2)){
			setLoc(x,y);
		}
		
	}


}
