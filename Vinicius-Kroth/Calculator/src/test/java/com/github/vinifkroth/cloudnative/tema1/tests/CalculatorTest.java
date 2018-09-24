package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.exception.InvalidOperationException;
import com.github.vinifkroth.cloudnative.tema1.model.Operation;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

public class CalculatorTest {
	Calculator calculator;

	@Before
	public void createCalculator() {
		calculator = new Calculator();
	}

	@Test
	public void testAdition() throws Exception {
		assertEquals(100.0, calculator.calculate(10, 90.0, "+"), 0.0);
	}

	@Test
	public void testSubtraction() throws Exception {
		assertEquals(-5, calculator.calculate(5, 10, "-"), 0.0);
	}

	@Test
	public void testMultiplication() throws Exception {
		assertEquals(50, calculator.calculate(5, 10, "*"), 0.0);
	}

	@Test
	public void testDivision() throws Exception {
		assertEquals(2, calculator.calculate(1000, 500, "/"), 0.0);
	}

	@Test
	public void testPower() throws Exception {
		assertEquals(1000, calculator.calculate(10, 3, "^"), 0.0);
	}

	@Test(expected = InvalidOperationException.class)
	public void testInvalidOperation() throws Exception {
		assertEquals(1000, calculator.calculate(10, 3, "o"), 0.0);
	}

	@Test
	public void testResultsRecord() throws Exception {
		calculator.calculate(10, 2, "^");
		calculator.calculate(5, 3, "*");
		calculator.calculate(5, 2, "/");

		String results = "";
		for (Operation operation : calculator.getResultsRecord()) {
			results = results + Double.toString(operation.calculate()) + " ";
		}
		assertEquals("100.0 15.0 2.5 ", results);
	}
}
