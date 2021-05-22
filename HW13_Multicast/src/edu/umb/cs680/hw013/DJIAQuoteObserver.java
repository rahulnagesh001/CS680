package edu.umb.cs680.hw013;

import java.util.EventListener;

public interface DJIAQuoteObserver extends EventListener{
	public void updateDJIA(DJIAEvent bondEvent);

}