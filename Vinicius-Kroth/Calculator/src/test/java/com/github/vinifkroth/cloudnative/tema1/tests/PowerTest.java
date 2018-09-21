package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.model.Power;


public class PowerTest {

	@Test
	public void testPowerRoundPositiveNumbers() {
		Power power = new Power(10, 2.0);
		assertEquals(100.0, power.calculate(), 0.01);
	}
	
	@Test
	public void testPowerRoundFractionedNumbers() {
		Power power = new Power(10, 2.5);
		assertEquals(316.22, power.calculate(), 0.01);
	}
	
	@Test
	public void testPowerRoundNegativeBase() {
		Power power = new Power(-10, 2.0);
		assertEquals(100.0, power.calculate(), 0.01);
	}
	
	@Test
	public void testPowerRoundNegativeExpoent() {
		Power power = new Power(10, -2.0);
		assertEquals(0.01, power.calculate(), 0.01);
	}
	
	@Test
	public void testPowerNegativeFractionedExpoent() {
		Power power = new Power(10, -2.5);
		assertEquals(0.00316, power.calculate(), 0.01);
	}
}
