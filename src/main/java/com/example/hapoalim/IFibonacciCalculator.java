package com.example.hapoalim;

public class IFibonacciCalculator {
	
	public long calculateByIndex(int index) {
		long sum = 0;
		long f1 = 1;
		long f2 = 1;
		
		if (index <= 0 || index > 20)
			return 0;
		
		for (int i = 2; i < index; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		return f2;
	}

}
