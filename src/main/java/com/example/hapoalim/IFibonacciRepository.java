package com.example.hapoalim;

import java.util.HashMap;
import java.util.Map;

public class IFibonacciRepository {

	private IFibonacciCalculator fc;

	private Map<Integer, Long> fibValues = new HashMap<Integer, Long>();

	public IFibonacciRepository(IFibonacciCalculator fibonacciCalculator) {
		this.fc = fibonacciCalculator;
	}

	public long getByIndex(int index) throws invalidInputException {
		if (fibValues.get(index) != null) {
			return fibValues.get(index);
		}
		long value = fc.calculateByIndex(index);
		if (value == 0) {
			throw new invalidInputException();
		}
		add(index, value);
		return value;

	}

	public void add(int index, long value) {
		fibValues.put(index, value);
	}
}
