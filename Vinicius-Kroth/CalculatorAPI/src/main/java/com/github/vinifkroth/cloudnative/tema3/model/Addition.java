package com.github.vinifkroth.cloudnative.tema3.model;

public class Addition implements Operation {
	private double firstElement;
	private double secondElement;

	public Addition(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		return firstElement + secondElement;
	}

}
