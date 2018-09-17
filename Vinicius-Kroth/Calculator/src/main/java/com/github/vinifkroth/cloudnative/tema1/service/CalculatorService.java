package com.github.vinifkroth.cloudnative.tema1.service;

import java.util.List;

public class CalculatorService {

	private double firstNumber;
	private double secondNumber;
	private List<Double> resultsRecord;

	public CalculatorService() {
	}

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public double addition() {
		return addToRecord(firstNumber + secondNumber);
	}

	public double subtraction() {
		return addToRecord(firstNumber - secondNumber);
	}

	public double multiplication() {
		return addToRecord(firstNumber * secondNumber);
	}

	public double division() {
		return addToRecord(firstNumber * secondNumber);
	}

	public double power() {
		return addToRecord(Math.pow(firstNumber, secondNumber));
	}

	public double addToRecord(double result) {
		resultsRecord.add(result);
		return result;
	}
}
