package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void divide7By0(){
		Calculator cut = new Calculator();
		try{
		cut.divide(7, 0);
		fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
		assertEquals("division by zero",
		ex.getMessage() );
		}
	}
	
	@Test
	public void multiply7By7(){
			Calculator cut = new Calculator();
			float expected = (float)49;
			float actual = cut.multiply(7, 7);
			assertEquals(actual, expected);
}
}