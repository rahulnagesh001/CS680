package edu.umb.cs680.hw011;

import java.util.*;

public class Car {
	private int price;
	private int year;
	private float mileage;
	private ArrayList<Car> cars;
	private String name;
	int dominationCount = 0;
	
	
	public Car(String name,int year,int price,float mileage) {
		
		this.year=year;
		this.price=price;
		this.mileage=mileage;
		this.name=name;
		
	}
	public String toString(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}
	public float getMileage(){
		return this.mileage;
	}
	public int getYear(){
		return this.year;
	}
	public void setCars(ArrayList<Car>cars){
		this.cars=cars;
	}
	
	public int getDominationCount(){
		int count=0;
		for(Car c:this.cars){
			if(this.price==c.getPrice()&&this.year==c.getYear()&&this.mileage==c.getMileage()){
				continue;
				
			}
			if(this.price>=c.getPrice()&&this.year<=c.getYear()&&this.mileage>=c.getMileage()){
				count++;
			}
		}
		return count;
		
	}
	
	public void dominationCount(List<Car> carList, Car car) {

		int price = car.getPrice();
		int year = car.getYear();
		float mileage = car.getMileage();
		for (int i = 0; i < carList.size(); i++) {
			int price1 = carList.get(i).getPrice();
			int year1 = carList.get(i).getYear();
			float mileage1 = carList.get(i).getMileage();
			if (price1 >= price && year1 >= year && mileage1 >= mileage) {
				dominationCount += 1;
				car.setDominationCount(dominationCount);
			}
		}

	}
	public void setDominationCount(int dominationCount) {
		this.dominationCount = dominationCount;
	}

}
