package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.model.Subtraction;

public class SubtractionTest {

	@Test
	public void testSubtractionRoundPositiveNumber() {
		Subtraction subtraction = new Subtraction(10, 11.0);
		assertEquals(-1.0, subtraction.calculate(), 0.01);
	}

	@Test
	public void testSubtractionRoundNegativeNumbers() {
		Subtraction subtraction = new Subtraction(10, -5.0);
		assertEquals(15.0, subtraction.calculate(), 0.01);
	}

	@Test
	public void testSubtractionFractionedPositiveNumber() {
		Subtraction subtraction = new Subtraction(10.3, 11.0);
		assertEquals(-0.7, subtraction.calculate(), 0.01);
	}

	@Test
	public void testSubtractionFractionedNegativeNumbers() {
		Subtraction subtraction = new Subtraction(2.5, -5.0);
		assertEquals(7.5, subtraction.calculate(), 0.01);
	}

}
