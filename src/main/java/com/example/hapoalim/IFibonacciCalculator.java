package com.example.hapoalim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class IFibonacciCalculator {

	@Autowired
	private IFibonacciRepository fr;

	public IFibonacciCalculator() {
	}

	long sum = 0;
	long f1 = 1;
	long f2 = 1;
	int lastCalculatedIndex = 2;

	public long calculateByIndex(int index) {
		
		// range check
		if (index <= 0 || index > 20)
			return 0;
		
		// instantiate fibonacci sequence
		if (fr.fibValues.get(1) == null || fr.fibValues.get(2) == null) {
			fr.add(1, 1);
			fr.add(2, 1);
		}

		// calculate fibonacci value by index and store all values calculated
		for (int i = lastCalculatedIndex; i < index; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
			fr.add(++lastCalculatedIndex, sum);
		}
		return f2;
	}

}
