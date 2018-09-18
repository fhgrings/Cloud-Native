package com.github.vinifkroth.cloudnative.tema1.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.model.Multiplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })

public class MultiplicationTest {
	@Autowired
	Multiplication multiplication;
	
	@Test
	public void testMultiplicationWithPositiveNumbers() { 
		assertEquals(120, multiplication.calculate(12,10.0) ,0.01);
	}
	
	@Test
	public void testMultiplicationWithNegativeNumbers() { 
		assertEquals(120, multiplication.calculate(-12,-10.0) ,0.01);
	}

}
