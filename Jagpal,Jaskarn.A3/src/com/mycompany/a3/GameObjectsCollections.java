package com.mycompany.a3;

import java.util.Vector;

public class GameObjectsCollections implements ICollection {
	private Vector<GameObject> collection;
	private int size;
	
	public GameObjectsCollections(){
		collection = new Vector<GameObject>();
	}

	public void add(GameObject o) {
		// TODO Auto-generated method stub
		collection.addElement(o);
		size++;
	}
	public Vector<GameObject> getObjects(){
		return collection;
	}

	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjectIterator();
	}


	private class GameObjectIterator implements IIterator{
		private int curIndex;
		public GameObjectIterator(){
			curIndex = -1;
		}
		public boolean hasNext(){
			if(collection.size() <=0){
				return false;
			}
			return curIndex != collection.size() - 1;
		}
		public Object getNext(){
			curIndex++;
			return(collection.elementAt(curIndex));
		}
		public int getIndex(){
			return curIndex;
		}
		public Object objectAt(int i){
			return collection.get(i);
		}
		public void remove() {
			// TODO Auto-generated method stub
			collection.remove(curIndex);
			size--;
		}
		public int getSize() {
			// TODO Auto-generated method stub
			return size;
		}
	

	}




}
