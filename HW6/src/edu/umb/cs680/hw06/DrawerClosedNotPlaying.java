package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.DVDPlayer;
import edu.umb.cs680.hw06.DrawerClosedNotPlaying;
import edu.umb.cs680.hw06.DrawerClosedPlaying;
import edu.umb.cs680.hw06.DrawerOpen;

public class DrawerClosedNotPlaying implements State {
	
	private static DrawerClosedNotPlaying drawerClosedNotPlaying;
	private DVDPlayer dvd;

	private DrawerClosedNotPlaying() {
		dvd = DVDPlayer.getInstance();
	}

	public static DrawerClosedNotPlaying getInstance() {
		if (drawerClosedNotPlaying == null)
			drawerClosedNotPlaying = new DrawerClosedNotPlaying();

		return drawerClosedNotPlaying;
	}
	@Override
	public void openCloseButtonPushed() {
		dvd.open();
		dvd.changeState(DrawerOpen.getInstance());
		System.out.print("Open");

	}

	@Override
	public void playButtonPushed() {
		System.out.print("Close");
		dvd.play();
		dvd.changeState(DrawerClosedPlaying.getInstance());
		
	}

	@Override
	public void stopButtonPushed() {
		System.out.print("Already stopped");
			
	}
}
