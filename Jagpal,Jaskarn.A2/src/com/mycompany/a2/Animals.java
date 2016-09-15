package com.mycompany.a2;
/**
 * 
 * @author jaskarnjagpal
 * Animal class extends from GameObject and implements the 
 * IMovable interface.
 * The animal class defines the attributes for the dogs and cats
 * Provides accessors and mutators to retrive and alter attributes
 *
 */
public class Animals extends GameObject implements IMovable {
	private int speed;
	private int direction;
	private Dog dog;
	private Cat cat;
	
	public Animals(){
		
	//Does nothing
	}
	public int getDogColor()
	{
		return dog.getColor();
	}
	public int getCatColor()
	{
		return cat.getColor();
	}
	public int getSpeed()
	{
		return speed;
	}
	public void setSpeed(int speed)
	{
		this.speed=speed;
	}
	public int getDirection()
	{
		return direction;
	}
	public void setDirection(int direction)
	{
		this.direction=direction;
	}
	//
	public void move()
	{
		float deltaX = (float)Math.cos(90-getDirection())*getSpeed();
		float deltaY = (float)Math.sin(90-getDirection())*getSpeed();
		float newLocationX = (getLocationX()+deltaX);
		float newLocationY = (getLocationY()+deltaY);
		
		if(newLocationX < 1024-(this.getSize()/2) && newLocationX>(this.getSize()/2)
				&& newLocationY<1024-(this.getSize()/2) && newLocationY >(this.getSize()/2))
		{
			setLocation(newLocationX, newLocationY);
		}
	}
	
	

}
