package edu.umb.cs680.hw01;

import java.util.LinkedList;
import java.util.*;
public class PrimeGenerator {
	protected  long from, to;
	protected LinkedList<Long> primes= new LinkedList<Long>();
		
	PrimeGenerator(long x, long y){		
		from = x;
		to =y;		
	}
		
	public void generatePrimes(){
         if (from <0 || to < 0 || from >= to) {
        	 return;
         }
		 for (long i = from; i <= to; i++) {
			 if (isPrime(i)) {
				  if (i >= 2) {
		            primes.add(i);
		        }
			}
		    }		
	}
	
	public boolean isPrime(long number) {
	    for (int i = 2; i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public LinkedList<Long> getPrimes(){
		return primes; 
		}
	
	public static void main(String[] args) {	
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		System.out.println(gen.getPrimes());
		
		
	}				
}