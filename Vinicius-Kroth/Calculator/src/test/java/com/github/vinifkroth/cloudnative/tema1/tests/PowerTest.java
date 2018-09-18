package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.model.Power;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })

public class PowerTest {

	@Autowired
	Power power;

	@Test
	public void testPowerRoundPositiveNumbers() {
		assertEquals(100.0, power.calculate(10, 2.0), 0.01);
	}
	
	@Test
	public void testPowerRoundFractionedNumbers() {
		assertEquals(316.22, power.calculate(10, 2.5), 0.01);
	}
	
	@Test
	public void testPowerRoundNegativeBase() {
		assertEquals(100.0, power.calculate(-10, 2.0), 0.01);
	}
	
	@Test
	public void testPowerRoundNegativeExpoent() {
		assertEquals(0.01, power.calculate(10, -2.0), 0.01);
	}
	
	@Test
	public void testPowerNegativeFractionedExpoent() {
		assertEquals(0.00316, power.calculate(10, -2.5), 0.01);
	}
}
