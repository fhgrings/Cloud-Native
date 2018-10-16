package com.github.vinifkroth.cloudnative.tema8.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.vinifkroth.cloudnative.tema8.exception.InvalidOperationException;
import com.github.vinifkroth.cloudnative.tema8.model.*;
import com.google.inject.Singleton;

@Singleton
public class Calculator {
	private List<Operation> resultsRecord;
	private Map<String, Class<Operation>> operations;

	public Calculator() {
		this.resultsRecord = new ArrayList<>();
		Map map = new HashMap<String, Class<Operation>>();
		map.put("+", Addition.class);
		map.put("*", Multiplication.class);
		map.put("/", Division.class);
		map.put("^", Power.class);
		map.put("-", Subtraction.class);
		this.operations = map;

	}

	public double calculate(double firstElement, double secondElement, String operator)
			throws InvalidOperationException, ReflectiveOperationException {
		
		Class<Operation> operationClass = operations.get(operator);
		if (operationClass == null) {
			throw new InvalidOperationException("Invalid operation selected");
		}
		Operation operation = operationClass.getConstructor(double.class, double.class).newInstance(firstElement,
				secondElement);
		resultsRecord.add(operation);
		return operation.calculate();
	}

	public List<Operation> getResultsRecord() {
		return resultsRecord;
	}
}
