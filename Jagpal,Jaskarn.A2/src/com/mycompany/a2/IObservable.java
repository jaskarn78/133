package com.mycompany.a2;

public interface IObservable {
	void addObserver (IObserver obs);
	void notifyObservers();

}
