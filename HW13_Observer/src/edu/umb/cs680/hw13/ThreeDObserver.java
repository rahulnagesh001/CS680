package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

public class ThreeDObserver implements Observer {

	
	
	
	public void update(Observable o, Object obj) {
		if (obj instanceof StockEvent) {
			StockEvent stockEvent = (StockEvent) obj;
			System.out.print("3D of StockEvent: " + stockEvent.getTicker() + " " + stockEvent.getQuote());
		} else if (obj instanceof DJIAEvent) {
			DJIAEvent djiaEvent = (DJIAEvent) obj;
			System.out.print("3D of DJIAEvent: " + djiaEvent.getDjia());
		}
	}

	public static void main(String[] args) {
		System.out.println("ThreeDObserver class has been Run");
	}
}