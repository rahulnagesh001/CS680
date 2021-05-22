package edu.umb.cs680.hw13;

import java.util.Observable;
import java.util.Observer;

public class PieChartObserver implements Observer {

	

	public void update(Observable o, Object obj) {
		if (obj instanceof StockEvent) {
			StockEvent stockEvent = (StockEvent) obj;
			System.out.print("PieChart of StockEvent: " + stockEvent.getTicker() + " " + stockEvent.getQuote());
		} else if (obj instanceof DJIAEvent) {
			DJIAEvent djiaEvent = (DJIAEvent) obj;
			System.out.print("PieChart of DJIAEvent: " + djiaEvent.getDjia());
		}
	}

	public static void main(String[] args) {
		System.out.println("PiechartObserver class has been Run");
	}
}