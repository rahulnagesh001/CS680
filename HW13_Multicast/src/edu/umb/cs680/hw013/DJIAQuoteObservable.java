package edu.umb.cs680.hw013;

import java.util.ArrayList;
import java.util.EventListener;

public class DJIAQuoteObservable {
	
ArrayList<DJIAQuoteObserver> DJIAOb = new ArrayList<>();
	
	public void addEventListner(EventListener el){
		DJIAOb.add((DJIAQuoteObserver) el);
	}
	public void notifyObservers(DJIAEvent dj){
		for(int i=0;i<DJIAOb.size();i++){
			DJIAOb.get(i).updateDJIA(new DJIAEvent(dj));	
		}
	}

}
