package com.github.vinifkroth.cloudnative.tema8.model;

public class Division implements Operation {
	private double firstElement;
	private double secondElement;

	public Division(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		if (secondElement == 0)
			throw new ArithmeticException("The informed divident cannot be zero");
		return firstElement / secondElement;
	}

}
