package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.DVDPlayer;
import edu.umb.cs680.hw06.DrawerClosedNotPlaying;
import edu.umb.cs680.hw06.State;

public class DVDPlayer {
	
	private static DVDPlayer dvd;
	private static State state;

	private DVDPlayer() {
		
	}

	public static DVDPlayer getInstance() {
		if (dvd == null) {
			dvd = new DVDPlayer();
			state = DrawerClosedNotPlaying.getInstance();
		}
		return dvd;
	}
	
	public void changeState(State state) {
		DVDPlayer.state = state;
	}
	
	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}
	
	public void playButtonPushed() {
		state.playButtonPushed();
		
	}
	
	public void stopButtonPushed() {
		state.stopButtonPushed();
		
	}
	public void open() {
		System.out.println("Open");

	}

	public void close() {
		System.out.println("Close");

	}

	public void play() {
		System.out.println("Play");

	}
	
	public void stop() {
		System.out.println("Stop");

	}

}
