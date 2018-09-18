package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.model.Addition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AdditionTest {
	@Autowired
	Addition addition;

	@Test
	public void testAddingRoundPositiveRoundNumbers() {
		assertEquals(10.0, addition.calculate(2.0, 8.0), 0.01);
	}
	
	@Test
	public void testAddingFractionedPositiveRoundNumbers() {
		assertEquals(2.5, addition.calculate(1.5, 1.0), 0.01);
	}


	@Test
	public void testAddingRoundNegativeNumbers() {
		assertEquals(-2.0, addition.calculate(-10, 8), 0.01);
	}
	
	@Test
	public void testAddingFractionedNegativeNumbers() {
		assertEquals(-1.1, addition.calculate(-2.8, 1.7), 0.01);
	}

}
