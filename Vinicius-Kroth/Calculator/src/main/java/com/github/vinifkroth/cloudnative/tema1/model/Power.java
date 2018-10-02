package com.github.vinifkroth.cloudnative.tema1.model;

public class Power implements Operation {
	double firstElement;
	double secondElement;

	public Power(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return Math.pow(firstElement, secondElement);
	}

}
