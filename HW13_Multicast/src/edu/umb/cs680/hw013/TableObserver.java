package edu.umb.cs680.hw013;
public class TableObserver implements DJIAQuoteObserver, StockQuoteObserver
	{
	
	public TableObserver() {
		super();
		}
	
	@Override
	public void updateStock(StockEvent stockEvent) {
		System.out.print("Updating Table for StockEvent quote value: ");
		
		}

	@Override
	public void updateDJIA(DJIAEvent bondEvent) {
		System.out.print("Updating Table for DJIA quote value: ");
		
		}

}
