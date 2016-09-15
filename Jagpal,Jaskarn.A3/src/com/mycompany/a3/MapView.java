package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

public class MapView extends Container implements Observer{
	private GameWorld gw;
	private GameObjectsCollections goc;
	@SuppressWarnings("unused")
	private Graphics myGraphics;
	
	public MapView(GameWorld gw){
		this.gw = gw;
		this.goc = gw.getGameObjectCollection();
	}
	
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		gw = (GameWorld)observable;
		goc = gw.getGameObjectCollection();
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		myGraphics = g;
		
		Point p = new Point(getX(), getY());
		IIterator iter = goc.getIterator();
		GameObject nxt;
		while(iter.hasNext())
		{
			 nxt = (GameObject) iter.getNext();
			if(nxt instanceof Cat){
				Cat cat = (Cat)nxt;
				cat.draw(g, p);
			}
			if(nxt instanceof Dog){
				Dog dog = (Dog)nxt;
				dog.draw(g, p);
			}
			if(nxt instanceof Net){
				Net net = (Net)nxt;
				net.draw(g, p);
			}
		}
	}
	public void pointerPressed(int x, int y){
		x = x-getParent().getAbsoluteX();
		y = y- getParent().getAbsoluteX();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator iter = goc.getIterator();
		GameObject nxt;
		while(iter.hasNext())
		{
			nxt = (GameObject)iter.getNext();
			if(nxt instanceof Dog)
			{
				if(((Dog) nxt).contains(pPtrRelPrnt, pCmpRelPrnt)){
					((Dog)nxt).setSelected(true);
				}else{
					((Dog)nxt).setSelected(false);
				}

			}
			System.out.println("Pointer pressed on locatino");
			repaint();
		}
	}

	
}
