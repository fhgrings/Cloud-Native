package com.github.vinifkroth.cloudnative.tema8.model;

public class Subtraction implements Operation {
	private double firstElement;
	private double secondElement;

	public Subtraction(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return firstElement - secondElement;
	}

}
