package com.mycompany.a3;

public interface IIterator {
	boolean hasNext();
	Object getNext();
	
	void remove();
	int getIndex();
	Object objectAt(int i);
	int getSize();

}
