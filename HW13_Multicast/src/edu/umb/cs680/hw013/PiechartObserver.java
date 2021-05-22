package edu.umb.cs680.hw013;

public class PiechartObserver implements DJIAQuoteObserver,StockQuoteObserver{
	
	public PiechartObserver(){
		super();
	}
	
	@Override
	public void updateStock(StockEvent stockEvent) {
		System.out.print("Updating Piechart for StockEvent quote value: ");
		
	}


	@Override
	public void updateDJIA(DJIAEvent bondEvent) {
		System.out.print("Updating Piechart for DJIA quote value: ");

		
	}

}
