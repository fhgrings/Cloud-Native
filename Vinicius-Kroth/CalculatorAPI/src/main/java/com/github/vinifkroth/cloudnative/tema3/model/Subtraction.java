package com.github.vinifkroth.cloudnative.tema3.model;

public class Subtraction implements Operation {
	double firstElement;
	double secondElement;

	public Subtraction(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return firstElement - secondElement;
	}

}
