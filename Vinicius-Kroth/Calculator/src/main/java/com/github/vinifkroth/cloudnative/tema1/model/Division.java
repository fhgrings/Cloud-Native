package com.github.vinifkroth.cloudnative.tema1.model;

public class Division implements Operation {

	@Override
	public double calculate(double firstElement, double secondElement) {
		if (secondElement == 0)
			throw new ArithmeticException("DIVIDENT_CANT_BE_ZERO");
		return firstElement / secondElement;
	}

}
