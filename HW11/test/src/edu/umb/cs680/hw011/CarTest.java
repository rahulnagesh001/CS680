package edu.umb.cs680.hw011;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {
	
ArrayList<Car> usedCars = new ArrayList<Car>();
	
	@Test
	public void MilageComparatorTest() {
		ArrayList<Float> actual = new ArrayList<>();
		ArrayList<Float> expected = new ArrayList<>();
		usedCars.add(new Car("Honda(A)",2010, 8000, 4000f));
		usedCars.add(new Car("Jeep(B)", 2013, 7000, 6000f));
		usedCars.add(new Car("Volkswagen(C)", 2015, 10000, 7000f));
		usedCars.add(new Car("Toyota(E)",2018,7000,7000f));
		
		Collections.sort(usedCars, new MileageComparator()); 
		for(Car c : usedCars){
			actual.add(c.getMileage());
		}
		
		expected.add(7000f);
		expected.add(7000f);
		expected.add(6000f);
		expected.add(4000f);
		assertEquals(actual, expected);	
	}
	
	@Test
	public void PriceComparatorTest(){
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		usedCars.add(new Car("Honda(A)",2010, 8000, 4000f));
		usedCars.add(new Car("Jeep(B)", 2013, 7000, 6000f));
		usedCars.add(new Car("Volkswagen(C)", 2015, 10000, 7000f));
		usedCars.add(new Car("Toyota(E)",2018,7000,7000f));
		
		Collections.sort(usedCars, new PriceComparator()); 
		for(Car c : usedCars){
			actual.add(c.getPrice());
		}
		expected.add(10000);
		expected.add(8000);
		expected.add(7000);
		expected.add(7000);
		assertEquals(actual, expected);	
	}
	
	@Test
	public void YearComparatorTest(){
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		usedCars.add(new Car("Honda(A)",2010, 8000, 4000f));
		usedCars.add(new Car("Jeep(B)", 2013, 7000, 6000f));
		usedCars.add(new Car("Volkswagen(C)", 2015, 10000, 7000f));
		usedCars.add(new Car("Toyota(E)",2018,7000,7000f));
		
		Collections.sort(usedCars, new YearComparator()); 
		for(Car c : usedCars){
			actual.add(c.getYear());
		}
		expected.add(2010);
		expected.add(2013);
		expected.add(2015);
		expected.add(2018);
		assertEquals(actual, expected);
	}
	
	@Test
	public void DominationComparatorTest() {

		Car car1 = new Car("Honda(A)",2010, 8000, 4000f);
		Car car2 = new Car("Jeep(B)", 2013, 7000, 6000f);
		Car car3 = new Car("Volkswagen(C)", 2015, 10000, 7000f);
		Car car4 = new Car("Toyota(E)",2018,7000,7000f);

		ArrayList<Car> carList = new ArrayList<Car>();
		
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		car4.dominationCount(carList, car4);
		carList.clear();

		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
		car1.dominationCount(carList, car1);
		carList.clear();

		carList.add(car4);
		carList.add(car1);
		carList.add(car3);
		car2.dominationCount(carList, car2);
		carList.clear();

		carList.add(car4);
		carList.add(car1);
		carList.add(car2);
		car3.dominationCount(carList, car3);

		ArrayList<Car> carListToSort = new ArrayList<Car>();
		carListToSort.add(car1);
		carListToSort.add(car2);
		carListToSort.add(car3);
		carListToSort.add(car4);

		
	}
	

}
