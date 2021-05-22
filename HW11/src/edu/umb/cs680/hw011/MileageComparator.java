package edu.umb.cs680.hw011;

import java.util.*;

public class MileageComparator implements Comparator<Car>{

	public int compare(Car car1, Car car2){

		return (int) (car2.getMileage()-car1.getMileage());
	}

}
