package edu.umb.cs680.hw013;

import java.util.EventObject;

@SuppressWarnings("serial")
public class DJIAEvent extends EventObject {
	float quote;

	public DJIAEvent(Object source) {
		super(source);
	}

}
