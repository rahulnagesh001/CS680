package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable {

	Map<String, Float> map = new HashMap<String, Float>();

	void changeQuote(String t, float q) {
		map.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t, q));
	}

	public static void main(String[] args) {
		System.out.println("StockQuoteObservable class has been Run");
	}
}
