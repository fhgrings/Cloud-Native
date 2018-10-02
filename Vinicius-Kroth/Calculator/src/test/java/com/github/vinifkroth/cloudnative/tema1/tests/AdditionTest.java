package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.github.vinifkroth.cloudnative.tema1.model.Addition;

public class AdditionTest {

	@Test
	public void testAddingRoundPositiveRoundNumbers() {
		Addition addition = new Addition(2.0, 8.0);
		assertEquals(10.0, addition.calculate(), 0.01);
	}

	@Test
	public void testAddingFractionedPositiveRoundNumbers() {
		Addition addition = new Addition(1.5, 1.0);
		assertEquals(2.5, addition.calculate(), 0.01);
	}

	@Test
	public void testAddingRoundNegativeNumbers() {
		Addition addition = new Addition(-10, 8);
		assertEquals(-2.0, addition.calculate(), 0.01);
	}

	@Test
	public void testAddingFractionedNegativeNumbers() {
		Addition addition = new Addition(-2.8, 1.7);
		assertEquals(-1.1, addition.calculate(), 0.01);
	}

}
