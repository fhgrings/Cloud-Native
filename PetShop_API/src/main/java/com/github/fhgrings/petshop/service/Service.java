package com.github.fhgrings.petshop.service;

import com.github.fhgrings.petshop.model.Pet;

public interface Service {
    String execute(boolean option, Pet pet);
}
