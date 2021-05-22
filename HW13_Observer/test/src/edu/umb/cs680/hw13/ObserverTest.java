package edu.umb.cs680.hw13;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.DJIAQuoteObservable;
import edu.umb.cs680.hw13.PieChartObserver;
import edu.umb.cs680.hw13.StockQuoteObservable;
import edu.umb.cs680.hw13.TableObserver;
import edu.umb.cs680.hw13.ThreeDObserver;

class ObserverTest {
	
	PieChartObserver PiechartObserver = new PieChartObserver();
	TableObserver TableObserver = new TableObserver();
	ThreeDObserver THREEDObserver = new ThreeDObserver();
	DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
	StockQuoteObservable stockObserver = new StockQuoteObservable();
	
		@Test
		void verifyDija() {
			
			djiaObserver.addObserver(PiechartObserver);
			djiaObserver.addObserver(TableObserver);
			djiaObserver.addObserver(THREEDObserver);
			djiaObserver.changeQuote(100);
			djiaObserver.changeQuote(200);
			
		}
		
		@Test
		void verifyStock() {
			
			stockObserver.addObserver(PiechartObserver);
			stockObserver.addObserver(TableObserver);
			stockObserver.addObserver(THREEDObserver);
			stockObserver.changeQuote("rtp", 10);
			stockObserver.changeQuote("rtp1", 27);
		
			
		}
		
	
}
