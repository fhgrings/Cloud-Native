package com.github.vinifkroth.cloudnative.tema1.service;

import java.util.List;
import java.util.Map;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.github.vinifkroth.cloudnative.tema1.exception.InvalidOperationException;
import com.github.vinifkroth.cloudnative.tema1.model.*;

@Component
public class Calculator {
	@NonNull
	private List<Operation> resultsRecord;
	@NonNull
	private Map<String, Class> operations;

	public double calculate(double firstElement, double secondElement, String operator) throws Exception {
		try {
			Operation operation = (Operation) operations.get(operator).getConstructor(double.class, double.class)
					.newInstance(firstElement, secondElement);
			return operation.calculate();
		} catch (Exception e) {
			throw new InvalidOperationException("INVALID_OPERATION_EXCEPTION");
		}

	}

	public List<Operation> getResultsRecord() {
		return resultsRecord;
	}

	public void setResultsRecord(List<Operation> resultsRecord) {
		this.resultsRecord = resultsRecord;
	}

	public void setOperations(Map<String, Class> operations) {
		this.operations = operations;
	}

}
