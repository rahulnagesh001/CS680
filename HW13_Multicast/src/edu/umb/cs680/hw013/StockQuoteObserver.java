package edu.umb.cs680.hw013;

import java.util.EventListener;

public interface StockQuoteObserver extends EventListener{
	public void updateStock(StockEvent stockEvent);

}
