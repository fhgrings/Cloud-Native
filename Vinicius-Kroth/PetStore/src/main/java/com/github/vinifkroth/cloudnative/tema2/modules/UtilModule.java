package com.github.vinifkroth.cloudnative.tema2.modules;

import com.github.vinifkroth.cloudnative.tema2.util.IdGenerator;
import com.google.inject.AbstractModule;

public class UtilModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IdGenerator.class);
		
	}

}
