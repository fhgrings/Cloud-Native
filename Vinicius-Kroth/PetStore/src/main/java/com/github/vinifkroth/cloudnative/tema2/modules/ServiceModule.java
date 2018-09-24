package com.github.vinifkroth.cloudnative.tema2.modules;

import com.github.vinifkroth.cloudnative.tema2.service.*;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(DryBathWithoutPerfume.class);
		bind(DryBathWithPerfume.class);
		bind(WaterBathWithoutPerfume.class);
		bind(WaterBathWithPerfume.class);
		bind(LongTrim.class);
		bind(ShortTrim.class);
		bind(AddPet.class);
		bind(PetStore.class);

	}

}
