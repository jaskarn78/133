package com.mycompany.a3;

import java.util.Random;

/**
 * 
 * @author jaskarnjagpal
 * Animal class extends from GameObject and implements the 
 * IMovable interface.
 * The animal class defines the attributes for the dogs and cats
 * Provides accessors and mutators to retrive and alter attributes
 *
 */
public abstract  class Animals extends GameObject implements IMovable, ICollider {
	private int speed;
	private int direction;
	private Dog dog;
	private Cat cat;
	private final int HEIGHT = 610;
	private final int WIDTH = 1000;
	Random rand = new Random();
	
	public Animals(){
	
	direction = rand.nextInt((359)+1);
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
	public void reduceSpeed(){
		speed--;
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
	public void move(double timeRate)
	{
		double deltaX = Math.cos(Math.toRadians(90-getDirection()))*getSpeed()*(timeRate/20);
		double deltaY = Math.sin(Math.toRadians(90-getDirection()))*getSpeed()*(timeRate/20);
		double newLocationX = (getLocationX()+deltaX);
		double newLocationY = (getLocationY()+deltaY);
		
		if(newLocationX <WIDTH && newLocationX>0 && newLocationY<HEIGHT &&
				newLocationY>0)
		{
			setLoc(newLocationX, newLocationY);
		}else{
			direction +=180;
			if(direction>=360){
				direction-=360;
			}
		}
		direction+=((rand.nextInt(10)+1)-5);
	}
	public void handleCollision(GameObject other, GameWorld gw) {
		// TODO Auto-generated method stub
		
	}


}
