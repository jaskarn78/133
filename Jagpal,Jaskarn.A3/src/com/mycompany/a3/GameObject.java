package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
/**
 * 
 * @author jaskarnjagpal
 * Abstract gameobject class defines functionality for the gameobjects
 * that will be implemented into the game world
 */

public abstract class GameObject {
	private double locationX, locationY;
	private int size;
	private int color;
	
	//Constructor for the GameObject abstract class
	//initiates location and sets the default value
	public GameObject()
	{
		locationX = 0.0;
		locationY= 0.0;
		size=50;
		color=ColorUtil.BLACK;
	}
	//Accessor method for color
	public int getColor()
	{
		return color;
	}
	//Mutator method for color
	//Method takes an integer value as a
	//parameter. The int value corresponds to a certain color
	//
	public void setColor(int color)
	{
		this.color = color;
	}
	/**
	 * Accessor method to retrieve size
	 * @return int size
	 */
	public int getSize()
	{
		return size;
	}
	/**
	 * 
	 * Mutator method to set the size of each gameObject
	 * @param size
	 */
	public void setSize(int size)
	{
		this.size=size;
	}
	/**
	 * 
	 * @return location has a float value
	 */
	public double getLocationX()
	{
		return Math.round(locationX*100.0)/100.0;
	}
	public double getLocationY()
	{
		return Math.round(locationY*100)/100.0;
	}
	public void setLoc(double newLocationX, double newLocationY)
	{
		setLocation(newLocationX, newLocationY);
	}
	private void setLocation(double newX, double newY)
	{
		this.locationX=newX;
		this.locationY=newY;
	}


	

}
