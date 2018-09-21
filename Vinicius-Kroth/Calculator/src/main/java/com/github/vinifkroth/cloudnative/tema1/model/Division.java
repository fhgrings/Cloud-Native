package com.github.vinifkroth.cloudnative.tema1.model;

import org.springframework.lang.NonNull;

public class Division implements Operation {
	@NonNull
	private double firstElement;
	@NonNull
	private double secondElement;

	public Division(double firstElement, double secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	@Override
	public double calculate() {
		if (secondElement == 0)
			throw new ArithmeticException("DIVIDENT_CANT_BE_ZERO");
		return firstElement / secondElement;
	}

}
