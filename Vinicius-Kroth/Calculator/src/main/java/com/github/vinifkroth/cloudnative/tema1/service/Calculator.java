package com.github.vinifkroth.cloudnative.tema1.service;

import java.util.ArrayList;
import java.util.List;

import com.github.vinifkroth.cloudnative.tema1.model.*;

public class Calculator {
	private List<Double> resultsRecord;
	private Operation addition, subtraction, multiplication, division, power;

	public Calculator(Addition addition, Subtraction subtraction, Multiplication multiplication, Division division,
			Power power) {
		this.addition = addition;
		this.subtraction = subtraction;
		this.multiplication = multiplication;
		this.division = division;
		this.power = power;
		resultsRecord = new ArrayList<>();
	}

	public double add(double firstElement, double secondElement) {
		return addToRecord(addition.calculate(firstElement, secondElement));
	}

	public double subtract(double firstElement, double secondElement) {
		return addToRecord(subtraction.calculate(firstElement, secondElement));
	}

	public double multiplicate(double firstElement, double secondElement) {
		return addToRecord(multiplication.calculate(firstElement, secondElement));
	}

	public double divide(double firstElement, double secondElement) {
		return addToRecord(division.calculate(firstElement, secondElement));
	}

	public double power(double firstElement, double secondElement) {
		return addToRecord(power.calculate(firstElement, secondElement));
	}

	private double addToRecord(double result) {
		resultsRecord.add(result);
		return result;
	}

	public String showRecord() {
		StringBuilder str = new StringBuilder();
		str.append("Históricos de resultados:\n");
		for (Double result : resultsRecord) {
			str.append(result).append("\n");
		}
		return str.toString();
	}
}
