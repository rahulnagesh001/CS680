package  edu.umb.cs680.hw02;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

	@Test
	public void add5and4()
	{
		Calculator cut = new Calculator();
		float actual = cut.add(5,4);
		float expected = 9;
		assertEquals(actual, expected);
	}
	
	@Test
	public void sub8By9()
	{
		Calculator cut = new Calculator();
		float actual = cut.sub(8,9);
		float expected = 1;
		assertEquals(actual, expected);
	}
	
	@Test
	public void multiply9By4()
	{
		Calculator cut = new Calculator();
		float actual = cut.multiply(9,4);
		float expected = 36;
		assertEquals(actual, expected);
	}

	@Test
	public void divide6By3()
	{
		Calculator cut = new Calculator();
		float expected = 2f;
		float actual = cut.divide(6f,3f);
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void divide8By0()
	{
		Calculator cut = new Calculator();
		Assertions.assertThrows(IllegalArgumentException.class, () -> cut.divide(8, 0));
	}
}	