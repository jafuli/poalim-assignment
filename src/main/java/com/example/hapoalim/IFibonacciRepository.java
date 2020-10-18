package com.example.hapoalim;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class IFibonacciRepository {

	@Autowired
	private IFibonacciCalculator fc;

	protected Map<Integer, Long> fibValues = new HashMap<Integer, Long>();

	public IFibonacciRepository() {
	}

	public long getByIndex(int index) throws invalidInputException {
		if (fibValues.get(index) != null) {
			return fibValues.get(index);
		}
		long value = fc.calculateByIndex(index);
		if (value == 0) {
			throw new invalidInputException();
		}
		return value;

	}

	public void add(int index, long value) {
		fibValues.put(index, value);
	}

}
