package com.github.vinifkroth.cloudnative.tema3.model;

public class Multiplication implements Operation {
	private double firstElement;
	private double secondElement;

	public Multiplication(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return firstElement * secondElement;
	}

}
