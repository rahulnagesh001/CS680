package edu.umb.cs680.hw06;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw06.DrawerClosedPlaying;

public class DrawerClosedPlayingTest {
	
	private static DrawerClosedPlaying drawerclosed_playing = DrawerClosedPlaying.getInstance();
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void test_OpenCloseButtonPushed() {
		drawerclosed_playing.openCloseButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "PlayStopOpen");
	}

	@Test
	public void test_PlayButtonPushed() {
		drawerclosed_playing.playButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "Systemisplaying");
	}

	@Test
	public void test_StopButtonPushed() {
		drawerclosed_playing.stopButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "StopStopped");
	}

}
