package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void onetoten()
	{
		PrimeGenerator gen = new PrimeGenerator(1,10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	@Test
	public void minustoplus()
	{
	
		try {
			PrimeGenerator gen = new PrimeGenerator(-10,10);
			//gen.generatePrimes();
			//Long[] expectedPrimes = {2L, 3L, 5L, 7L}; 
			}catch(Exception e) {
				assertEquals("Negative primes not possible" ,e.getMessage());

				//Assertions.assertThrows(IllegalArgumentException.class, () -> gen.generatePrimes());
			//assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
			}
		}

	@Test
	public void onetotwenty()
	{
		PrimeGenerator gen = new PrimeGenerator(1,20);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	
}

