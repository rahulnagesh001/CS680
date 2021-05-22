package edu.umb.cs680.hw013;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HW11_Multicast_Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void djiaEventTest() {

		DJIAQuoteObservable b = new DJIAQuoteObservable();
		_3DObserver td = new _3DObserver();
		PiechartObserver p = new PiechartObserver();
		TableObserver t = new TableObserver();

		b.addEventListner(t);
		b.addEventListner(p);
		b.addEventListner(td);

		b.notifyObservers(new DJIAEvent(b));
		assertEquals("Updating Table for DJIA quote value: Updating Piechart for DJIA quote value: Updating 3D Chart for DJIA quote value: ", outContent.toString());
		}

	@Test
	public void stockEventTest() {

		StockQuoteObservable s = new StockQuoteObservable();

		TableObserver t = new TableObserver();
		PiechartObserver p = new PiechartObserver();
		_3DObserver td = new _3DObserver();

		s.addEventListner(t);
		s.addEventListner(p);
		s.addEventListner(td);

		s.notifyObservers(new StockEvent(s));
		assertEquals("Updating Table for StockEvent quote value: Updating Piechart for StockEvent quote value: Updating 3D Chart for StockEvent quote value: ", outContent.toString());
		}
	}
