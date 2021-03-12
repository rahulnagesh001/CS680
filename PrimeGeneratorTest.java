package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	void test1to10() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		assertArrayEquals( expectedPrimes,
		gen.getPrimes().toArray());
	}
   
	@Test
	void testminus10to100() {
		Long[] expectedPrimes = {};
		PrimeGenerator gen = new PrimeGenerator(-10, 100);
		gen.generatePrimes();
		assertArrayEquals(expectedPrimes,
		gen.getPrimes().toArray());
	}
	
	@Test
	void test90to10() {
		Long[] expectedPrimes = {};
		PrimeGenerator gen = new PrimeGenerator(90, 10);
		gen.generatePrimes();
		assertArrayEquals(expectedPrimes,
		gen.getPrimes().toArray());
	}
	
}
