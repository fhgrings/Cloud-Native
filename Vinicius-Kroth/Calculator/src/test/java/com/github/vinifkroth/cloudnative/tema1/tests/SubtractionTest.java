package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.model.Subtraction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class SubtractionTest {
	@Autowired
	Subtraction subtraction;

	@Test
	public void testSubtractionRoundPositiveNumber() {
		assertEquals(-1.0, subtraction.calculate(10, 11.0), 0.01);
	}
	
	@Test
	public void testSubtractionRoundNegativeNumbers() {
		assertEquals(15.0, subtraction.calculate(10, -5.0), 0.01);
	}
	
	@Test
	public void testSubtractionFractionedPositiveNumber() {
		assertEquals(-0.7, subtraction.calculate(10.3, 11.0), 0.01);
	}
	
	@Test
	public void testSubtractionFractionedNegativeNumbers() {
		assertEquals(7.5, subtraction.calculate(2.5, -5.0), 0.01);
	}

}
