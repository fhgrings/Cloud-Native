package com.github.rafaritter44.cloud_native.petstore.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class WaterBathWithoutPerfumeModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Integer.class)
                .annotatedWith(Names.named("WaterBathWithoutPerfumePrice"))
                .toInstance(20);
    }

}
