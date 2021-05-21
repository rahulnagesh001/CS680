package edu.umb.cs680.hw01;

public class Calculator {
	//multiplication
	public float multiply(float x, float y){
		return x * y;
		}
	//division
		public float divide(float x, float y){
		if(y==0){
			throw new IllegalArgumentException("division by zero");
			}
		return x/y;
		}		
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		Calculator c1 = new Calculator();	
		
	}

}