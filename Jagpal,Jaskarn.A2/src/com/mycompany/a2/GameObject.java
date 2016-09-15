package com.mycompany.a2;

import java.util.Vector;
/**
 * 
 * @author jaskarnjagpal
 * Abstract gameobject class defines functionality for the gameobjects
 * that will be implemented into the game world
 */

public abstract class GameObject {
	private Vector<Float> location;
	private int size;
	private int color;
	
	//Constructor for the GameObject abstract class
	//initiates location and sets the default value
	public GameObject()
	{
		location = new Vector<Float>();
		location.setSize(2);
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
	public float getLocationX()
	{
		return location.get(0);
	}
	public float getLocationY()
	{
		return location.get(1);
	}
	public void setLocation(float x, float y)
	{
		location.set(0, x);
		location.set(1, y);
	}
	

}
