package com.github.vinifkroth.cloudnative.tema1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.vinifkroth.cloudnative.tema1.exception.InvalidOperationException;
import com.github.vinifkroth.cloudnative.tema1.model.*;

@Component
public class Calculator {
	private List<Operation> resultsRecord;

	@Autowired
	public Calculator() {
		resultsRecord = new ArrayList<>();
	}

	public double calculate(double firstElement, double secondElement, String operation) throws Exception {
		switch (operation) {
		case "*":
			Multiplication multiplication = new Multiplication(firstElement, secondElement);
			resultsRecord.add(multiplication);
			return multiplication.calculate();
		case "/":
			Division division = new Division(firstElement, secondElement);
			resultsRecord.add(division);
			return division.calculate();
		case "^":
			Power power = new Power(firstElement, secondElement);
			resultsRecord.add(power);
			return power.calculate();
		case "+":
			Addition addition = new Addition(firstElement, secondElement);
			resultsRecord.add(addition);
			return addition.calculate();
		case "-":
			Subtraction subtraction = new Subtraction(firstElement, secondElement);
			resultsRecord.add(subtraction);
			return subtraction.calculate();
		default:
			throw new InvalidOperationException("INVALID_OPERATION_EXCEPTION");
		}

	}

	public List<Operation> showRecord() {
		return resultsRecord;
	}
}
