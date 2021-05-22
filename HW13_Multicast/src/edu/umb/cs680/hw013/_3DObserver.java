package edu.umb.cs680.hw013;

public class _3DObserver implements DJIAQuoteObserver,StockQuoteObserver{
	
	public _3DObserver(){
		super();
	}
	
	@Override
	public void updateStock(StockEvent stockEvent) {
		System.out.print("Updating 3D Chart for StockEvent quote value: ");
		
	}

	@Override
	public void updateDJIA(DJIAEvent bondEvent) {
		System.out.print("Updating 3D Chart for DJIA quote value: ");

		
	}

}
