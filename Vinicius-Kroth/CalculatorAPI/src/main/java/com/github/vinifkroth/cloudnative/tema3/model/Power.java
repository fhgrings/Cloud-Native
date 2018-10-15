package com.github.vinifkroth.cloudnative.tema3.model;

public class Power implements Operation {
	private double firstElement;
	private double secondElement;

	public Power(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return Math.pow(firstElement, secondElement);
	}

}
