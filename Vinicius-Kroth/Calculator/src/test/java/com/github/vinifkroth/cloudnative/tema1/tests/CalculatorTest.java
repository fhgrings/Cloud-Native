package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.exception.InvalidOperationException;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })

public class CalculatorTest {
	@Autowired
	Calculator calculator;

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
}
