package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void test1to10()
	{
		PrimeGenerator gen = new PrimeGenerator(1,10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	@Test
	public void testminus20toplus25()
	{
		PrimeGenerator gen = new PrimeGenerator(-20,25);
		//gen.generatePrimes();
		//Long[] expectedPrimes = {2L, 3L, 5L, 7L}; 

			Assertions.assertThrows(IllegalArgumentException.class, () -> gen.generatePrimes());
		//assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	@Test
	public void test1to22()
	{
		PrimeGenerator gen = new PrimeGenerator(1,22);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	
}

