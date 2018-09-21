package com.github.vinifkroth.cloudnative.tema2.modules;

import com.github.vinifkroth.cloudnative.tema2.service.*;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(DryBathWithoutPerfume.class).to(DryBathWithoutPerfume.class);
		bind(DryBathWithPerfume.class).to(DryBathWithPerfume.class);
		bind(WaterBathWithoutPerfume.class).to(WaterBathWithoutPerfume.class);
		bind(WaterBathWithPerfume.class).to(WaterBathWithPerfume.class);
		bind(LongTrim.class).to(LongTrim.class);
		bind(ShortTrim.class).to(ShortTrim.class);
		bind(AddPet.class).to(AddPet.class);

	}

}
