package com.mycompany.a3;

public interface IObservable {
	void addObserver (IObserver obs);
	void notifyObservers();

}
