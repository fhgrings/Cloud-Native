package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.model.Division;

public class DivisionTest {

	@Test
	public void testDivisionPositiveNumbers() {
		Division division = new Division(100, 10.0);
		assertEquals(10.0, division.calculate(), 0.01);
	}

	@Test
	public void testDivisionNegativeNumbers() {
		Division division = new Division(-100, -10.0);
		assertEquals(10.0, division.calculate(), 0.01);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivisionByZero() {
		Division division = new Division(-100, 0);
		division.calculate();
	}
}
