package com.mycompany.a2;

public class Catchers extends GameObject implements IGuidable{
	/**
	 * 
	 */
	public void moveUp(){
		float x = getLocationX();
		float y = getLocationY();
		y++;
		if(y<1000-(getSize()/2)){
			setLocation(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveDown(){
		float x = getLocationX();
		float y = getLocationY();
		y--;
		if(y>(getSize()/2)){
			setLocation(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveRight(){
		float x = getLocationX();
		x++;
		float y = getLocationY();
		if(x<1000-(getSize()/2))
		{
			setLocation(x,y);
		}
		
	}
	/**
	 * 
	 */
	public void moveLeft()
	{
		float x = getLocationX();
		x--;
		float y = getLocationY();
		if(x>(getSize()/2)){
			setLocation(x,y);
		}
		
	}


}
