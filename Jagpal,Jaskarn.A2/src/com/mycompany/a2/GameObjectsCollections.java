package com.mycompany.a2;

import java.util.Vector;

public class GameObjectsCollections implements ICollection {
	private Vector<Object> collection;
	private int size;
	
	GameObjectsCollections(){
		collection = new Vector<Object>();
	}

	public void add(Object o) {
		// TODO Auto-generated method stub
		collection.addElement(o);
		size++;
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
			if(curIndex == collection.size()-1){
				return false;
			}
			return true;
		}
		public Object getNext(){
			curIndex++;
			if(curIndex < collection.size())
				return(collection.elementAt(curIndex));
			return null;
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
