package edu.umb.cs680.hw06;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrawerClosedNotPlayingTest {
	
	private static DrawerClosedNotPlaying drawerclosed_notplaying = DrawerClosedNotPlaying.getInstance();
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void test_OpenCloseButtonPushed() {
		drawerclosed_notplaying.openCloseButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "OpenOpen");
		
	}

	@Test
	public void test_PlayButtonPushed() {
		drawerclosed_notplaying.playButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "ClosePlay");
		
	}

	@Test
	public void test_StopButtonPushed() {
		drawerclosed_notplaying.stopButtonPushed();
		assertEquals(outContent.toString().replaceAll("\\s+", ""), "Alreadystopped");
	}

}
