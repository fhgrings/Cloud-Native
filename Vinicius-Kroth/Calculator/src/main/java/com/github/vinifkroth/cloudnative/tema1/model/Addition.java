package com.github.vinifkroth.cloudnative.tema1.model;

import org.springframework.lang.NonNull;

public class Addition implements Operation {
	@NonNull
	private double firstElement;
	@NonNull
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
