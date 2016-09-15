package com.mycompany.a3;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.charts.util.ColorUtil;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.table.TableLayout;
import com.codename1.charts.util.*;

@SuppressWarnings("unused")
/**
 * 
 * @author jaskarnjagpal
 * GameWorld class creates and initalizes all game objects to their initial state
 * Game objects are stored in a vevtor calle objectList
 *
 */
class GameWorld extends Observable {
	//private ArrayList<GameObject> objectList;
	private GameObjectsCollections objects;
	private ArrayList<Object>observerArray = new ArrayList<Object>();
	private ArrayList<Animals> collisionArr = new ArrayList<Animals>();
	
	private int initCat, initDog, popCat, popDog, totalScore, tick, currentTime;
	private boolean sound;
	private Form form;
	
	private Net net;
	private Dog dog;
	private Cat cat;
	//private Label totalScore, dogsCaptured, catsCaptured, dogsR, catsR;
	private Label soundR, total, catsCap, dogsCap, catsR, dogsR, soundB;
	
	private float newDogNetLocX, newDogNetLocY;
	private float newCatNetLocX, newCatNetLocY;
	private final int HEIGHT = 300;
	private final int WIDTH = 1000;
	ScoreView sc;
	Sounds dogSounds, catsounds, otherSounds;
	Random rand = new Random();
	private BGSound bg;
	
	
	/**
	 * Constructor creates new instance of dogs, cats, and the net
	 */
	public GameWorld()
	{
		objects = new GameObjectsCollections();
		//objectList = new ArrayList<GameObject>();
		total = new Label("total score");
		catsCap = new Label("Cats Captured");
		dogsCap = new Label("Dogs Captured");
		dogsR = new Label("Dogs Remaining");
		catsR = new Label("Cats Remaining");
		soundB = new Label("Sound On/Off");
		dog = new Dog();
		net = new Net();
		cat = new Cat();
		initCat=6;
		initDog=10;
		dogSounds=new Sounds("dog_bark_x.wav");
		catsounds=new Sounds("meow1.wav.wav");
		otherSounds=new Sounds("dog_whine.wav");
		sound = true;
	}
	
	/**
	 * initLayout method creates the initial amount of dogs and cats
	 * method also calls on the toString methods of the gameobjectsuyd
	 */
	public void initLayout()
	{


		catsR.setText("Cats Remaining: "+initCat);
		dogsR.setText("Dogs Remaining: "+initDog);
		totalScore =0;
		total.setText("Total Score: "+totalScore);
		createNet();
		createDog();
		createCat();
		
		printPoints();
		
	}


	/**
	 * method createNet creates an instance of the gameobject net
	 * method assigns the default color as gray and the default size as 100
	 * sets the location of the net within the range of the gameworld
	 */

	public void createNet()
	{
		net.setColor(ColorUtil.GRAY);
		net.setSize(100);
		net.setLoc(getRange(0, WIDTH), getRange(0, HEIGHT));
		//objectList.add(net);
		objects.add(net);
		
	}
	//Helper method to calculate random nummber within bounds
	//returns an int value
	public int getRange(int min, int max)
	{
		return (rand.nextInt((max - min) + min));
	}
	/**
	 * createDog creats an instance of a dog
	 * sets inital dog speed to 5 and initial color to white
	 */
	public void createDog()
	{
		for(int i=0; i<initDog; i++)
		{
			dog = new Dog();
			dog.setSpeed(5);
			dog.setColor(ColorUtil.GREEN);
			dog.setLoc(getRange(0, WIDTH), getRange(0, HEIGHT));
			dog.setSize(rand.nextInt((50-20)+20));
			dog.setDirection(rand.nextInt(360));
			objects.add(dog);
			//objectList.add(dog);
		}
	}
	/**
	 * createCat creates an instance of a cat
	 * sets inital speed to 5 and th initial color to yellow
	 */
	public void createCat()
	{
		for(int i=0; i<initCat; i++){
			cat = new Cat();
			cat.setSpeed(5);
			cat.setColor(ColorUtil.YELLOW);
			cat.setLoc(getRange(0, WIDTH), getRange(0, HEIGHT));
			cat.setSize((rand.nextInt(50-20)+20));
			cat.setDirection(rand.nextInt(360));
			objects.add(cat);
			//objectList.add(cat);
		}
	}
	//method expands the range of the net, as long as the net is within
	//the bounds of the layout
	public void expand()
	{
		int x = net.getSize();
		if(x>=50 && x<1000){
			net.setSize(x+1);
		}
	}
	//method decreases the the size of the net
	public void decrease()
	{
		int x = net.getSize();
		if(x>50){
			net.setSize(x-1);
		}
	}
	public void randomDog()
	{		
		IIterator iterator = objects.getIterator();
		Object curobj;
		while(iterator.hasNext())
		{
			int x = rand.nextInt(iterator.getSize());
			curobj = iterator.objectAt(x);
			if(curobj instanceof Dog)
			{
				newDogNetLocX=(float) ((Dog)curobj).getLocationX();
				newDogNetLocY=(float) ((Dog)curobj).getLocationY();
			}
			iterator.getNext();
		}
		net.setLoc(newDogNetLocX, newDogNetLocY);

		printMap();

		
	}
	public void randomCat()
	{
		IIterator iterator = objects.getIterator();
		Object curobj;
		while(iterator.hasNext())
		{
			int x = rand.nextInt(iterator.getSize());
			curobj = iterator.objectAt(x);
			if(curobj instanceof Cat)
			{
				newCatNetLocX = (float) ((Cat)curobj).getLocationX();
				newCatNetLocY = (float) ((Cat)curobj).getLocationY();
			}
			iterator.getNext();
		}
		net.setLoc(newCatNetLocX, newCatNetLocY);
	
		printMap();
	}

	/**
	 * method checks the bounds of the net and all the animals within those bounds
	 * if an animal is located within the bounds of the net, then that animal is captured
	 * removes that animal from the game field
	 */

	public void scoop(){
		GameObject currObj;
		IIterator iterator = objects.getIterator();
		while(iterator.hasNext())
		{
			currObj = (GameObject) iterator.getNext();
			if(currObj instanceof Animals && currObj.getLocationX()>=(net.getLocationX()-net.getSize()/2)
					&& currObj.getLocationX()<=(net.getLocationX()+net.getSize()/2)
					&& currObj.getLocationY()>=(net.getLocationY()-net.getSize()/2)
					&& currObj.getLocationY()<=(net.getLocationY()+net.getSize()/2)){
				
				if(currObj instanceof Cat){
					System.out.println("Cat has been caught");
					popCat--;
					iterator.remove();
					totalScore = totalScore-10;
					total.setText("Total Score: "+totalScore);
					catsCap.setText("Cats Captured: "+popCat*-1);
					catsR.setText("Cats Remaining: "+(initCat+popCat));
					setChanged();
					notifyObservers();
			
				}
				}else if (currObj instanceof Dog){
					System.out.println("Dog has been caught");
					popDog--;
					iterator.remove();
					if(((Dog)currObj).getScratch()==0){
						totalScore = totalScore+10;
						total.setText("Total Score: "+totalScore);
						dogsCap.setText("Dogs Captured: "+popDog*-1);
						dogsR.setText("Dogs Remaining: "+(initDog+popDog));
						setChanged();
						notifyObservers();
					}
				
				}
			}
			otherSounds.play();
		if(popDog+initDog==0)
		{
			System.out.println("GameOver!");
			System.exit(0);
		}
			notifyObservers();
			printPoints();
			printMap();
		}


		//setChanged();
		//notifyObservers();

	/**
	 * move methods implemented to provide movement functionality of the net
	 */
	
	public void moveRight()
	{
		net.moveRight();
	}
	public void moveUp()
	{
		net.moveUp();
	}
	public void moveDown()
	{
		net.moveDown();
	}
	public void moveLeft()
	{
		net.moveLeft();
	}
	public void healDogs(){
		IIterator iterator = objects.getIterator();
		Object curObj;
		while(iterator.hasNext()){
			curObj = iterator.getNext();
			if(curObj instanceof Dog && ((Dog)curObj).isSelected()){
				((Dog)curObj).setSelected(false);
				((Dog)curObj).resetScratches();
				((Dog)curObj).setSpeed(5);
				((Dog)curObj).setColor(ColorUtil.GREEN);
				notifyObservers();
			}
		}
		printMap();
	}
	/**
	 * method checks to see if there are 2 or more cats on the field
	 * if there are, then a collision occurs and a kitten is produced
	 * if fewer than 2 cats, error message is returned
	 */

	public void catPopulate()
	{
		if(initCat<30)
		{
			cat=new Cat();	
			cat.setSpeed(5);
			cat.setColor(ColorUtil.YELLOW);
			cat.setLoc(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
			cat.setSize((rand.nextInt(50-20)+20));
			cat.setDirection(rand.nextInt(360));
			objects.add(cat);
			initCat++;
			//System.out.println("Cat added!");
			catsounds.play();
			
		}
		setChanged();
		notifyObservers();
			
	}
	/**
	 * if a fight occurs, dog exhibits a scratch
	 * scratch causes the speed of the dog to decrease
	 * also changes the color of the dog
	 */
	public void fight(){
		ArrayList<GameObject>dogList = new ArrayList<GameObject>();
		IIterator iterator = objects.getIterator();
		Object curobj;
		while(iterator.hasNext()){
			curobj = iterator.getNext();
			if(curobj instanceof Dog){
				dogList.add((Dog)curobj);
				
			}
		}
		int temp = rand.nextInt(dogList.size());
		int y = ((Dog)dogList.get(temp)).getScratch();
		if(y<5){
			int speed = ((Dog)dogList.get(temp)).getSpeed();
			((Dog)dogList.get(temp)).setSpeed((speed-1));
			dogList.get(temp).setColor(ColorUtil.MAGENTA);
			((Dog)dogList.get(temp)).setScratch(y+1);
		}
		dogSounds.play();
		setChanged();
		notifyObservers();
	}
	/**
	 * method prints current number of animals on the field as
	 * well as the current score and the animals captured
	 */
	public void printPoints(){

		int x = initCat - popCat;
		int y = initDog - popDog;
		System.out.println("Current Score: "+totalScore);
		System.out.println("Number of Cats: "+(initCat+popCat));
		System.out.println("Number of Dogs: "+(initDog+popDog));
		System.out.println("Number of Cats Captured: "+(popCat)*-1);
		System.out.println("Number of Dogs Captured: "+(popDog)*-1);
	
	
	}
	public void printMap()
	{
		IIterator iterator = objects.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.getNext().toString());
		}
	}
	public void tick(double timeRate)
	{
		tick= tick+1;
		IIterator iterator = objects.getIterator();
		Object currObj;
		while(iterator.hasNext()){
			currObj = iterator.getNext();
			if(currObj instanceof Animals){
				((Animals)currObj).move(timeRate);
			}
		}
		setChanged();
		notifyObservers();
		collision();
	}
	public void collision(){
		Object a;
		Object b;
		int i;
		IIterator iter = objects.getIterator();
		while(iter.hasNext()){
			a = iter.getNext();
			if(a instanceof Dog){
				Dog dog = (Dog) a;
				IIterator iter2 = objects.getIterator();
				while(iter2.hasNext()){
					b = iter2.getNext();
					if(b instanceof Cat){
						Cat cat = (Cat)b;
						if(dog.collidesWith(cat) && collisionCheck(dog) == false){
							dog.handleCollision(dog, this);
							addCollision(dog);
						}
					}
				}
			}
			if(a instanceof Cat){
				Cat cat1 = (Cat) a;
				IIterator iter2 = objects.getIterator();
				while(iter2.hasNext()){
					b = iter2.getNext();
					if(b instanceof Cat){
						Cat cat2 = (Cat) b;
						if(cat1.collidesWith(cat2) && collisionCheck(cat1)==false){
							currentTime = tick;
							cat1.toString();
							cat2.toString();
							cat1.handleCollision(cat1, this);
							addCollision(cat1);
							addCollision(cat2);
						}
					}
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	public boolean collisionCheck(Animals c){
		for(int i=0; i<collisionArr.size(); i++){
			if(collisionArr.get(i)==c){
				return true;
			}
		}
		return false;
	}
	public void addCollision(Animals cat){
		collisionArr.add(cat);
	}
	/**
	 * @param none
	 * @return void
	 * 
	 */
	public void quit()
	{
		Label quitLabel = new Label("Are you sure you want to quit? Y/N");
		form.add(quitLabel);
		final TextField myTextField=new TextField();
		form.add(myTextField);
		form.show();
		myTextField.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String command = myTextField.getText().toString();
				if(command.equalsIgnoreCase("y") ||command.equalsIgnoreCase("yes"))
					System.exit(0);
				else
					return;
			}
				
			
		});
	
		
	}

	public int getTotalScore()
	{
		return totalScore;
	}
	public int getCatsR()
	{
		return initCat+popCat;
	}
	public int getDogsR()
	{
		return initDog+popDog;
	}
	public int getCatsC()
	{
		return (popCat)*-1;
	}
	public int getDogsC()
	{
		return (popDog)*-1;
	}
	
	public void setSound(boolean on)
	{
		if(on){
			sound=true;
			System.out.println("Sound ON");
		}else{
			sound=false;
			System.out.println("Sound OFF");
		}
	}
	public boolean getSound(){
		return sound;
	}
	public GameObjectsCollections getGameObjectCollection(){
		return objects;
	}
	

}
