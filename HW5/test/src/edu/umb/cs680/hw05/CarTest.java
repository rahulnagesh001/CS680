package edu.umb.cs680.hw05;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;

public class CarTest {	
	private String[] CarToStringArray(Car c){
		String[] carInfo = 
			{ 
				c.getMake(), c.getModel(), Integer.toString(c.getYear()) 
			};
		return carInfo;
	}	
	
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 2018);
		assertArrayEquals(expected, CarToStringArray(actual));
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear_NotEqual() {
		String[] expected = {"Cadillac", "123", "1991"};
		Car actual = new Car("RR", "phtm", 1980);
		assertNotEquals(expected, CarToStringArray(actual));
	}	
}
		
