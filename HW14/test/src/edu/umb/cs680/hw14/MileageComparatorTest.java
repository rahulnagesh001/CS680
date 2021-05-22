package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;


import org.junit.jupiter.api.Test;

class MileageComparatorTest {

 LinkedList<Car> carList = new LinkedList<Car>();
	
        @Test
        void car1Check() {
        	Car car1 = new Car("Ford", "F3", 2018, 33, 60000);
    		Car car2 = new Car("Mustang", "M2", 2011, 30, 90000);
		carList.add(car1);
		carList.add(car2);
		Collections.sort(carList,(Car car0, Car car01) -> car01.getMileage()-car0.getMileage());
		assertEquals(car1, carList.get(0));
		assertEquals(car2, carList.get(1));
	}
	}
	



