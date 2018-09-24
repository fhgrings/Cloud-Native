package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.model.Multiplication;

public class MultiplicationTest {
	@Test
	public void testMultiplicationWithPositiveNumbers() {
		Multiplication multiplication = new Multiplication(12, 10.0);
		assertEquals(120, multiplication.calculate(), 0.01);
	}

	@Test
	public void testMultiplicationWithNegativeNumbers() {
		Multiplication multiplication = new Multiplication(-12, 10.0);
		assertEquals(-120, multiplication.calculate(), 0.01);
	}

}
