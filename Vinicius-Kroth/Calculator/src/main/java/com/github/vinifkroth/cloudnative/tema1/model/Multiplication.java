package com.github.vinifkroth.cloudnative.tema1.model;

import org.springframework.lang.NonNull;

public class Multiplication implements Operation {
	@NonNull
	private double firstElement;
	@NonNull
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
