package com.github.rafaritter44.cloud_native.petstore.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ShortHaircutModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Integer.class)
                .annotatedWith(Names.named("ShortHaircutPrice"))
                .toInstance(10);
    }

}
