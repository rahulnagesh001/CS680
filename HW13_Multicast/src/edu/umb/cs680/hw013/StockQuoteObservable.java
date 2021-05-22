package edu.umb.cs680.hw013;

import java.util.ArrayList;
import java.util.EventListener;

public class StockQuoteObservable {
	
ArrayList<StockQuoteObserver> Stock_Q_Obj = new ArrayList<>();
	
	public void addEventListner(EventListener el){
		Stock_Q_Obj.add((StockQuoteObserver) el);
	}
	public void notifyObservers(StockEvent sv){
		for(int i=0;i<Stock_Q_Obj.size();i++){
			Stock_Q_Obj.get(i).updateStock(new StockEvent(sv));	
		}
	}


}
