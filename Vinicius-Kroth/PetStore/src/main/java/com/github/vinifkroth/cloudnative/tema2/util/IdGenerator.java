package com.github.vinifkroth.cloudnative.tema2.util;

import com.google.inject.Singleton;

@Singleton
public class IdGenerator {

	private static Integer idNumber;

	public IdGenerator() {
		idNumber = 0;
	}

	public synchronized Integer generateId() {
		idNumber++;
		return idNumber;
	}
}