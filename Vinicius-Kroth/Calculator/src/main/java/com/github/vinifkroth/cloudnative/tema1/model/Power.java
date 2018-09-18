package com.github.vinifkroth.cloudnative.tema1.model;

public class Power implements Operation {
	@Override
	public double calculate(double firstElement, double secondElement) {
		return Math.pow(firstElement, secondElement);
	}

}
