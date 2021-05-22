package edu.umb.cs680.hw13;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable {

	float quote;

	void changeQuote(float q) {
		this.quote = q;
		setChanged();
		notifyObservers(new DJIAEvent(q));
	}

	public static void main(String[] args) {
		System.out.println("DJIAQuoteObservable class has been Run");
	}
}
